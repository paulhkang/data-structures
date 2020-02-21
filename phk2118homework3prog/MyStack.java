import java.util.*;

public class MyStack<AnyType>
{
	LinkedList<AnyType> myStack = new LinkedList<>();	



	private final int INIT_SIZE = 0;


	private int theSize = INIT_SIZE;




	public void push(AnyType value)
	{
		myStack.addFirst(value);

		theSize++;
	}


	public AnyType pop()
	{
		if(theSize == 0)
		{
			return null;
		}
		else
		{
			AnyType current = (AnyType) new Object();

			current = myStack.removeFirst();



			theSize--;


			return current;
		}
	}


	public AnyType peek()
	{
		if(theSize == 0)
		{
			return null;
		}
		else
		{
			AnyType current = (AnyType) new Object();
	
			current = myStack.getFirst();

			return current;
		}
	}


	public int size()
	{
		return theSize;
	}


	public boolean isEmpty()
	{
		if(theSize > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}

