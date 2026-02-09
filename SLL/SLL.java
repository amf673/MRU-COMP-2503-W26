\begin{lstlisting}[language=java]
class Node <T> {
    /* The Node for use in the SLL. takes a generic 
     * that must be Comparable */

    // Some data of type T
    T data;
    // The next Node object reference. 
    Node<T> next = null;

    // Constructor 
    public Node ( T s) { this.data = s; }

    // Getters and Setters. Note the type Node
    public void setNext( Node<T> n) { next = n; }
    public Node<T> getNext() { return next; }

    public T getData() { return data; }
    public void setData( T d) { data = d; }

    public String toString () { return "Node: " + data; }
}


public class SLL <T> {
/* A simple singly linked list */

    // The head and tail of the list! 
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public SLL() {
	// want to start with an empty list
	head = null;
	tail = null;
	size = 0; 
    }

    public Node<T> getHead() { return head;}
    public void setHead( Node<T> n) { head = n;}
    public Node<T> getTail() { return tail;}
    public void setTail( Node<T> n) { tail = n;}

    public boolean isEmpty() { return ( getHead() == null); }
    public int size() { return size;} 

    public void addHead( T d) {
    /* Add Node n at the start of the list. */
	Node<T> n = new Node<T>(d);

	// set n's next to the head
	//
	if (isEmpty()) {
		setTail( n);
	} else {
		n.setNext( getHead());
		// reset head to be the new node.
	}
	setHead( n);
	size++;
    }

    public void addTail( T d) {
        /* Add Node n to the tail of the list */

	Node<T> n = new Node<T>(d);
	
	if ( isEmpty()) {
		// the list is empty so we can do the same as addhead
		addHead( d); 
	} else {
		Node<T> curr = getHead();
		// we can do this because we know curr is not null 
		while ( curr.getNext() != null) {
			curr = curr.getNext();
	} 
	// now curr is the last item in the list. 
	curr.setNext( n);
	setTail(n);
	size++;
	}


    public void printList() {

	Node<T> curr = getHead();
	int i = 0;
	while ( curr != null) {
	   System.out.print( i ); 
	   System.out.print( " :- " ); 
	   System.out.println( curr); 
	   curr = curr.getNext();
	   i++;
   }
}

\end{lstlisting}
