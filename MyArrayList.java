public class MyArrayList<AnyType> implements Iterable<AnyType>
{
	/**
 	 * Construct an empty ArrayList.
 	 */
	public MyArrayList()
	{
		doClear();							// helper method that blanks out whatever array list happened to be there before
	}

	/**
 	 * Returns the number of items in this collection.
 	 * @return the number of items in this collection.
 	 */
	






	
	
	/**
 	 * Change the size of this collection to zero.
 	 */
	public void clear()
	{
		doClear();
	}




stopped copying the code here; look at notes.







	private static final int DEFAULT_CAPACITY = 10;

	private AnyType [ ] theItems;
	private int theSize;							// how many items are actually filled
	
}
