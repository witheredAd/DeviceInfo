package org.withered.tyr.chords.chordTypes

import org.withered.tyr.chords.chordTypes.ChordFactor.*

class MajorChord(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, Maj3, pef4, pef5, Maj6, Maj7)) {
}

class MinorChord(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, min3, pef4, pef5, min6, min7)) {
}


class AlteredChord(nth: Int): Heptachord(nth,
    listOf(ROOT, min2, min3, Maj3, trit, min6, min7)) {
}

class Dorian(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, min3, pef4, pef5, Maj6, min7)) {
}
class Phrygian(nth: Int): Heptachord(nth,
    listOf(ROOT, min2, min3, pef4, pef5, min6, min7)) {
}
class Lydian(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, Maj3, trit, pef5, Maj6, Maj7)) {
}
class Mixolydian(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, Maj3, pef4, pef5, Maj6, min7)) {
}
class Locrian(nth: Int): Heptachord(nth,
    listOf(ROOT, min2, min3, pef4, trit, min6, min7)) {
}



// Interesting 八声音阶 TODO("换成别的父类？比如说增七啊，指的应该是13#5b7吧？现在只能用Augmented(5).add(6)了")

class HalfWholeDiminished(nth: Int): Heptachord(nth,
    listOf(ROOT, min2, min3, Maj3, trit, pef5, Maj6, min7))
class WholeHalfDiminished(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, min3, pef4, trit, min6, Maj6, Maj7))

// 六声

class Augmented(nth: Int): Heptachord(nth,
    listOf(ROOT, Maj2, Maj3, trit, min6, min7))