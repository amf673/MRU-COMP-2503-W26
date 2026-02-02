public class Tut4 {
	   private Node<String> head;
	   private Node<String> tail;
	   
	   private void addHead(Node<String> n) 
	   {
	       // implement: add a node to the head of the list.
		   // make sure to update the head and tail pointers.
	   }
	   
	   private void addTail(Node<String> n) 
	   {
	        // implement: add a node to the end of the list.
			// make sure to update the head and tail pointers.
	   }

	   private Node<String> find(String key) 
	   {
	       // implement find
	       return null;
	   }
	   
	   private Node<String> delete (String key) 
	   {   
		  // implement delete
	      return null;
	   }
	   
	   private void addInOrder(Node<String> n) 
	   {
			// implement addInOrder
	   }
	   
	   
	   private void printList()
	   {
	       System.out.println();
	       Node<String> currentNode = head;
	       while (currentNode != null) 
	       {
	          // Visit the node. In this case, print it out. 
	           System.out.println(currentNode.toString());
	           currentNode = currentNode.getNext();
	       }
	   }
	   
	   public void emptyList()
	   {
	       
	   }
	   
	   public void run() 
	   {
	       
	       
	   }

	public static void main(String[] args) {
		Tut4 tut = new Tut4();
		tut.run();
	}
}
