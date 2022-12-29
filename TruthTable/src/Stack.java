
public class Stack {
	private Node top;
	
	public Stack() {
		top = null;
	}
	
	public void push(char next) {
		Node nextNode = new Node(next);
		nextNode.next = top;
		top = nextNode;
	}
	
	public Node pop() {
		if(top == null) {
			return null;
		}
		Node temp = top;
		top = top.next;
		return temp;
	}
	
	public char popc() {
		if(top == null) {
			return '$';
		}
		Node temp = top;
		top = top.next;
		return temp.data;
	}
	
	public Node peek() {
		return top;
	}
	
	public char peekc() {
		return top.data;
	}
	public boolean isEmpty() {
		return top==null;
	}
}
