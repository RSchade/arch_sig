grammar Algebra;
s : expr ('=' expr)? EOF;
expr : '-'? VL 
    | expr '^' expr 
    | expr ('/' | '*') expr 
    | expr ('+' | '-') expr 
    | '(' expr ')';
VL : NM | VR;
NM : [0-9]+('.'[0-9]+)?;
VR : [a-z]+;
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines