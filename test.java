public class test
{

	public static final void main(String[] args)
	{

		String testStr = new String();

		testStr = "asd   tab	";


//		char[] test = new char[25];
		char[] test = testStr.toCharArray();


		char[] newtest = new char[testStr.length()];


		System.out.println("pre test: " + new String(test));
		System.out.println("pre newtest: " + new String(newtest));

		System.out.println();

		System.out.println("character: " + test[0]);


		for(int i = 0; i < test.length; i++)
		{
			if(test[i] == 's')
			{
				System.out.println("loop broken!\n");
				break;
			}
	
			newtest[i] = test[i];
		}


		System.out.println("test length: " + test.length);
		System.out.println("newtest length: " + newtest.length);

		System.out.println();

		System.out.println("test: " + new String(test));
		System.out.println("newtest: " + new String(newtest));

	
	}
	
}
