package org.withered.tyrh

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.mamoe.mirai.console.extension.PluginComponentStorage
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.events.BotOnlineEvent
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.info
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.withered.tyr.chords.MyChordGrammarVisitor
import org.withered.tyr.chords.parsers.ChordGrammarLexer
import org.withered.tyr.chords.parsers.ChordGrammarParser
import oshi.SystemInfo
import oshi.hardware.*
import java.io.ByteArrayInputStream
import java.io.IOException
import java.text.DecimalFormat
import java.util.*
import javax.sound.midi.MidiEvent
import javax.sound.midi.MidiSystem
import javax.sound.midi.Sequence
import javax.sound.midi.ShortMessage
import javax.sound.sampled.AudioFileFormat
import javax.sound.sampled.AudioSystem


object DeviceInfo : KotlinPlugin(
    JvmPluginDescription.loadFromResource()
) {
    @Serializable
    data class Config(
        val qq: Long = 3376249553L,
        val admin: Long = 872100336L,
        val command: String = "状态",
        val command2: String = "进行"
    )
    val MAX_CONFIG_SIZE = 1048576   // bytes

    private var config = Config()

    override fun PluginComponentStorage.onLoad() {
        logger.info { "TYR Device Info Loading" }

        val defaultJson = Json.encodeToString(config)

        val configFile = resolveConfigFile("settings.json")
        if (!configFile.exists())
            configFile.bufferedWriter().use { it.write(defaultJson) }

        if (!configFile.isFile) {
            logger.error("无法创建 settings.json，使用默认设置")
        }else if(configFile.length() > MAX_CONFIG_SIZE){
            logger.error("异常的 settings.json，使用默认设置")
        }else{
            config = Json.decodeFromString<Config>(configFile.bufferedReader().use { it.readText() } )
        }

        logger.info { "TYR Device Info Loaded. Running with: $config" }
    }

    override fun onEnable() {
        logger.info { "TYR Device Info Enabled" }

        this.globalEventChannel().filter {
            it is FriendMessageEvent && it.bot.id == config.qq && it.sender.id == config.admin
        }.subscribeAlways<FriendMessageEvent> { event ->
            // 状态 -- command
            if(event.message.content.startsWith(config.command)) {
                val paramString = event.message.content.subSequence(config.command.length, event.message.content.length)
                event.sender.sendMessage(getDeviceInfo(paramString.split(' ').filter { it != "" }))
            }

            // 进行 -- command2
            if(event.message.content.startsWith(config.command2)) {
                val paramString = event.message.content
                    .subSequence(config.command2.length, event.message.content.length).trim()  as String
                event.sender.sendMessage(getProgression(paramString))
                event.sender.sendMessage(
                    getProgressionAudio(paramString).use {
                    event.sender.uploadAudio(it)
                })
                // event.sender.uploadAudio()
            }
        }

        // 进行 -- command2 -- group
        this.globalEventChannel().filter {
            it is GroupMessageEvent && it.bot.id == config.qq
        }.subscribeAlways<GroupMessageEvent> { event ->
            if(event.message.content.startsWith(config.command2)) {
                val paramString = event.message.content
                    .subSequence(config.command2.length, event.message.content.length).trim() as String
                event.group.sendMessage(
                    getProgressionAudio(paramString).use {
                        event.group.uploadAudio(it)
                    })
            }
        }

        this.globalEventChannel().filter {
            it is BotOnlineEvent && it.bot.id == config.qq
        }.subscribeAlways<BotOnlineEvent> { event ->

            val admin = event.bot.getFriend(config.admin)
            if(admin != null)
                admin.sendMessage(getWelcomeMessage())
        }
    }


    private fun getProgressionAudio(paramString: String): ExternalResource {
        val midiFile = resolveDataFile("${paramString}.midi")

        val chords = getIntArrayChords(paramString)
        println(chords)

        val sequence = Sequence(Sequence.PPQ, 24)
        val track = sequence.createTrack()
        var tick = 0L
        val velocity = 64
        val channel = 0

        for (chord in chords) {
            for (noteNumber in chord) {
                val noteOn = ShortMessage(ShortMessage.NOTE_ON, channel, noteNumber, velocity)
                val noteOff = ShortMessage(ShortMessage.NOTE_OFF, channel, noteNumber, 0)
                val noteOnEvent = MidiEvent(noteOn, tick)
                val noteOffEvent = MidiEvent(noteOff, tick + 96)
                track.add(noteOnEvent)
                track.add(noteOffEvent)
            }
            tick += 96
        }

        MidiSystem.write(sequence, 1, midiFile)

        AudioSystem.write(
            AudioSystem.getAudioInputStream(
                midiFile
            ),
            AudioFileFormat.Type.WAVE,
            resolveDataFile("${paramString}.wav"))

        convertWavToMp3(
            resolveDataFile("${paramString}.wav").absolutePath,
            resolveDataFile("${paramString}.map").absolutePath)

        return resolveDataFile("${paramString}.wav").toExternalResource()
    }

    @Throws(IOException::class, InterruptedException::class)
    private fun convertWavToMp3(inputPath: String, outputPath: String) {
        val command: MutableList<String> = ArrayList()
        command.add("ffmpeg")
        command.add("-i")
        command.add(inputPath)
        command.add("-q:a")
        command.add("0")
        command.add("-y")
        command.add(outputPath)
        val builder = ProcessBuilder(command)
        builder.redirectErrorStream(true)
        val process = builder.start()
        process.waitFor()
    }

    private fun getProgression(str: String): String {
        val chordGrammarLexer = ChordGrammarLexer(
            ANTLRInputStream(
                ByteArrayInputStream(str.toByteArray())
            )
        )
        val tokenStream = CommonTokenStream(chordGrammarLexer)
        val parser = ChordGrammarParser(tokenStream)
        val parseTree = parser.progression()

        return parseTree.toStringTree(parser)
    }

    private fun getIntArrayChords(str: String): List<List<Int>> {
        val chordGrammarLexer = ChordGrammarLexer(
            ANTLRInputStream(
                ByteArrayInputStream(str.toByteArray())
            )
        )
        val tokenStream = CommonTokenStream(chordGrammarLexer)
        val parser = ChordGrammarParser(tokenStream)
        val parseTree = parser.progression()

        val nodeList = mutableListOf<List<Int>>()
        val chordGrammarVisitor = MyChordGrammarVisitor(nodeList)
        chordGrammarVisitor.visit(parseTree)

        return nodeList
    }

    private fun getWelcomeMessage() : String {
        val si = SystemInfo()
        val sb = StringBuilder()
        si.hardware.networkIFs.filter { it.isConnectorPresent }.map {
            if(sb.isNotEmpty())
                sb.append(", ")
            sb.append(Arrays.toString(it.iPv4addr) + "@" + it.name)
        }
        return "千代凛，running on " + if(sb.isEmpty()) "unknown" else sb.toString()
    }

    suspend private fun getDeviceInfo(params: List<String>): String {
        val sb = StringBuilder()

        val si = SystemInfo()
        val hal: HardwareAbstractionLayer = si.hardware

        if (params.find { it == "网络" } != null) {
            val nets: MutableList<NetworkIF>? = hal.networkIFs
            sb.append("网络开始===========" + "\n")
            if (nets != null) {
                for (net in nets) {
                    sb.append("ipv4" + Arrays.toString(net.iPv4addr) + "\n")
                    sb.append("网络接收" + net.bytesRecv + "字节" + "\n")
                    sb.append("网络发送" + net.bytesSent + "字节" + "\n")
                    sb.append("显示名称" + net.displayName + "\n")
                    sb.append("mac地址" + net.macaddr + "\n")
                    sb.append("ipv6" + Arrays.toString(net.iPv6addr) + "\n")
                    sb.append("名称" + net.name + "\n")
                    sb.append("速度" + net.speed + "千兆/百兆" + "\n")
                    sb.append("发包" + net.packetsSent + "\n")
                    sb.append("收包" + net.packetsRecv + "\n")
                }
            }
            sb.append("网络结束===========" + "\n")
        }


        if (params.find { it == "硬盘" } != null) {
            val diskStores: MutableList<HWDiskStore>? = hal.diskStores
            sb.append("硬盘信息开始===========" + "\n")
            if (diskStores != null) {
                for (diskStore in diskStores) {
                    sb.append("名称" + diskStore.name + "\n")
                    sb.append("大小" + diskStore.size + "\n")
                    //对应着设备看，我的是希捷的
                    // ST：代表bai希捷
                    // 3：代表du3.5吋硬盘zhi
                    // 500：代表硬盘容量为500G
                    // 4：指的是dao硬盘的缓存数zhuan是16M(2的4次方)
                    // 1：代表1张盘片shu
                    // 8：版本号，也可能对应产地等
                    // AS：Serial ATA，即 SATA 硬盘接口。（A，代表ATA接口）
                    sb.append("硬盘详细信息" + diskStore.model + "\n")
                    sb.append("串行接口" + diskStore.serial + "\n")
                    sb.append("当前队列长度" + diskStore.currentQueueLength + "\n")
                }
            }
            sb.append("硬盘信息结束===========" + "\n")
        }

        if (params.find { it == "电源" } != null) {
            val powerSources: MutableList<PowerSource>? = hal.powerSources
            sb.append("电源开始==========" + "\n")
            if (powerSources != null) {
                for (powerSource in powerSources) {
                    sb.append("电源名称" + powerSource.name + "\n")
                    sb.append("剩余时间" + powerSource.timeRemainingEstimated + "\n")
                    sb.append("剩余容量" + powerSource.remainingCapacityPercent + "\n")
                }
            }
            sb.append("电源结束==========" + "\n")
        }


        if (params.find { it == "声卡" } != null) {
            val soundCards: MutableList<SoundCard>? = hal.soundCards
            sb.append("声卡开始==========" + "\n")
            if (soundCards != null) {
                for (soundCard in soundCards) {
                    sb.append("名称" + soundCard.name + "\n")
                    //编译码器。指的是数字通信中具有编码、译码功能的器件。
                    sb.append("多媒体数字信号编解码器" + soundCard.codec + "\n")
                    sb.append("运行版本" + soundCard.driverVersion + "\n")
                }
            }
            sb.append("声卡结束==========" + "\n")
        }
        //tree代表是否用嵌套结构进行展示
        //tree代表是否用嵌套结构进行展示

        if (params.find { it == "USB" } != null) {
            val usbDevices: MutableList<UsbDevice>? = hal.getUsbDevices(true)
            sb.append("usb设备开始============" + "\n")
            if (usbDevices != null) {
                for (usbDevice in usbDevices) {
                    sb.append("名称" + usbDevice.name + "\n")
                    sb.append("产品id" + usbDevice.productId + "\n")
                    sb.append("序列号" + usbDevice.serialNumber + "\n")
                    sb.append("设备厂商" + usbDevice.vendor + "\n")
                    sb.append("设备厂商id" + usbDevice.vendorId + "\n")
                }
            }
            sb.append("usb设备结束============" + "\n")
        }

        if (params.find { it == "系统" } != null) {
            val computerSystem: ComputerSystem = hal.computerSystem
            sb.append("电脑系统开始=========" + "\n")
            sb.append("模型" + computerSystem.model + "\n")
            sb.append("序列号" + computerSystem.serialNumber + "\n")
            sb.append("制造商" + computerSystem.manufacturer + "\n")
            sb.append("底板开始========" + "\n")
            val baseboard = computerSystem.baseboard
            sb.append("版本" + baseboard.version + "\n")
            sb.append("序列号" + baseboard.serialNumber + "\n")
            sb.append("模型" + baseboard.model + "\n")
            sb.append("厂商" + baseboard.manufacturer + "\n")
            sb.append("底板结束========" + "\n")
            val firmware = computerSystem.firmware
            sb.append("固件开始==========" + "\n")
            sb.append("固件名" + firmware.name + "\n")
            sb.append("厂商" + firmware.manufacturer + "\n")
            sb.append("固件描述" + firmware.description + "\n")
            sb.append("发布日期" + firmware.releaseDate + "\n")
            sb.append("固件结束==========" + "\n")
            sb.append("电脑系统结束=========" + "\n")
        }


        if (params.find { it == "监控" } != null) {
            sb.append("监控开始===============" + "\n")
            val sensors: Sensors = hal.getSensors()
            sb.append("风扇转速" + Arrays.toString(sensors.fanSpeeds) + "\n")
            sb.append("cpu温度" + sensors.cpuTemperature + "\n")
            sb.append("cpu电压" + sensors.cpuVoltage + "\n")

            val processor = hal.processor //获取cpu信息

            val prevTicks = processor.systemCpuLoadTicks
            delay(1000L)
            val ticks = processor.systemCpuLoadTicks
            val nice = ticks[CentralProcessor.TickType.NICE.index] - prevTicks[CentralProcessor.TickType.NICE.index]
            val irq = ticks[CentralProcessor.TickType.IRQ.index] - prevTicks[CentralProcessor.TickType.IRQ.index]
            val softirq =
                ticks[CentralProcessor.TickType.SOFTIRQ.index] - prevTicks[CentralProcessor.TickType.SOFTIRQ.index]
            val steal = ticks[CentralProcessor.TickType.STEAL.index] - prevTicks[CentralProcessor.TickType.STEAL.index]
            val cSys = ticks[CentralProcessor.TickType.SYSTEM.index] - prevTicks[CentralProcessor.TickType.SYSTEM.index]
            val user = ticks[CentralProcessor.TickType.USER.index] - prevTicks[CentralProcessor.TickType.USER.index]
            val iowait =
                ticks[CentralProcessor.TickType.IOWAIT.index] - prevTicks[CentralProcessor.TickType.IOWAIT.index]
            val idle = ticks[CentralProcessor.TickType.IDLE.index] - prevTicks[CentralProcessor.TickType.IDLE.index]
            val totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal

            sb.append("cpu标识" + processor.processorIdentifier + "\n")
            sb.append("cpu频率" + processor.currentFreq + "\n")
            sb.append("cpu块数" + processor.logicalProcessorCount + "\n")
            sb.append("cpu占用" + DecimalFormat("#.##").format(1.0 - idle * 1.0 / totalCpu)) //cpu使用率

            val memory: GlobalMemory = hal.getMemory()

            sb.append("内存占用" + ((memory.total - memory.available) * 1.0 / 1024 / 1024).toString() + "MB / " + (memory.total * 1.0 / 1024 / 1024).toString() + "MB")

            sb.append("监控结束===============" + "\n")
        }

        return sb.toString().removeSuffix("\n").ifEmpty { "Online" }
    }
}