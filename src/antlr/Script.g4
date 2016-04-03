grammar Script;

@header {
	package antlr;
}

parse
 : (block) EOF
 ;

block
 : (line (Comment)?)*
 ;

line
 : ((assignVar  | notExpression  | operation | gotoExpression | labelExpression)  EndLine) | Comment
 ;

assignVar
 : Variable Equals (Variable | integerDisp | hexaDisp)
 ;

notExpression
 : Not Variable
 ;

operation
 : Variable Add Variable
 | Variable Sub Variable
 | Variable And Variable
 | Variable Or Variable
 ;

hexaDisp	: Hexa;
integerDisp	: Int;

gotoExpression	: GotoBegin LabelId;
labelExpression	: LabelBegin LabelId;

Equals		: '=' ;

Or			: '|' ;
And			: '&' ;
Not			: '!' ;

Add			: '+';
Sub			: '-';

EndLine		: ';';

LabelBegin 	: ('l' | 'L') ('a' | 'A') ('b' | 'B') ('e' | 'E') ('l' | 'L');
GotoBegin 	: ('g' | 'G') ('o' | 'O') ('t' | 'T') ('o' | 'O');

Variable
: ('R' | 'r') [0-7]
;

Hexa	: HexaOpen ([a-f] | [A-F] | [0-9])+;
Int		: [0-9]+;

HexaOpen	:	'0x';

LabelId 	: ([a-z] | [A-Z])+;

Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;

WS
 : [ \t\r\n]+ -> skip
 ;
