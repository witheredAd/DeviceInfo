package org.withered.tyr.chords.chordTypes

abstract class AbstractChordType(
    /**
     * The base scale of the chord. Such as a Major scale `[ROOT, Maj2, Maj3, pef4, pef5, Maj6, Maj7]`
     */
    val baseScale: List<ChordFactor>) {

    abstract var scale: MutableList<ChordFactor>

    init {
        assert(baseScale.isNotEmpty())
    }

    /**
     * Remove the `ith_` factor from the target chord, according to the [baseScale].
     *
     * The parameter `ith_` will be automatically modulo-ed to be a number between 1 and [baseScale].size. For example,
     * you can use `ith_ = 2` as well as `ith_ = 9` in a [MajorChord], which make the same sense.
     *
     * **Support chain calling.**
     **/
    fun no(ith_: Int): AbstractChordType{
        val ith = getIth(ith_)
        scale.removeIf { it == baseScale[ith] }
        return this
    }

    /**
     * Add the `ith_` factor to the target chord, according to the [baseScale].
     *
     * The parameter `ith_` will be automatically modulo-ed to be a number between 1 and [baseScale].size. For example,
     * you can use `ith_ = 2` as well as `ith_ = 9` in a [MajorChord], which make the same sense.
     *
     * **Support chain calling.**
     **/
    fun add(ith_: Int): AbstractChordType{
        val ith = getIth(ith_)
        this.no(ith_)
            .scale.add(baseScale[ith])
        return this
    }

    /**
     * Sharp the `ith_` factor of the target chord if `ith_` factor exists in [baseScale]. And do nothing if not,
     * such as a 3rd factor in C5.
     *
     * **Note that this method will automatically remove the `ith_` factor.** But you can still make chords like b9#9.
     *
     * The parameter `ith_` will be automatically modulo-ed to be a number between 1 and [baseScale].size. For example,
     * you can use `ith_ = 2` as well as `ith_ = 9` in a [MajorChord], which make the same sense.
     *
     * **Support chain calling.**
     **/
    fun sharp(ith_: Int): AbstractChordType{
        val ith = getIth(ith_)
        this.no(ith_)
            .scale.add(baseScale[ith].next())

        return this
    }

    /** @see sharp
     */
    fun `#`(ith_: Int): AbstractChordType{
        return this.sharp(ith_)
    }

    /**
     * Flat the `ith_` factor of the target chord if `ith_` factor exists in [baseScale]. And do nothing if not,
     * such as a 3rd factor in C5.
     *
     * **Note that this method will automatically remove the `ith_` factor.** But you can still make chords like b9#9.
     *
     * The parameter `ith_` will be automatically modulo-ed to be a number between 1 and [baseScale].size. For example,
     * you can use `ith_ = 2` as well as `ith_ = 9` in a [MajorChord], which make the same sense.
     *
     * **Support chain calling.**
     **/
    fun flat(ith_: Int): AbstractChordType{
        val ith = getIth(ith_)
        this.no(ith_)
            .scale.add(baseScale[ith].prev())

        return this
    }

    /** @see flat
     */
    fun b(ith_: Int): AbstractChordType{
        return this.flat(ith_)
    }

    private fun getIth(ith_: Int) = (ith_ - 1) % baseScale.size

    fun getIntScaleWithOffset(offset: Int): List<Int>{
        return scale.map { it.value + offset }
    }
}

