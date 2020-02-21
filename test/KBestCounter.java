import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k) {

	heap = new PriorityQueue<T>(k);

	this.k = k;

    }

    public void count(T x) {

	if(heap.size() < k)
	{
		heap.add(x);
//		System.out.println("added x! heapsize < k.\n");
	}
	else if(x.compareTo(heap.peek()) > 0)
	{
		T temp = heap.poll();				// removes head of heap (least value of k-largest)
		heap.add(x);
//		System.out.println("added x! heapsize == k.\n");
	}
//	else
//		System.out.println("no action.\n");



    }


    public List<T> kbest() {

	PriorityQueue<T> copy = new PriorityQueue<>(heap);

//	System.out.println("copy size: " + copy.size());

	LinkedList<T> list = new LinkedList<>();

	while(copy.size() > 0)
	{

		list.addFirst(copy.poll());
//		System.out.println("added to list " + list.peek());
		
	}


	return list;
    }




}
