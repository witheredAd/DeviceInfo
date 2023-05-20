grammar ChordGrammar;

progression: chord ('-' chord)*;

chord: main_part additions;

main_part: RootNode ChordType?;

RootNode: Note [#b]?;
fragment Note: [CDEFGAB];


additions: ChordAddition*;

ChordAddition: 'sus2'
             | 'sus4'
             | BareAdditionPrefix BareAdditionNumber
             ;
fragment BareAdditionPrefix: '#' | 'b' | 'add' | 'no';
fragment BareAdditionNumber:
           '2'
         | '3'
         | '4'
         | '5'
         | '6'
         | '7'
         | '9'
         | '11'
         | '13'
         ;

ChordType: BareChordType BareChordNumber?
         | BareChordNumber
         | '69'
         | '5'
         | '6'
         ;
fragment BareChordType:
           'M'
         | 'm'
         | 'dim'
         | 'aug'
         | 'alt'
         | 'Ionian'
         | 'Dorian'
         | 'Phrygian'
         | 'Lydian'
         | 'Mixolydian'
         | 'Aeolian'
         | 'Locrian'
         ;
fragment BareChordNumber:
           '7'
         | '9'
         | '11'
         | '13'
         ;

WS: [ \t\n\r] -> skip;