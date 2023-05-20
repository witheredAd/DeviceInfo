package org.withered.tyr.chords

import org.withered.tyr.chords.chordTypes.*
import org.withered.tyr.chords.chordTypes.ChordFactor.*
import org.withered.tyr.chords.parsers.ChordGrammarBaseVisitor
import org.withered.tyr.chords.parsers.ChordGrammarParser

class UnknownParseException(private val errInfo: String): Exception(errInfo){
}

class MyChordGrammarVisitor(val chordNotesList: MutableList<List<Int>>) : ChordGrammarBaseVisitor<Unit>() {
    var currentChord: AbstractChordType? = null

    override fun visitChord(ctx: ChordGrammarParser.ChordContext?): Unit {
        val mainPart = ctx?.main_part()
            ?: throw UnknownParseException("ctx=${ctx}, main_part=${ctx?.main_part()}")

        val rootNode = mainPart.RootNode()
            ?: throw UnknownParseException("ctx=${ctx}, main_part=${ctx.main_part()}, rootNode=${mainPart.RootNode()}")

        val chordType = mainPart.ChordType()?.symbol?.text ?: "M"
/*
        var notes = when(chordType){
            "69" -> arrayListOf(ROOT, Maj2, Maj3, Maj6)
            "5"  -> arrayListOf(ROOT, pef5)
            "6"  -> arrayListOf(ROOT, Maj3, pef5, Maj6)
            else -> TODO("你先别急")
        }*/

        val chord = parseChordType(chordType)
        currentChord = chord

        visit(ctx.additions())
        chordNotesList.add(chord.getIntScaleWithOffset(parseRootNode(rootNode.text)))
    }

    override fun visitAdditions(ctx: ChordGrammarParser.AdditionsContext?) {
        if(ctx?.ChordAddition()?.isEmpty() != false)        // true or null
            return

        val chord = currentChord ?: throw UnknownParseException("currentChord=null, ctx.text=${ctx.text}")

        val pattern = Regex("^(add|no|#|b)?(2|3|4|5|6|7|9|11|13)\$")
        for(addition in ctx.ChordAddition()){
            val text = addition.symbol.text

            if(text == "sus2")
                chord.no(3).add(2)
            else if(text == "sus4")
                chord.no(3).add(4)
            else {
                val groupValues =
                    pattern.find(text)?.groupValues ?: throw UnknownParseException("Addition=${text} regex find null")
                assert(groupValues.size == 3)
                val additionTypeStr = groupValues[1]
                val additionNumberStr = groupValues[2]
                val ith = additionNumberStr.toInt()

                when (additionTypeStr) {
                    "#" -> chord.`#`(ith)
                    "b" -> chord.b(ith)
                    "add" -> chord.add(ith)
                    "no" -> chord.no(ith)
                }
            }
        }
    }

    private fun parseRootNode(str: String): Int{
        val pattern = Regex("^([CDEFGAB])([#b])?\$")
        val groupValues = pattern.find(str)?.groupValues ?: throw UnknownParseException("RootNode=${str} regex find null")
        assert(groupValues.size == 3)
        val baseABCStr = groupValues[1]
        val baseSFStr = groupValues[2]
        return when(baseABCStr){
            "C" -> 60
            "D" -> 62
            "E" -> 64
            "F" -> 65
            "G" -> 67
            "A" -> 69
            "B" -> 71
            else -> throw UnknownParseException("baseABCStr=${baseABCStr} unmatch when statement")
        } + when(baseSFStr){
            "#" -> 1
            "b" -> -1
            ""  -> 0
            else -> throw UnknownParseException("baseSFStr=${baseSFStr} unmatch when statement")
        };
    }

    private fun parseChordType(str: String): AbstractChordType{
        val pattern = Regex("^(M|m|dim|aug|alt|Ionian|Dorian|Phrygian|Lydian|Mixolydian|Aeolian|Locrian)?(7|9|11|13)?\$")
        val groupValues = pattern.find(str)?.groupValues ?: throw UnknownParseException("ChordType=${str} regex find null")
        assert(groupValues.size == 3)
        val baseChordTypeStr = groupValues[1]
        val baseChordNumberStr = groupValues[2]
        val nth = if(baseChordNumberStr.isEmpty()) 5 else baseChordNumberStr.toInt()

        return when(baseChordTypeStr){
            "M", "Ionian" -> MajorChord(nth)
            "m", "Aeolian" -> MinorChord(nth)
            "alt" -> AlteredChord(nth)
            "Dorian" -> Dorian(nth)
            "Phrygian" -> Phrygian(nth)
            "Lydian" -> Lydian(nth)
            "", "Mixolydian" -> Mixolydian(nth)
            "Locrian" -> Locrian(nth)
            "dim" -> WholeHalfDiminished(nth)
            "aug" -> Augmented(nth)
            else -> throw UnknownParseException("baseChordTypeStr=${baseChordTypeStr}, num=${baseChordNumberStr}")
        }
    }
}