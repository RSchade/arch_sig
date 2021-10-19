grammar Algebra;
s : expr EOF;
expr : MIN? VL
    | expr EXP expr
    | expr (MULT | DIV) expr
    | expr (PLUS | MIN) expr
    | '(' expr ')';
MIN : '-';
EXP : '^';
MULT : '*';
DIV : '/';
PLUS : '+';
VL : NM;
NM : [0-9]+('.'[0-9]+)?;
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines