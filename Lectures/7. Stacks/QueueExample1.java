import java.util.*;

public class QueueExample1 {
	public static void main (String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();

        q.add(0);
        q.add(5);
        q.add(6);  
        
        while(!q.isEmpty())
        {
           System.out.println( q.remove() );
        }
	}

}
