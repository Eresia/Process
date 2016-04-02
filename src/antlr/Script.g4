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
 : assignVar
 | notExpression
 | operation
 | (Comment)
 ;

assignVar
 : Variable Equals (Variable | Int | hexaDisp)
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

hexaDisp	: ( Hexa );
integerDisp	: Int;

Equals		: '=' ;

Or			: '|' ;
And			: '&' ;
Not			: '!' ;

Add			: '+';
Sub			: '-';

Variable
: 'R' [0-7]
;

Int		: [0-9]+;
Hexa	: [a-zA-Z_0-9]+;

Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;

WS
 : [ \t\r\n]+ -> skip
 ;
