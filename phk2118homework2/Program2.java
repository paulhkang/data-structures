public class Program2 extends TwoStackQueue
{

	/** Output should be:
 * 		3
 * 		4
 * 		8
 * 		1245
 * 		987654321
 * 		6528
 */


	// Program must be exited manually; q.dequeue() will continuously return null when the queue is empty

	public static final void main(String[] args)
	{
		TwoStackQueue<Integer> q = new TwoStackQueue<>();

		q.enqueue(8);
		q.enqueue(1245);
		q.enqueue(987654321);
		System.out.println(q.size());
		q.enqueue(6528);
		System.out.println(q.size());
		

		while(!q.isEmpty())
			System.out.println(q.dequeue());

	}
}
