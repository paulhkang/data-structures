public class Problem3
{

	public static int foo(int n, int k) {
		if(n<=k)
			return 1;
		else
			return foo(n/k,k) + 1;
	}




	public static final void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);




		//fragment 1
		
		long starTime = System.currentTimeMillis();

		int sum = 0;
		for ( int i = 0; i < 23; i ++)
			for ( int j = 0; j < n ; j ++)
			        sum = sum + 1;
		
		System.out.println(sum);


	 	long endTime = System.currentTimeMillis();

		long runTime = endTime - starTime;
		System.out.println(runTime);



		// fragment 2

		starTime = System.currentTimeMillis();

		sum = 0;
		for ( int i = 0; i < n ; i ++)
			for ( int k = i ; k < n ; k ++)
			        sum = sum + 1;

		System.out.println(sum);

	 	endTime = System.currentTimeMillis();

		runTime = endTime - starTime;
		System.out.println(runTime);





		// fragment 3
		
		starTime = System.currentTimeMillis();

		long starNano = System.nanoTime();

		int k = 2;
		System.out.println(foo(n, k));

 		endTime = System.currentTimeMillis();

		long endNano = System.nanoTime();

		runTime = endTime - starTime;
		long runTimeNano = endNano - starNano;
		System.out.println(runTime);
		System.out.println(runTimeNano);

		



	}
}
