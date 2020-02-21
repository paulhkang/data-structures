import java.util.*;
import java.io.*;


// The word "applause" is indexed strangely: it is covered in multiple nodes for some reason. This is most likely due to the formatting in the document, as "applause"
// is the only word that does this.
//
// There is also a node in the tree that might contain a newline character or other whitespace character. It can be found at the top of the output.


public class Problem2 extends AvlTree
{
	private static int linenum = 0;				// current line number
	private static int startidx = 0;			// index of first character in next line
	private static boolean eof = false;			// end of file has been reached?
	private static AvlTree<String> tree = new AvlTree<>();


	// creates line subarray of full text document
	public static char[] lineFill(char[] wholeText)						
	{
		char[] line = new char[1000];

		int j = 0;

		for(int i = startidx; i < wholeText.length; i++)
		{
			if(wholeText[i] != '\n')
			{
				line[j] = wholeText[i];
				j++;
			}
			else if(wholeText[i] == '\n')
			{
				startidx = i + 2;	// 2016su.txt has 2 newline characters for every new line; if a different document is used, startidx might be i + 1
				break;
			}
		}


		if(wholeText[startidx] == 0)		// if the wholeText array is empty at startidx, that is the end of the text file (wholeText is larger than the file)
			eof = true;

		linenum++;

		return line;
	}


	// inserts or updates nodes according to an inputted String[] array (which contains one line of the text document)
	public static boolean lineIndex(String[] arr, AvlTree<String> tree)
	{

		for(int i = 0; i < arr.length; i++)
		{
			if(tree.contains(arr[i]) && tree.peek(tree.findNode(arr[i])) != linenum)// word is already in tree, and current line number has been inputted
			{
				tree.addToList(linenum, tree.findNode(arr[i]));
			}
			else if(!tree.contains(arr[i]))						// word is not yet in tree
			{
				tree.insert(arr[i]);
				tree.addToList(linenum, tree.findNode(arr[i]));
			}
		}

		return true;


		
	}


	public static final void main(String[] args) throws FileNotFoundException, IOException
	{
		File file = new File(args[0]);
												// creates file and reader to read in from text file 
		FileReader reader = new FileReader(file);




		char[] text = new char[36000];


		int confirm = reader.read(text);
//		System.out.println(reader.read(text) + "\n");					// prints out number of characters read

		reader.close();
	


		// gets rid of punctuation

		int j, k;
		k = 0;

		char[] nopunc = new char[36000];
		for(j = 0; j < text.length; j++)
		{
			if(text[j] != '.' && text[j] != ',' && text[j] != '?' && text[j] != '\'' && text[j] != '\"' && text[j] != ':' && 
		       	   text[j] != ';' && text[j] != '-' && text[j] != '!' && text[j] != '(' && text[j] != ')' )
			{
				nopunc[k] = Character.toLowerCase(text[j]);
				k++;
			}
		}

			

		





		String str = new String();

		String[] strArr = new String[7000];



		




		// while end of file has not been reached
		while(!eof)
		{
			char[] lineArr = new char[1000];

			lineArr = lineFill(nopunc);
			str = str.valueOf(lineArr);
			strArr = str.split(" ");

			boolean success = lineIndex(strArr, tree);
//			System.out.println(success);
		}

		tree.printTree();


/*
		// iterates through number of lines in 2016su.txt
		while(!eof)
		{
			System.out.println(nopunc[startidx]);

			lineArr = lineFill(nopunc);				// fills lineArr[] with one line of nopunc[]
			str = str.valueOf(lineArr);
			strArr = str.split(" ");				// fills strArr[] (a String[] array) with the individual words of lineArr[]



			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i < strArr.length; i++)
			{
				builder.append(strArr[i]);
				if(i != strArr.length - 1)
					builder.append(",");
			}
			System.out.println(builder.toString());



			System.out.println(lineArr);
			System.out.println(linenum);
			System.out.println('\n');
		}
*/



/*
		tree.insert("Test string");
		tree.addToRoot(5);
		tree.addToRoot(7);
		tree.addToRoot(0);

		tree.insert("second test string");
		tree.addToList(10, tree.findNode("second test string"));
		tree.addToList(20, tree.findNode("second test string"));
		tree.addToList(30, tree.findNode("second test string"));

		tree.insert("3rd");
		tree.addToList(15, tree.findNode("3rd"));
		tree.addToList(25, tree.findNode("3rd"));
		tree.addToList(35, tree.findNode("3rd"));

		System.out.println(tree.printList(tree.findNode("Test string")));
		System.out.println(tree.printList(tree.findNode("second test string")));
		System.out.println(tree.printList(tree.findNode("3rd")));
*/




	}
}
