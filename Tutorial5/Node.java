
class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> next;

	/*
	 * Constructor for objects of class Node
	 */
	public Node(T d) {
		data = d;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T o) {
		data = o;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> n) {
		next = n;
	}

	public String toString() {
		return "Node: " + getData().toString();
	}

} // Node