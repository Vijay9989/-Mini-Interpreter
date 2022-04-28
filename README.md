# Mini-Interpreter

The Java platform involves a compilation phase that translates Java code (*.java) to Java Byte Code (*.class), followed by 
an execution phase in which the Java Virtual Machine (java.exe) interprets/evaluates the Java Byte Code. 
There are over 200 Java Byte Code instructions (or opcodes), in this we have to implement a Java Byte Code 
interpreter in two phases, the first supports 13 instructions (see “List of Instructions for Phase1”), and the second supports 
19 additional instructions (see “List of Instructions for Phase2”). Your interpreter (Interpreter.java) is practically a very 
simplistic JVM that uses a Stack data structure to evaluate a list of instructions. Considering the input program below:
Input1:
0: iconst_1
1: iconst_2
2: iadd
3: print
6: return
Using a stack, your interpreter must execute each of the instructions leading to the value 3 being printed on the screen.
Shown below is the effect of each instruction on the stack:
0: iconst_1: push the integer value 1 onto the stack → stack = <1>
1: iconst_2: push the integer value 2 onto the stack → stack = <1, 2>
2: iadd: pop value 2, pop value 1, compute (1+2), then push result onto the stack → stack = <3>
3: print: pop top of stack, then print value on screen → stack = <>
Output: 3
6: return: exit program
(Note: the number at the beginning of each instruction is an identifier that you do not need to worry about until Phase2)
Below is another example:
Input2:
0: iconst_1
1: iconst_2
2: iadd
3: iconst_3
4: imul
5: iconst_4
6: isub
7: print
10: return
Java Code
e.g. HelloWorld.java
Java Compiler
javac.exe
Java Byte Code
e.g. HellowWorld.class
Java Virtual Machine (JVM)
Java.exe
Interprets HellowWorld.class
3
Here, your interpreter must print the value 5 on the screen.
0: iconst_1: push the integer value 1 onto the stack → stack = <1>
1: iconst_2: push the integer value 2 onto the stack → stack = <1, 2>
2: iadd: pop value 2, pop value 1, compute (1+2), then push result onto the stack → stack = <3>
3: iconst_3: push the integer value 3 onto the stack → stack = <3,3>
4: imul: pop value 3, pop value 3, compute (3*3), then push result onto the stack → stack = <9>
5: iconst_4: push the integer value 4 onto the stack → stack = <9, 4>
6: isub: pop value 4, pop value 9, compute (9-4), then push result onto the stack → stack = <5>
7: print: pop top of stack, then print value on screen → stack = <>
Output: 5
10: return: exit program
The above two examples illustrate the functionality to be supported in Phase1 of the project. For Phase1, your interpreter 
must use a Linked List (to store the instructions) and a Stack to enable the evaluation of the input program. The list of 
instructions to be supported in Phase1 are described below.
List of Instructions for Phase1 (13 instructions):
iconst_0 push the int value 0 onto the stack
iconst_1 push the int value 1 onto the stack
iconst_2 push the int value 2 onto the stack
iconst_3 push the int value 3 onto the stack
iconst_4 push the int value 4 onto the stack
iconst_5 push the int value 5 onto the stack
bipush byte push a "byte" value onto the stack (note how this instruction takes in one parameter)
iadd pop value1, pop value2, compute (value2 + value1), push result onto the stack
imul pop value1, pop value2, compute (value2 * value1), push result onto the stack
idiv pop value1, pop value2, compute (value2 / value1), push result onto the stack
isub pop value1, pop value2, compute (value2 - value1), push result onto the stack
irem pop value1, pop value2, compute (value2 % value1), push result onto the stack
print pop value off the stack and print it to screen

Phase2
For Phase2 of the project, your interpreter must additionally use one or more instances of a Hash Map (that you need to 
implement). The list of additional instructions to be supported in Phase2 are described below.
List of Additional Instructions for Phase2 (19 instructions):
// reading values from variables and pushing them onto stack
iload_0 push value from variable 0 
iload_1 push value from variable 1
iload_2 push value from variable 2
iload_3 push value from variable 3
iload index push value from variable designated by "index"
// popping values from stack and storing them in variables
istore_0 pop value and store into variable 0
istore_1 pop value and store into variable 1
istore_2 pop value and store into variable 2
4
istore_3 pop value and store into variable 3
istore index pop value and store into variable designated by "index"
// incrementing a variable
iinc index, value increment variable designated by "index" by value (not need to push/pop)
// jumps and conditionals
goto location unconditionally jump to instruction "location" 
if_icmpeq location pop value1 and value2, if equal, branch to instruction at "location"
if_icmpne location pop value1 and value2, if not equal, branch to "location"
if_icmpge location pop value1 and value2, if value2 is greater than or equal to value1, branch to "location"
if_icmpgt location pop value1 and value2, if value2 is greater than value1, branch to "location"
if_icmple location pop value1 and value2, if value2 is less than or equal than value1, branch to at "location"
if_icmplt location pop value1 and value2, if value2 is less than value1, branch to "location"
ifne location pop value, if value is not 0, branch to location
Note how some of the additional instructions involve: a) reading and pushing values from variables (iload*); and b)
popping and storing values to variables (istore*). For that reason, you need to use a Hash Map to map each variable to its 
current value. The key in such Hash Map must uniquely identify a variable; in this project, you should use the “index” of 
the given variable. In Java, the index of a (local) variable is an integer that uniquely identifies that variable. For example 
in “public static void main(String [] args) { int x, y, z;…}”, the index for x is 1, for y it is 2, and for z it is 3.
Provided below are two examples that highlight the additional requirements for Phase2.
Input3:
As stated earlier, for Phase2 the interpreter must use a stack and a hashmap (possibly more than one). The stack is used to 
push and pop integer values, and the hashmap is used to map the index of a variable to its integer value. Let’s walk 
through the steps taken by the interpreter to output the value 9. We will show the effect of each instruction on the stack
and the hashmap (abbreviated as hm):
0: iconst_4: push the integer value 4 onto the stack → stack = <4>, hm = {}
1: istore_1: pop value and store into variable 1 (i.e., x) → stack = <>, hm = {(1,4)}
2: iconst_5: push the integer value 5 onto the stack → stack = <5>, hm = {(1,4)}
3: istore_2: pop value and store into variable 2 (i.e., y) → stack = <>, hm = {(1,4), (2,5)}
4: iload_1: push value from variable 1 → stack = <4>, hm = {(1,4), (2,5)}
5: iload_2: push value from variable 2 → stack = <4, 5>, hm = {(1,4), (2,5)}
6: iadd: pop value 5, pop value 4, compute (4+5), then push result → stack = <9>, hm = {(1,4), (2,5)}
7: istore_3: pop value and store into variable 3 (i.e., z) → stack = <>, hm = {(1,4), (2,5), (3,9)}
8: iload_3: push value from variable 3 → stack =<9>, hm ={(1,4), (2,5), (3,9)}
9: print: pop 9 and print it to screen → stack = <>, hm = {(1,4), (2,5), (3,9)}
Output: 9
10: return: exit program
// Java equivalent code provided 
// for clarification only
int x, y, z;
x = 4;
y = 5;
z = x + y;
print(z); 
0: iconst_4
1: istore_1
2: iconst_5
3: istore_2
4: iload_1
5: iload_2
6: iadd
7: istore_3
8: iload_3
9: print 
12: return
Masri/Russell/Zhong Project 2: Linked Lists, Stacks, Hash Maps CS310 – Fall 2021
5
The code in Input3 does not include any conditionals such as if statements or loops. We now walk through the steps for 
Input4, which includes an if-else. Note that in the presence of if or if-else some instructions might be skipped, and in the 
presence of loops some instructions might get executed more than once. At the end of this document we present Input5,
an input program that involves a loop.
