// base case: factorial(0) = 1.
// 	x! = (x)(x-1)!

public class Factorial
{
	// method
	public static int factorial(int x)
			// a static method is NOT tied to a specific class.
			// a non-static method is tied to a specific class.
	{
		// Base case
		if(x==0)
		{
			return 1;
		} 



		// Recursive call
		return x * factorial(x-1);
	}


	// main method
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		System.out.println(factorial(n));

	}
}
