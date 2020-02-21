import java.util.*;

public class Problem2 extends Rectangle
{
	public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x)
	{
		// uses private helper function to recursively search, returns -1 if search fails, idx of rectangle if search succeeds
		return helper(a, x, 0, a.length - 1);
	}

	private static <AnyType extends Comparable<AnyType>> int helper(AnyType[] a, AnyType x, int low, int high)
	{
/*		// Version with base case					// The version with base case freaks out if the search fails, the non base-case
										// version returns -1 as expected.
		int mid = (low + high) / 2;
		if (a[mid].compareTo(x) == 0)
		{
			return mid;
		}


		if (low <= high)
			if (a[mid].compareTo(x) < 0)				// x is in second half, resize search area accordingly
			{
				low = mid + 1;
			}
			else if (a[mid].compareTo(x) > 0)			// x is in first half, resize search area accordingly
			{
				high = mid - 1;
			}
		else								// returns -1 if search fails (resulting in an empty array), or if inputs are faulty
			return -1;


		return helper(a, x, low, high);					// repeats search on smaller search area 
*/


		// Version without base case
		int mid = (low + high) / 2;
		if (low <= high)
			if (a[mid].compareTo(x) < 0)				// x is in second half, resize search area accordingly
			{
				low = mid + 1;
			}
			else if (a[mid].compareTo(x) > 0)			// x is in first half, resize search area accordingly
			{
				high = mid - 1;
			}
			else
			{
				return mid;					// perimeter of x is equal to mid, meaning rectangle x has been found. return mid.
			}
		else								// returns -1 if search fails (resulting in an empty array), or if inputs are faulty
			return -1;


		return helper(a, x, low, high);					// repeats search on smaller search area 


	} 



	public static final void main(String[] args)
	{
		// creates rectangle array of size 8
		Rectangle[] array = new Rectangle[8];


		// sets each rectangle in the array such that the array is not in increasing order (to test that the sort actually works) 
		for (int i = 0; i < 8; i++)						
		{	
			Rectangle r = new Rectangle();
			r.setSize(Math.abs(i-4), Math.abs(i-4));	

			array[i] = r;
		}

		// uses Arrays.sort to sort by perimeter, ascending
		// also prints out the sorted array
		Arrays.sort(array);
		for (int i = 0; i < 8; i++)
		{
			System.out.println(array[i].getPerim());
		}
		
		int length = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);

		Rectangle test = new Rectangle();
		test.setSize(length, width);
		System.out.println();
		System.out.println("perim of test rectangle: " + test.getPerim() + "\n");			// print out perimeter of test rectangle for clarity

		int idx = binarySearch(array, test);

		System.out.println("idx: " + idx);
	}



}
