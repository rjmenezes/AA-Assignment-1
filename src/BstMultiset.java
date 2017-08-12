import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	protected BstNode<T> head;
	
	public BstMultiset() {
		// Implement me!
		head = new BstNode<T>();
	} // end of BstMultiset()

	public void add(T item) {
		// Implement me!
		if(head.data == null)
		{
			head.data = item;
			head.count = 1;
		}
		else
		{
			insert(item, head);
		}
	} // end of add()


	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add() hi


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
	public void insert(T data, BstNode<T> current)
	{
		
		if(data.equals(current.data))
		{
			current.count++;
		}
		else
		{
			if((long) data > (long) current.data) //greater than, insert on the right if empty
			{
				if(current.next == null)
				{
					current.next = new BstNode<T>(data);
				}
				else
				{
					insert(data, current.next);
				}
			}
			else //less than, insert on the left if empty
			{
				if(current.previous == null)
				{
					current.previous = new BstNode<T>(data);
				}
				else
				{
					insert(data, current.next);
				}
			}
		}
	}

} // end of class BstMultiset
