/* A simple linked list. 
 */

public class List {

	// The head of the list! 
	Node head;

	public List() {
		// want to start with an empty list
		head = null;
	}

	public Node getHead() { return head;}
	public void setHead( Node n) { head = n;}

	public void addHead( Node n) {
	/* Add Node n at the start of the list. */

		// set n's next to the head
		n.setNext( getHead());
		// reset head to be the new node.
		setHead( n);
	}

	public void addTail( Node n) {
	/* Add Node n to the tail of the list */
		
		if (getHead() == null) {
			// the list is empty so we can do the same as addhead
			addHead( n); 
		} else {
			Node curr = getHead();
			// we can do this because we know curr is not null 
			while ( curr.getNext() != null) {
				curr = curr.getNext();
			} 
			// now curr is the last item in the list. 
			curr.setNext( n);
		}

	}


	public boolean nodeExists( String s) {

		boolean found = false;
		Node curr = getHead();
		while ( curr != null && !found) {
			System.out.println( curr);
			if ( curr.getData().compareTo( s) == 0) {
				found = true;
			}
			curr = curr.getNext();
		} 
		return found;
	}

	public void printList() {

		Node curr = getHead();
		while ( curr != null) {
			System.out.println( curr); 
			curr = curr.getNext();
		}
	}


}
