public class BST<T extends Comparable<T>> {
/* A Binary search tree */
 
   class BSTNode implements Comparable<BSTNode> {
   /* Each node in the tree is one of these */
      private T data;
      private BSTNode left;
      private BSTNode right;

      public BSTNode(T d) {
         setLeft( null);
         setRight( null);
         setData( d);
      }

      public T getData() { return data; }
      public void setData(T d) { data = d; }

      public void setLeft( BSTNode l) { left = l; }
      public BSTNode getLeft() { return left; }

      public void setRight( BSTNode r) { right = r; }
      public BSTNode getRight() { return right; }

      public boolean isLeaf() { 
         return ( getLeft() == null) && ( getRight() == null); 
      }

      public int compareTo(BSTNode o) {
      /* Make use of the compareTo() implemented on the generic class */
         return this.getData().compareTo( o.getData());
      }
   }


   private BSTNode root;
   private int size;

   public BST() {
      root = null;
      size = 0;
   }

   public int size() {
   /* Return the number of nodes in the tree.
    */
      return size;
   }
	

   public void add( T d) {
   /* Add element d to the tree.  */
      BSTNode n = new BSTNode( d);
      if ( root == null) {
         root = n;
      } else {
         add( root, n);
      }
      size++;
   }

   public void print() {
      traverse( root);
   }

   public T foo() {
      if ( root == null) 
         return null;
      else 
         return foo( root);   
   } 
	
   // Private methods.

   private void add(BSTNode r, BSTNode n) {
   /* Add node r to the tree */
      int c = n.compareTo( r);
      if ( c < 0) {          // the element to be added is less than the root
         if ( r.getLeft() == null) { // no left node so
            r.setLeft( n);           // Add it here
         } else {            // else keep looking
            add( r.getLeft(), n);
         }
      } else if (c > 0) {   // the element to be added is greater than the root
         if ( r.getRight() == null) { // no right node so add it here
            r.setRight( n);
         } else { // keep going down the right subtree
	    add( r.getRight(), n);
         }
      }
   }

   private void visit( BSTNode r) {
   /* Visit a node by printing its data */
      if ( r != null)
         System.out.println( r.getData());
   }
	
   private void traverse( BSTNode r) {
   /* Traverse the tree */
      if ( r == null)
         return;
      else {
         visit( r);
         traverse( r.getRight());
         traverse( r.getLeft());
      }
   }

   private T foo( BSTNode n) {
   /* A foo lish method */
      if ( n.getLeft() == null) {
         return n.getData();
      } else 
         return foo( n.getLeft());
   } 
}
