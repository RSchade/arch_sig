grammar Algebra;
s : expr EOF;
expr : MIN? VL
    | expr EXP expr
    | expr MDIV expr
    | expr PMIN expr
    | '(' expr ')';
MIN : '-';
EXP : '^';
MDIV : '/' | '*';
PMIN : '+' | MIN;
VL : NM;
NM : [0-9]+('.'[0-9]+)?;
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines