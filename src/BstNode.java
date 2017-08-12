
public class BstNode<T> {
	
	protected T data = null;
	protected int count;
	protected BstNode<T> next = null;
	protected BstNode<T> previous = null;
	
	public BstNode() {
	}
	
	public BstNode(T data) {
		this.data = data;
		count = 1;
	}
}
