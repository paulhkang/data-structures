public class testkbest2
{

	public static final void main(String[] args)
	{

		int k = 5;

		KBestCounter<Integer> counter = new KBestCounter<>(k);

		
		System.out.println("size: " + counter.size());


		Integer integer;

		
		integer = Integer.valueOf(3);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");



		integer = Integer.valueOf(4);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");




		integer = Integer.valueOf(2);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");




		integer = Integer.valueOf(1);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");





		integer = Integer.valueOf(6);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");






		integer = Integer.valueOf(0);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println("\n");






		integer = Integer.valueOf(5);

		System.out.println("attempted to add: " + integer);
		counter.count(integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());

/*
		integer = Integer.valueOf(3);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println();




		integer = Integer.valueOf(2);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println();




		integer = Integer.valueOf(6);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println();



		integer = Integer.valueOf(1);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println();






		integer = Integer.valueOf(4);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println();






		integer = Integer.valueOf(0);

		counter.add(integer);
		System.out.println("added: " + integer);
		System.out.println("size: " + counter.size());
		System.out.println("peek: " + counter.heap.peek().intValue());
		System.out.println();

*/


/*
		result = counter.heap.add(new Integer(3));
		result = counter.heap.add(new Integer(2));
		result = counter.heap.add(new Integer(6));
		result = counter.heap.add(new Integer(1));
		result = counter.heap.add(new Integer(0));
		result = counter.heap.add(new Integer(4));
	
		System.out.println(counter.heap.peek().intValue());
*/

	}
}
