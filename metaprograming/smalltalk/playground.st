|instvars instvarss attrs pkg|

Computer superclass subclass: #BufferedNode instanceVariableNames: '' classVariableNames: 'buffer' package: 'Networks'.

"Need to be carefull with the definition of variables, need to be exactly the same as in the original definition"
BufferedNode subclass: #Computer instanceVariableNames: 'varForInstance' classVariableNames: 'id, name' package: 'Networks'.

"Way of doing it programatically"
instvars := Computer instVarNames .
instvarss := String new.
instvars do: [ :i | instvarss := instvarss, i , ' '  ]. 
instvarss withoutSuffix: ', '.

attrs := Computer classVarNames .
pkg := Computer package name.

Node methods first.
Node removeMethod: Node methods first methodName .
Behavior getCompiledMethodFrom: Node.

BufferedNode subclass: #Computer instanceVariableNames: instvarss classVariableNames: attrs package: pkg.


