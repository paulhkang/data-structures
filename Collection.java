public interface Collection<AnyType>> extends Iterable<AnyType>	// anything that appears in Iterable has to appear in Collection
{
	int size();						// size of bag
	boolean isEmpty();					// is the bag empty?
	void clear();						// clear the contents of the bag
	boolean contains(AnyType x);				// does the bag contain <AnyType>?
	boolean add(AnyType x);					// add <AnyType>
	boolean remove(AnyType x);				// remove <AnyType>
	java.util.Iterator<AnyType> iterator();
}



public interface Iterator<AnyType>
{
	boolean hasNext();
	AnyType next();
	void remove();
}
