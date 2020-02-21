public class Fib
{
	// method
	public static int fib(int x)
	{
		// Base case
		if(x==0 || x==1)
		{
			return 1;
		}

		// Recursive call
		return fib(x-1) + fib(x-2);

	}


	// main method
	public static final void main(String[] args)
	{
		int x = Integer.parseInt(args[0]);		// Integer is the wrapper class around int type ?????	
		System.out.println(fib(x));


	}


}
