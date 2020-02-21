public class Problem1 extends Rectangle
{
	public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
		int maxIndex = 0;
			for (int i = 1; i < arr.length; i++)
				if ( arr[i].compareTo(arr[maxIndex]) > 0 )
					maxIndex = i;
		return arr[maxIndex];
	}


	public static final void main(String[] args)
	{

		// creates rectangle array of size 8
		Rectangle[] array = new Rectangle[8];


		// sets each rectangle in the array equal to a square of size (i, i)
		for (int i = 0; i < 8; i++)						
		{	
			Rectangle r = new Rectangle();
			r.setSize(i, i);

			array[i] = r;
		}

		Rectangle biggest = new Rectangle();
		biggest = findMax(array);

		// prints out length, width, and perimeter of biggest rectangle
		System.out.println(biggest.getLength());
		System.out.println(biggest.getWidth());
		System.out.println(biggest.getPerim());
	}
}
