public class TwoStackQueue<AnyType> extends MyStack implements MyQueue<AnyType>
{

	MyStack<AnyType> stack1 = new MyStack<>();
	MyStack<AnyType> stack2 = new MyStack<>();
	

	private int size;


	public void enqueue(AnyType x)
	{
		stack1.push(x);
	}

	public AnyType dequeue()
	{
		while(stack2.isEmpty() == true)
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}

		if(!stack2.isEmpty())
			return stack2.pop();
		else
			return null;
	}

	public boolean isEmpty()
	{
		if(size > 0)
			return false;
		else
			return true;
	}

	public int size()
	{
		size = stack1.size() + stack2.size();

		return size;
	}
}
