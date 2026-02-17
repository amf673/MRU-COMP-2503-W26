
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

   // The head and tail of the list
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
   }


   public void swap() {
   /* Swap the head and tail elements of the list */

      // if the list is empty, or only has a single element
      // we dont need to do anything.
      if ( size > 1) {
         // Set temp to point to the head node, so we dont lose it.
         Node<T> temp = head;
         // Set head to be the current tail.
         head = tail;
         // The old tail node, now head, had its next pointer
         // set as null. Set it to temp’s next (the existing second
         // node in the list
         head.setNext( temp.getNext());

         // Need to find the right place to move the old head.
         // Spin through the list until you are at the second last node
         Node<T> curr = head;
         while ( curr.getNext() != tail) {
            curr = curr.getNext();
         }
         // Set the second last nodes next to be the old head.
         // It is now at the end of the list, so set tail.
         curr.setNext( temp);
         tail = temp;
         // Set the new tail nodes next to be null.
         tail.setNext( null);
      }
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
}
