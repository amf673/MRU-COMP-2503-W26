/* A simple Node class  for the Linked List examnple
 * AMF Winter 2026 
 */ 


public class Node {

	// a bit of data so the node has something to do. 
	String data;
	// The next Node object reference. 
	Node next;

	public Node ( String s) {
		data = s;
		next = null;
 	}

	// Getters and Setters. Note the type Node
	public void setNext( Node n) { next = n; }
	public Node getNext() { return next; }
	public String getData() { return data; }

	public String toString () {
	/* return a string representation. */

		return "Node: " + data;

	}
}
