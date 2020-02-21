public class ExpressionTree extends MyStack
{
	private String[] nodes;
	private MyStack<ExpressionNode<String>> stack = new MyStack<>();
	private static ExpressionNode<String> root;
	private String expression;


	// heavily based on Weiss, figure 4.16 (implementation of BinaryNode)
	private static class ExpressionNode<String>
	{
		ExpressionNode()
			{ this(null, null, null); }
		
		ExpressionNode(String theElement)
			{ this(theElement, null, null); }

		ExpressionNode(String theElement, ExpressionNode<String> lt, ExpressionNode<String> rt)
			{ element = theElement; left = lt; right = rt; }


		String element;
		ExpressionNode<String> left;
		ExpressionNode<String> right;
	}


	// for debugging purposes, the code prints out a lot of text to the screen after executing certain actions
	public ExpressionTree(String input)
	{
		expression = input;
		nodes = expression.split(" ");

		for(int i = 0; i < nodes.length; i++)
		{
			// either create an operator subtree, or create an operand one-node tree and push it on the stack
			if(nodes[i].equals("+") || nodes[i].equals("-") || nodes[i].equals("*") || nodes[i].equals("/"))
			{
				ExpressionNode<String> rt = new ExpressionNode<String>();			// first pop is the right value
				rt = stack.pop();
//				System.out.println("popped right");
				ExpressionNode<String> lt = new ExpressionNode<String>();			// second pop is the left value
				lt = stack.pop();
//				System.out.println("popped left");


				if(rt.element == null || lt.element == null)					// BUG: returns NullPointerException, not UnderflowExc
				{
					throw new UnderflowException();
				}




				// push operator subtree to the stack
				ExpressionNode<String> operator = new ExpressionNode<String>(nodes[i], lt, rt);	

				stack.push(operator);
//				System.out.println("pushed operaTOR");

				if(i + 1 == nodes.length)							// if you are at the last element
				{
					ExpressionNode<String> last = new ExpressionNode<String>();
					last = stack.pop();							// pop stack and make sure stack is empty

					if(stack.isEmpty() == true)
					{
						root = last;
//						System.out.println("set root");
//						System.out.println(root.element);
					}
					else
					{
						throw new UnderflowException();
					}
				}
			}
			else if(i + 1 == nodes.length)								// throw exception if last element is operand
			{
//				System.out.println("Last element is not an operator.");
				throw new UnderflowException();
			}
			else											// push one-node tree to stack
			{
				ExpressionNode<String> single = new ExpressionNode<String>(nodes[i]);
//				System.out.println("created single node");
				stack.push(single);
//				System.out.println("pushed operand");
			}

//			System.out.println(stack.size());
		}


//		System.out.println("\n\n\n\n");
		

	}





	public int eval()
	{
		return eval(root);
	}

	private int eval(ExpressionNode<String> t)
	{
		if(t.left != null && t.right != null)			// i.e. t is an operator
		{
			int leftval = eval(t.left);
			int rightval = eval(t.right);

			if(t.element.equals("+"))
			{
				return leftval + rightval;
			}
			else if(t.element.equals("-"))
			{
				return leftval - rightval;
			}
			else if(t.element.equals("*"))
			{
				return leftval * rightval;
			}
			else if(t.element.equals("/"))
			{
				return leftval / rightval;
			}
			else
			{
				return -1;
			}

		}
		else
		{
			Integer x = new Integer(t.element);		// eval() on an operand returns the operand value
			return x.parseInt(t.element);
		}

	}




	public String postfix()
	{
		return postfix(root);
	}

	private String postfix(ExpressionNode t)
	{
		StringBuilder builder = new StringBuilder();

		if(t.left != null && t.right != null)			// i.e. t is an operator
		{
		builder.append(postfix(t.left));
		builder.append(" ");
		builder.append(postfix(t.right));
		builder.append(" ");
		}


		builder.append(t.element);

		return builder.toString();
	}








	public String prefix()
	{
		return prefix(root);
	}

	private String prefix(ExpressionNode t)
	{
		StringBuilder builder = new StringBuilder();

		builder.append(t.element);
		builder.append(" ");

		if(t.left != null && t.right != null)			// i.e. t is an operator
		{
		builder.append(prefix(t.left));
		builder.append(prefix(t.right));
		}


		return builder.toString();
	
	}





	// creates an extra set of parentheses around the whole expression
	public String infix()
	{
		return infix(root);
	}

	private String infix(ExpressionNode t)
	{
		StringBuilder builder = new StringBuilder();

		if(t != null)
		{
			if(t.left != null)
				builder.append("(");
			builder.append(infix(t.left));
			builder.append(t.element);
			builder.append(infix(t.right));
			if(t.right != null)
				builder.append(")");
		}


		return builder.toString();


	}


}
