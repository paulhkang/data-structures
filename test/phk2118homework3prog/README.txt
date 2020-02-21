-- ExpressionTree.java --

Defines an ExpressionTree class for use in Problem1.java. The ExpressionTree class takes in a postfix expression, and creates a tree from it.
The class contains methods for evaluating the expression, and printing a postfix, prefix, and infix expression.

Compile using any java compiler.




-- MyStack.java --

Defines the MyStack class used in ExpressionTree.java. This class uses the LinkedList
from java.util to create a stack, which pushes and pops from the front of the list. It also contains other useful methods.


Compile using any java compiler.




-- Problem1.java --

Hard codes an expression, which it then inputs into an ExpressionTree class (from ExpressionTree.java).
Also prints the evaluated expression, as well as a postfix, prefix, and infix version of the original expression.

Compile using any java compiler, and run using a JVM.




-- AvlTree.java --

Defines an AvlTree class for use in Problem2.java. The AvlTree class is slightly modified from Weiss's AvlTree class.
Changes include:	AvlNode changed to contain a LinkedList<Integer>
			printTree() changed to print each node's LinkedList
			methods added to edit/view each node's LinkedList
			findNode() method added to find a node that contains a certain AnyType (in this case, String)
			
Compile using any java compiler, and run using a JVM.



-- UnderflowException.java --

UnderflowException throwable for use in AvlTree.java. (Also used in Problem1.java).

Compile using any java compiler, and run using a JVM.


-- Problem2.java --

Takes in a text file as a command line input, and creates an AvlTree of the words, stripped of punctuation and set to lowercase.
Prints out each word, as well as a list of the lines in which that word is found.

Compile using any java compiler, and run using a JVM.





