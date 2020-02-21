public class Rectangle implements Comparable<Rectangle>
{
	public int length, width, perimeter;


	// getLength, getWidth, getPerim, and setSize methods to access and manipulate Rectangles
	public int getLength()
	{
		return length;
	}

	public int getWidth()
	{
		return width;
	}

	public int getPerim()
	{
		perimeter = length * 2 + width * 2;
		return perimeter;
	}


	public void setSize(int length, int width)
	{
		this.length = length;	
		this.width = width;
	}



/*
	// implementation of compareTo
	public int compareTo(Rectangle r)
	{
		if (this.getPerim() == r.getPerim())
		{
			return 0;
		}
		else if (this.getPerim() > r.getPerim())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
*/




	public int compareTo(Rectangle r)
	{
		Integer a = new Integer(this.getPerim());
		Integer b = new Integer(r.getPerim());

		return a.compareTo(b);
	}


}
