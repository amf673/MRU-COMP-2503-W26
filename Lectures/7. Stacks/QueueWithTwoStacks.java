import java.util.*;

public class QueueWithTwoStacks <T> {
	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();
	
	public void add(T data) {
		s1.push(data);
	}
	
	public T remove() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public T element() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	public boolean isEmpty() {
		if (s1.isEmpty() && s2.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main (String[] args) {
		QueueWithTwoStacks<String> q = new QueueWithTwoStacks<>();

        q.add("Telemachy");
        q.add("Apologoi");
        q.add("Nostos");
        q.add("Anagnorisis");
        q.add("Sema");
        
        while(!q.isEmpty())
        {
           System.out.println( q.remove() );
        }
	}
}
