import java.util.LinkedList;
import java.util.Queue;


public class Josephus
{
	public static final void main(String[] args)
	{
		

		int count = 5;							// k, the number that you count up to before ejecting person from circle

		Queue<Integer> q = new LinkedList<Integer>();			// the variable q directly references a LinkedList object, but it is typed as a Queue, so it 											can only use Queue methods


		for(int i=1; i<=10; i++)
			q.offer(i);						// enqueueing each of these numbers from 1-10



		int c = 0;							// the actual count. i.e. when c = k, you kick out the person.
	
		while(q.size() != 1)
		{
			int x = q.poll();
			c++;

			if(c==count)
			{
				System.out.println("So long: " + x);
				c = 0;
			}
			else
			{
				q.offer(x);
			}
		}


	}
}
