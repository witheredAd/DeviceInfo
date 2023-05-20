package org.withered.tyr.chords.chordTypes

import org.antlr.v4.runtime.tree.RuleNode

enum class ChordFactor(val value: Int) {
    NONE(-1),

    ROOT(0),
    min2(1),
    Maj2(2),
    min3(3),
    Maj3(4),
    pef4(5),
    trit(6),
    pef5(7),
    min6(8),
    Maj6(9),
    min7(10),
    Maj7(11);

    fun next(): ChordFactor{
        return when(this){
            NONE -> NONE
            Maj7 -> ROOT
            else -> getFactorByIth((value + 1) % 12)
        }
    }

    fun prev(): ChordFactor{
        return when(this){
            NONE -> NONE
            Maj7 -> ROOT
            else -> getFactorByIth((value - 1 + 12) % 12)
        }
    }

    companion object{
        /**
         * Only support i = {0, 1, 2, ... 11}. Otherwise, exception.
         *
         * @see kotlin.collections.first .
         */
        fun getFactorByIth(ith: Int): ChordFactor{
            return enumValues<ChordFactor>().first { it.value == ith }
        }
    }

}
