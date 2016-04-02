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
 : Variable Equals (Variable | Int)
 ;

expression
 : Not Variable					#notExpression
 | Variable Add Variable				#addExpression
 | Variable Sub Variable				#subExpression
 | Variable And Variable				#andExpression
 | Variable Or Variable				#orExpression
 ;

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

Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;

WS
 : [ \t\r\n]+ -> skip
 ;
