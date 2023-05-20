package org.withered.tyr.chords.chordTypes

/**
 * **Only support odd number initialization.**
 */
abstract class Heptachord(nth: Int, baseScale: List<ChordFactor>): AbstractChordType(baseScale) {
    override var scale = mutableListOf<ChordFactor>()

    init {
        assert(nth % 2 == 1)

        for (i in 1..nth step 2) {
            add(i)
        }
    }
}