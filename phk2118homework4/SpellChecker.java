// Implement a spelling checker by using a hash table. Output all misspelled words and the line numbers in which they occur.
// Also, for each misspelled word, list any words in the dictionary that are obtainable by applying any of the following rules:
// 	a. Add one character.
// 	b. Remove one character.
// 	c. Exchange adjacent characters.


import java.io.*;
import java.util.*;

public class SpellChecker
{

	private static int linenum = 0;						// current line number 
	private static int startidx = 0;					// index of first character in next line
	private static boolean eof = false;					// end of file has been reached? 
	private static Hashtable<String, Integer> table = new Hashtable<>();

	// creates line subarray of full text document
	public static char[] lineFill(char[] wholeText)						
	{
		char[] line = new char[1001];

		int j = 0;
		int newsize = 0;

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


		if(line_final.length > 0)
		{
//			System.out.println("line_final length: " + line_final.length);
//			System.out.println("line_final: " + new String(line_final));
//			System.out.println("line_final final character: " + line_final[line_final.length - 1]);
//			System.out.println();
		}



		return line_final;
	}



	public static void checkSpelling(String[] array) throws IOException
	{

		boolean typo = false;

		for(int i = 0; i < array.length; i++)
		{
			if(table.contains(array[i].hashCode()))
			{
//				System.out.println("correct word length: " + array[i].length());
//				System.out.println("correct");
			}
			else if(!array[i].equals("-"))		// to address annoying bug where a lone hyphen is marked as a typo
			{

				System.out.println();

				typo = true;

				System.out.println("typo: " + array[i]);
				System.out.println("linenum: " + linenum);
//				System.out.println("typo hashcode: " + array[i].hashCode());

				String copy = array[i];							// allocate copy to manipulate (to test different spellings)
				char[] copyChar = copy.toCharArray();

//				System.out.println("typo length: " + copyChar.length);



				// spelling suggestions
			
				// add one character
				// essentially, do the remove on each string in the hashtable that is of length copy.length() + 1
				// then, check if the 2 strings hash to the same value (check)
				
				int check = copy.hashCode();
//				System.out.println("copy hashcode: " + check);
				

				char[] testAd = new char[copyChar.length];

				for(Enumeration<String> e = table.keys(); e.hasMoreElements();)
				{
					String theString = e.nextElement();

					if(theString.length() == copy.length() + 1)
					{

//						System.out.println("currently testing string: " + theString);

						char[] dicStringChar = theString.toCharArray();


						for(int j = 0; j < dicStringChar.length; j++)
						{

							int k = 0;
							int l = 0;

							while(l < dicStringChar.length) 
							{
								if(l != j)
								{
									testAd[k] = dicStringChar[l];
//									System.out.println("copied over: " + testAd[k]);
									k++;
								}


								l++;
							}


							String Ad = new String(testAd);

//							System.out.println("potential ad suggestion (one letter removed from dictionary): " + Ad);

							if(Ad.hashCode() == check)
								System.out.println("add suggestion found! it is: " + theString);


						}

//						System.out.println("press enter to continue: (ad check)");
//						System.in.read();
					}
				}




				// remove one character
				// test every possible version of copyChar, with one character deleted
				// if any of these suggestions hash to a value in the dictionary, make a spelling suggestion for that word
				
				char[] testRm = new char[copyChar.length - 1];
				
				for(int j = 0; j < copyChar.length; j++)
				{
//					System.out.println("currently testing removal of: " + copyChar[j]);
					
					int k = 0;
					int l = 0;
					
					while(l < copyChar.length)
					{
						if(l != j)	// where j is the character to be "deleted" (i.e. not copied over to new array)
						{
							testRm[k] = copyChar[l];
//							System.out.println("copied over: " + testRm[k]);
							k++;
						}

						l++;
			
					}

					String Rm = new String(testRm);

//					System.out.println("potential rm suggestion: " + Rm);

					if(table.contains(Rm.hashCode()))
						System.out.println("remove suggestion found! it is: " + Rm);
						
				}









				// exchange two adjacent characters
				// test every possible version of copyChar, with 2 letters exchanged
				// if any of those possibilities hash to a value in the dictionary, provide a spelling suggestion using that word

				char[] testEx = new char[copyChar.length];

				for(int j = 0; j < copyChar.length - 1; j++)
				{
//					System.out.println("currently testing exchange of (first letter): " + copyChar[j]);

					int k = 0;
					int l = k + 1;

					while(k < copyChar.length)
					{
						if(k != j)	// where j is the first character to be exchanged
						{
//							copy as normal
							testEx[k] = copyChar[k];
						}
						else
						{
//							swap
							char ex1 = copyChar[k];
							char ex2 = copyChar[l];

							testEx[k] = ex2;
							testEx[l] = ex1;
			
							k++;
							l++;
						}

						k++;
						l++;
					}

					String Ex = new String(testEx);
			
//					System.out.println("testing ex suggestion: " + Ex);

					if(table.contains(Ex.hashCode()))
						System.out.println("exchange suggestion found! it is: " + Ex);
				}






//				System.out.println('\n');
			}
		}


		if(typo)
			System.out.println('\n');

	}


	public static final void main(String[] args) throws FileNotFoundException, IOException
	{
		File file0 = new File(args[0]);
		FileReader reader0 = new FileReader(file0);

		int dicsize = 1000000;
		char[] dictionaryUpper = new char[dicsize];

		int confirm = reader0.read(dictionaryUpper);
//		System.out.println(confirm);					// prints out number of characters read

		reader0.close();



		File file1 = new File(args[1]);
		FileReader reader1 = new FileReader(file1);

		int textsize = 36000;
		char[] textNotLower = new char[textsize];

		confirm = reader1.read(textNotLower);
//		System.out.println(confirm + "\n");

		reader1.close();




		char[] dictionary = new char[dicsize];
		for(int i = 0; i < dictionary.length; i++)
		{
			dictionary[i] = Character.toLowerCase(dictionaryUpper[i]);
		}








		char[] text = new char[textsize];				// new char[] that has been toLower'ed


		int j, k;
		k = 0;

		for(j = 0; j < textNotLower.length; j++)
		{
			if(textNotLower[j] != ',' && textNotLower[j] != '.' && textNotLower[j] != ':' && textNotLower[j] != '\ufeff' &&
			   textNotLower[j] != ';' && textNotLower[j] != '\"')
			{
				text[k] = Character.toLowerCase(textNotLower[j]);
				k++;
			}
		}







		String dic = new String();
		String[] dicArr = new String[100000];

		dic = String.valueOf(dictionary);
		dicArr = dic.split("\\s+");

/*
		for(int i = 0; i < 10; i++)
		{
			System.out.println(dicArr[i]);
		}
*/





		String str = new String();
		String[] textArr = new String[10000];
		



		
		for(int i = 0; i < dicArr.length; i++)
		{
			table.put(dicArr[i], dicArr[i].hashCode());
		}

		Integer n = table.get(dicArr[2]);
//		System.out.println(n);





		while(!eof)
		{
			char[] lineArr = lineFill(text); 
	

			if(lineArr.length > 0)
			{

				str = String.valueOf(lineArr);
				textArr = str.split("\\s+");

//				System.out.println("test of superlong end string: " + textArr[textArr.length - 1]);
//				System.out.println("length of superlong end string: " + textArr[textArr.length - 1].length());
//				System.out.println();




//				System.out.println(linenum);
			
/*
				for(int i = 0; i < textArr.length; i++)
				{
					System.out.println(textArr[i]);
				}
*/

				checkSpelling(textArr);
		
//				System.out.println('\n');

//				System.out.println("press enter to continue:");
//				System.in.read();
	

			}

		}


		for(int i = 0; i < textArr.length; i++)
		{
//			System.out.println(textArr[i]);
		}



	}
}
