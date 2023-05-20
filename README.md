# DeviceInfo
A mirai plugin capable of generating chord progression sounds based on text, applied in Tiyo Rin.

## Usage

This plugin parses an identical formal language which describes chords or chord progressions, and then generates sounds with MIDI.

The language has the form below:

```
FM7-G7-Em add9-Am9
```

which is similar to the common expressions.

The language currently support:

1. Chord Types:
   - Major Chord _or Ionian_: `M`, `Ionian`
   - Minor Chord _or Aeolian_: `m`, `Aeolian`
   - Dominant Chord _or Mixolydian_: ` `(_with any number_), `Mixolydian`
   - Diminished Chord: `dim`
   - Augmented Chord: `aug`
   - _Dorian_: `Dorian`
   - _Phrygian_: `Phrygian`
   - _Lydian_: `Lydian`
   - _Locrian_: `Locrian`
   - **Below are working in progress...**
   - [ ] Six Chord: `6`
   - [ ] Nine Chord: `9`
   - [ ] Six Nine Chord: `69`
   - [ ] Perfect 5th: `5`

2. Chord Additions:
    - Add: `add`
    - No or Omit: `no`
    - Sus: `sus`
    - Sharp: `#` (_which is_ `U+0023`, **NOT** `U+266F`)
    - Flat: `b` (_which is_ `U+0062`, **NOT** `U+266D`)

3. Chord Inversion:
    - **Working in progress..**
    - [ ] Slash: `/`

4. Chord Positioning:
    - **Working in progress..**
    - [ ] Built-in positions
    - [ ] Custom positions: `[1,2,3,b5]+`

5. Melody Writing:
    - **Working in progress..**


We use AntLR to describe our grammar. You can find the grammar definition in `ChordGrammar.g4`.

