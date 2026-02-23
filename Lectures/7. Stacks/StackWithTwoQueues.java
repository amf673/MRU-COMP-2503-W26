import java.util.*;

public class StackWithTwoQueues <T>{
	Queue<T> q1 = new LinkedList<T>();
	Queue<T> q2 = new LinkedList<T>();
	
	public void push(T data) {
		q1.add(data);
	}
	
	public T pop() {
		int q1size = q1.size();
		for (int i = 0; i < q1size - 1; i++) {
			q2.add(q1.remove());
		}
		T ret = q1.remove();
		Queue<T> tempq = q2;
		q2 = q1;
		q1 = tempq;
		return ret;
	}
	
	public T peek() {
		int q1size = q1.size();
		for (int i = 0; i < q1size - 1; i++) {
			q2.add(q1.remove());
		}
		T ret = q1.remove();
		q2.add(ret);
		
		Queue<T> tempq = q2;
		q2 = q1;
		q1 = tempq;
		return ret;
	}
	
	public boolean isEmpty() {
		if (q1.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main (String[] args) {
		StackWithTwoQueues<String> s = new StackWithTwoQueues<String>();
        s.push("Telemachy");
        s.push("Apologoi");
        s.push("Nostos"); 
        s.push("Anagnorisis");
        s.push("Sema");
        
        while (!s.isEmpty())
        {
           System.out.println(s.peek());
           s.pop();
        }       	
	}
}
