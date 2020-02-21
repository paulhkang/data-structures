public class Problem1 extends ExpressionTree
{
	private static String input;

	public Problem1()								// to input a String into superclass ExpressionTree
	{
		super(input);
	}

	
	public static final void main(String[] args)
	{
		input = "34 2 - 5 * 5 7 - /";

		ExpressionTree tree = new ExpressionTree(input);

		System.out.println(tree.eval());

		System.out.println(tree.postfix());
		System.out.println(tree.prefix());
		System.out.println(tree.infix());
	}
}
