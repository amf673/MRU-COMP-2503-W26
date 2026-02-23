import java.util.EmptyStackException;

public class ArrayStack<T> implements MyStack<T>{
	private T[] stack;
	private int top;
	
	public ArrayStack() {	// assume unbounded stack
		top = -1;
		stack = (T[]) new Object[10];		// arbitrary initial size
	}
	public boolean isEmpty() {
		return (top == -1); //Empty Stack: top == -1 
	}
	public int size() {
		return top + 1; 
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return stack[top];
	}

	public T pop() {
		if (isEmpty())
			throw new	EmptyStackException();
		T x = stack[top];
		--top;
		return x;
	}
	
	public void push(T x) {
		++top;
		if (top == stack.length) {
			T[] stk = (T[]) new Object[2*stack.length];
			System.arraycopy(stk,0,stack,0,stack.length);
			stack = stk;
		}
		stack[top] = x; 
	}
}
