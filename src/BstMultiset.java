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
		BstNode<T> node = null;
		
		//find the node
		if(head.data != null)
		{
			node = find(item, head);
		}
		
		//if the node is not found then return 0
		if(node == null)
		{
			return 0;
		}
		else //if found then return the amount there is of it
		{
			return node.count;
		}
		
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
		BstNode<T> node = null;
		
		//find the node
		node = find(item, head);
		
		//if the node is found then remove one from counter
		if(node != null)
		{
			if(node.count == 1) //if its the count is one then remove all of them
			{
				removeAll(item);
			}
			else //remove one instance of it
			{
				node.count--;
			}
		}
		
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
		//check if there is any data at the head of the tree if there is then print it
		if(head.data != null)
		{
			printEach(head, out);
		}
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
					insert(data, current.previous);
				}
			}
		}
	}
	
	public BstNode<T> find(T data, BstNode<T> current)
	{
		if(data.equals(current.data)) //check if this node is the one matching data and return that node
		{
			return current;
		}
		else
		{
			if((long) data > (long) current.data) //greater than, find on the right
			{
				if(current.next == null) // if right is empty then return null
				{
					return null;
				}
				else //if there is data on the right the keep looking on the right
				{
					return find(data, current.next);
				}
			}
			else //less than, find on the left
			{
				if(current.previous == null) //if the left is empty then return null
				{
					return null;
				}
				else //if there is data on the left then keep looking on the left
				{
					return find(data, current.previous);
				}
			}
		}
	}
	
	public void printEach(BstNode<T> current, PrintStream out)
	{
		//print out the current set of data
		out.println(current.data + " | " + current.data);
		
		//check if the right side of the tree exists
		if(current.next != null)
		{
			//print element from the right side
			printEach(current.next, out);
		}
		if(current.previous != null)
		{
			//print element from the left side of the tree
			printEach(current.previous, out);
		}
	}

} // end of class BstMultiset
