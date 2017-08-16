import java.io.PrintStream;
import java.util.*;




public class LinkedListMultiset<T> extends Multiset<T>
{
	protected Node nodeHead;
	protected Node nodeTail;
	protected int listLength;
	
	public LinkedListMultiset() {
		// Implement me!
		nodeHead = null;
		nodeTail = null;
		listLength = 0;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		//if list is empty
		int count = 1;
		int newCount = 0;
		boolean exists = false;
		
		
		if (nodeHead == null)
		{
			Node addNode = new Node(item, count);
			nodeHead = addNode;
			nodeTail = addNode;
		}
		
		
		else 
		{
			Node exNode = nodeHead;
		
			while (exists == false)
			{
				
				if (exNode.getNodeItem().equals(item))
				{
					exists = true;
				
				}
				if (exNode.getNextNode() != null && exists == false)
				{
					exNode = exNode.getNextNode();
				}
				else {
					break;
				}
				
			}
		
			if (exists == true)
			{
				newCount = exNode.getNodeCount() + 1;
				exNode.setNodeCount(newCount);
			}
			else {
				Node addNode = new Node(item, count);
				addNode.setNextNode(nodeHead);
				nodeHead.setPrevNode(addNode);
				nodeHead = addNode;
				
			}
			
		}
		listLength++;
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		Node tempNode = nodeHead;
		int count = 0;
		
		while(tempNode != null)
		{
			if (tempNode.getNodeItem().equals(item))
			{
				break;
			}
			
			tempNode = tempNode.getNextNode();
		}
		
		if(tempNode != null)
		{
			count = tempNode.getNodeCount();
		}
		
		if (count > 0)
		{
			return count;
		}
		else {
			return 0;
		}
		
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	
		int count = 0;
		int index = 0;
		boolean exists = false;
		Node tempNode = nodeHead;
		while(tempNode != null)
		{
			if (tempNode.getNodeItem().equals(item))
			{
				exists = true;
				break;
			}
			
			tempNode = tempNode.getNextNode();
			index++;
		}
		
		if (exists == true)
		{
			count = tempNode.getNodeCount() - 1;
			if (count > 0)
			{
				tempNode.setNodeCount(count);
			}
			else {
				
			    
				//if it is the head
				removeAll(item);
			}
			
		}
		
		
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node tempNode = nodeHead;
		Node previous = null;
		do
		{
			if(tempNode.nItem.equals(item))
			{
				break;
			}
			else
			{
				previous = tempNode;
				tempNode = tempNode.nextNode;
			}
		}
		while(tempNode != null);
		
		if(tempNode == null)
		{
			return;
		}
		else if(previous == null)
		{
			if(tempNode.nextNode == null)
			{
				nodeHead = null;
				listLength--;
			}
			else
			{
				nodeHead = tempNode.nextNode;
				tempNode.nextNode.prevNode = nodeHead;
				listLength--;
			}
			
		}
		else if(tempNode.nextNode == null)
		{
			previous.nextNode = null;
			listLength--;
		}
		else
		{
			previous.nextNode = tempNode.nextNode;
			tempNode.nextNode.prevNode = previous;
			listLength--;
		}
		
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
		Node tempNode = nodeHead;
		int counter = 0;
		while (tempNode != null)
		{	
			out.println(tempNode.getNodeItem() + " | " + tempNode.getNodeCount());
			tempNode = tempNode.getNextNode();
			
			
		}
		
	} // end of print()
	
	private class Node
	{
		protected Node nextNode;
		protected Node prevNode;
		protected int nCount;
		
		protected T nItem;
		
		public Node(T item, int count)
		{
			nItem = item;
			nCount = count;
			nextNode = null;
		}
		
		public T getNodeItem() {
            return nItem;
        }


        public Node getNextNode() {
            return nextNode;
        }
        
        public Node getPrevNode() {
        	return prevNode;
        }

        public int getNodeCount() {
        	return nCount;
        }

        public void setNodeItem(T item) {
            nItem = item;
        }

        public void setNodeCount(int count)
        {
        	nCount = count;
        }
        public void setNextNode(Node nNode) {
            nextNode = nNode;
        }
        
        public void setPrevNode(Node pNode) {
           prevNode = pNode;
        }
		
		
	}
} // end of class LinkedListMultiset