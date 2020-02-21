import java.util.*;
import java.io.*;



public class FindPalindromes extends MyStack
{

	private static int linenum = 0;
	private static int startidx = 0;
	private static boolean eof = false;


	// removes punctuation and sets all characters to lowercase
	public static char[] plainify(char[] c)
	{

		char[] nopunc = new char[c.length];

		int k = 0;
		int newsize = 0;

		for(int i = 0; i < c.length; i++)
		{
			if(c[i] != ' ' && c[i] != '.' && c[i] != '\'' && c[i] != ',' && c[i] != '?' && c[i] != '!' && c[i] != ':' && c[i] != '\"' &&
			   c[i] != ';' && c[i] != '-')						
			{
				nopunc[k] = Character.toLowerCase(c[i]);
				k++;
			}

		}

		for(int i = 0; i < nopunc.length; i++)
		{
			if(nopunc[i] == 0)
			{
				newsize = i;
//				System.out.println("newsize: " + newsize + '\n');
				break;
			}
		}

		char[] nopunc_final = new char[newsize];

		for(int i = 0; i < nopunc_final.length; i++)
		{
			nopunc_final[i] = nopunc[i];
		}

//		System.out.println("nopunc_final length: " + nopunc_final.length);
//		System.out.println("nopunc_final: " + new String(nopunc_final));
//		System.out.println("nopunc_final final char: " + nopunc_final[nopunc_final.length - 1]);
//		System.out.println();


		return nopunc_final;

	}






	// creates line subarray of full text document
	public static char[] lineFill(char[] wholeText)						
	{
		char[] line = new char[1001];

		int j = 0;
		int newsize = 0;

//		System.out.println("startidx: " + startidx);
//		System.out.println("wholeText[startidx]: " + wholeText[startidx]);


		for(int i = startidx; i < wholeText.length; i++)
		{
			if(j < line.length)
			{
				if(wholeText[i] != '\n' && wholeText[i] != '\r')
				{
//					System.out.println("copied!");
					line[j] = wholeText[i];
					j++;
				}
				else if(wholeText[i] == '\n')
				{
//					System.out.println("newline!");
					newsize = i - startidx - 1;
					startidx = i + 1;
					break;
				}
			}
			else
			{
				break;
			}
		}




		char[] line_final = new char[newsize];

		for(int i = 0; i < line_final.length; i++)
		{
			line_final[i] = line[i];
		}




		// NOTE: file to be read must end with a newline character for this to work correctly!
		if(wholeText[startidx] == 0)		// if the wholeText array is empty at startidx, that is the end of the text file
		{
//			System.out.println("end of file!");
			eof = true;
		}

		



		linenum++;

		return line_final;
	}






	// tests input char[] (assuming it has been plainified) for palindrome-ness
	public static boolean palTest(char[] test)
	{
		MyStack<Character> stack = new MyStack<>();


		int mid = 0;

		if(test.length % 2 == 1)
			mid = test.length / 2;						// java truncates integer division
		else
			mid = test.length / 2 - 1;


		for(int i = 0; i < mid; i++)
		{
			Character ch = new Character(test[i]);


			stack.push(ch);
//			System.out.println("pushed char: " + ch.charValue());
		}


		char val;			  			 		// new char to store values in for comparing

//		System.out.println();




		if(test.length % 2 == 1)						// if line has odd # of characters, then middle character must be accounted for
		{
			for(int i = mid + 1; i < test.length; i++)
			{
				val = stack.pop().charValue();
				if(val != test[i])
				{
//					System.out.println("odd failure");
//					System.out.println("failure value: " + val);
//					System.out.println("failure idx: " + i);
//					System.out.println("palindrome length: " + test.length);
					return false;				// false if they are not the same char
				}



				
			}


			return true;							// true if all characters matched their pre-mid counterparts


		}
		else									// if line has even # of characters, then there is no mid char to account for
		{		

			stack.push(new Character(test[mid]));				// push "mid" character to stack, because test has an even number of characters

			for(int j = mid + 1; j < test.length; j++)	// this loop pops values, and tests them against their pre-mid counterparts
			{
				val = stack.pop().charValue();
				if(val != test[j])
				{
//					System.out.println("even failure");
//					System.out.println("failure value: " + val);
//					System.out.println("failure idx: " + j);
//					System.out.println("palindrome length: " + test.length);
					return false;			// returns false if any character doesn't match its pre-mid counterpart
				}
			}
			return true;	
		}

	} 







	public static final void main(String[] args) throws FileNotFoundException, IOException
	{
		File file = new File(args[0]);
												// creates file and reader to read in from palindromes.txt
		FileReader reader = new FileReader(file);


		char[] c = new char[2000];


		int read = reader.read(c);
//		System.out.println(read + "\n");					// prints out number of characters read

		reader.close();




		while(!eof)
		{

			char[] line = lineFill(c);

			char[] line_nopunc = plainify(line);

//			System.out.println(new String(line));
//			System.out.println("linenum: " + linenum);
//			System.out.println("line_final length: " + line.length);
//			System.out.println("final char in line_final: " + line[line.length - 1]);
//			System.out.println();

			boolean result = palTest(line_nopunc);
//			System.out.println("result: " + result);

			if(result)
				System.out.println(new String(line));
	
//			System.out.println("press enter to continue: ");
//			System.in.read();

//			System.out.println("\n");
		}
		

	}
}
