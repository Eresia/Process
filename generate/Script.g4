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
 | expression
 | (Comment)
 ;

assignVar
 : Variable Equals Int
 ;

expression
 : Not Int					#notExpression
 | Int Add Int				#addExpression
 | Int Sub Int				#subExpression
 | Int And Int				#andExpression
 | Int Or Int				#orExpression
 ;

Equals		: '=' ;

Or			: '|' ;
And			: '&' ;
Not			: '!' ;

Add			: '+';
Sub			: '-';

Variable
: 'R0'
| 'R1'
| 'R2'
| 'R3'
| 'R4'
| 'R5'
| 'R6'
| 'R7'
;

Int		: [0-9]+;

Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;

WS
 : [ \t\r\n]+ -> skip
 ;
