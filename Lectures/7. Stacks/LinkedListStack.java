import java.util.EmptyStackException;

public class LinkedListStack<T> implements MyStack<T>{
	private class StackNode <T> {
		public T value;
		public	StackNode <T> next;
		public	StackNode (T x, StackNode <T> n) {value = x; next = n;}
	}
	
	private StackNode <T> top;
	private int size;
	public LinkedListStack() {size = 0; top = null;}
	
	public void push(T x) {
		++size;
		top = new StackNode<T> (x, top); 
	}

	public T pop() {
		if (isEmpty())
			throw new	EmptyStackException();
		T x = top.value;
		top = top.next;
		size--;
		return x;	
	}

	public T peek () {
		if (isEmpty()) throw new EmptyStackException();
		return top.value;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int size() {
		return size;
	}

}
