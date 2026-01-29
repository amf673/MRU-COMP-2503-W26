import java.util.*;
/* Testing our linked list */

public class LinkedList {

	public static void main( String[] args) {

		List l = new List();
	
		Scanner inp = new Scanner( System.in);
		while (inp.hasNext()) {
			String word = inp.next();
			Node n = new Node( word); 
			// l.addHead(n);
			l.addTail(n);
		}

		l.printList();

		if (l.nodeExists( "red")) 
			System.out.println( "Found it!!");
	
	}


}
