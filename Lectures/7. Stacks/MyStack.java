
public interface MyStack <T>{
	public void push (T x);
	public T pop ();
	public T peek(); // also known as “top”
	public boolean isEmpty();
	public int size();
}
