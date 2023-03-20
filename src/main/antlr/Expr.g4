grammar Expr;

/* import antlr to every generated classes */
@header {
package com.neil3d2y.antlr.generated;
}

/* define program */
/* program is a list of mixing declarations and expressions */
prog: (decl | expr)+ EOF        # Program
    ;

/* declarations */
decl: ID ':' INT_TYPE '=' NUM   # Declaration
    ;

/* antlr resolves ambiguities in in favor of the alternative given first*/
expr: expr '*' expr             # Multiplication
    | expr '+' expr             # Addition
    | ID                        # Variable
    | NUM                       # Number
    ;


/* Tokens */

ID: [a-z][a-zA-Z0-9]*; //identifiers
NUM: '0' | '-'?[1-9][0-9]*;
INT_TYPE : 'INT';
COMMENT : '--' ~[\r\n]* -> skip;
/* whitespaces */
WS: [ \t\n]+ -> skip;

