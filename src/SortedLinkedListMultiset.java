import java.io.PrintStream;
import java.util.*;




public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	protected Node nodeHead;
	protected Node nodeTail;
	protected int listLength;
	public SortedLinkedListMultiset() {
		// Implement me!
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		int count = 1;
		int newCount = 0;
		boolean exists = false;
		
		
		if (nodeHead == null)
		{
			Node addNode = new Node(item, count);
			nodeHead = addNode;
			nodeTail = addNode;
			listLength++;
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
				
				int index = 0;
				Node currNode = nodeHead;
				
				Node addNode = new Node(item, count);
				while (currNode != null)
				{
					
					
					if (addNode.getNodeItem().toString().compareTo(
							currNode.getNodeItem().toString()) < 0)
					{
						
						if (index == 0)
						{
							addNode.setNextNode(nodeHead);
							nodeHead.setPrevNode(addNode);
							nodeHead = addNode;
							
						}
						
						else {
							addNode.setPrevNode(currNode.getPrevNode());
							currNode.getPrevNode().setNextNode(addNode);
							currNode.setPrevNode(addNode);
							addNode.setNextNode(currNode);

						}
						break;
					}
					else if(addNode.getNodeItem().toString().compareTo(
							currNode.getNodeItem().toString()) > 0) {
						if (index != listLength - 1)
						{
							index++; 
							currNode = currNode.getNextNode();
						
						}
						else {
							addNode.setPrevNode(nodeTail);
							nodeTail.setNextNode(addNode);
							nodeTail = addNode;
							break;
						}
						
					}
				
				}
				listLength++;
				
			}
			
		}
	
		
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		Node tempNode = nodeHead;
		boolean exists = false;
		
		while(tempNode != null)
		{
			if (tempNode.getNodeItem().equals(item))
			{
				exists = true;
				break;
			}
			if (tempNode.getNextNode() != null)
			{
				if (tempNode.getNodeItem().toString().compareTo(
						tempNode.getNextNode().getNodeItem().toString()) > 0)
				{
					break;
				}
			}

			tempNode = tempNode.getNextNode();
		}
		

		
		if (exists == true)
		{
			return tempNode.getNodeCount();
		}
		else {
			return 0;
		}
		// default return, please override when you implement this method
	
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
		boolean exists = false;
		if (search(item) != 0)
		{
			do
			{
				if(tempNode.nItem.equals(item))
				{

					exists = true;
					break;
				}
				else
				{
					previous = tempNode;
					tempNode = tempNode.nextNode;
				}
			}
			while(tempNode != null);
			if (exists == true) {
				if(previous == null)
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
						tempNode = null;
						listLength--;
					}
					
				}
				else if(tempNode.nextNode == null)
				{
					
					nodeTail = previous;
					previous.setNextNode(null);
					tempNode = null;
					listLength--;
				}
				else
				{
					previous.nextNode = tempNode.nextNode;
					tempNode.nextNode.prevNode = previous;
					listLength--;
					tempNode.setNodeItem(null);
					tempNode = null;
				}
			}
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
} // end of class SortedLinkedListMultiset