import java.util.*;

public class BST<T> {

   class BSTNode implements Comparable<BSTNode> {
      private String key;
      private ArrayList<T> data = new ArrayList<T>();
      private BSTNode left;
      private BSTNode right;

      public BSTNode( String key, T d) {
         this.key = key;
         setLeft( null);
         setRight( null);
         data.add( d);
      }

      public String getKey() { return this.key;}

      public ArrayList<T> getData() { return data; }
      public void addData(T d) { data.add(d); }

      public void setLeft( BSTNode l) { left = l; }
      public void setRight( BSTNode r) { right = r; }

      public BSTNode getLeft() { return left; }
      public BSTNode getRight() { return right; }

      public boolean isLeaf() {
         return ( getLeft() == null) && ( getRight() == null);
      }

      public int compareTo( BSTNode o) {
         return this.getKey().compareTo(o.getKey());
      }

   }

   // The different traversal types.
   public static final int INORDER = 0;
   public static final int PREORDER = 1;
   public static final int POSTORDER = 2;
   public static final int LEVELORDER = 3;

   private BSTNode root;
   private int size;

   public BST() {
      root = null;
      size = 0;
   }

   /**
    * Return the data if element d is present in the tree.
    */
   public ArrayList<T> find( String k) {
      return find( k, root);
   }

   /**
   * Add element d to the tree.
   */
   public void add( String k, T d) {

      if ( root == null) 
         root = new BSTNode( k, d);
      else 
         add( root, k, d);
      size++;
   }

   /**
    * Return the height of the tree.
    */
   public int height() {
      return height( root);
   }

   /** Return the number of nodes in the tree.
    */
 public int size() {
		return size;
	}

	public void inOrder() {
		traverse(root, INORDER);
	}

	public void postOrder() {
		traverse(root, POSTORDER);
	}

	public void preOrder() {
		traverse(root, PREORDER);
	}


	// Private methods.

   private ArrayList<T> find(String k, BSTNode r) {
      if ( r == null)
         return null;
      else {
         int c = k.compareTo( r.getKey());
         if ( c == 0)
            return r.getData();
	 else if ( c < 0)
            return find( k, r.getLeft());
	 else
            return find( k, r.getRight());
      }
   }

   private void add(BSTNode r, String k, T d) {
   /* Do the actual add of node n to tree rooted at r */
      int c = k.compareTo( r.getKey());
      if ( c == 0) { // Already here so just add the data to the node. 
         r.addData( d);
      }  
      else if ( c < 0) {
      // the element to be added is less than the root
         if ( r.getLeft() == null) { // there is no left node so
				     // we can add it here
            r.setLeft( new BSTNode( k, d));
         } else {                    // add it to the left sub-tree
            add( r.getLeft(), k, d);
         }
      } else { // the element to be added is greater than the root
         if ( r.getRight() == null) {
		// there is no right node so
		// we can add it here
            r.setRight( new BSTNode( k, d));
         } else {
                // add it to the right sub-tree
            add( r.getRight(), k, d);
         }
      }
   }

	/* Implement a height method. */
	private int height( BSTNode r) {
		int h = -1;
		if (r != null) {
			int rh = height(r.getRight());
			int lh = height(r.getLeft());
			h = (rh > lh ? 1 + rh : 1 + lh);
		}
		return h;
	}

	/*
	 * Traverse the tree. travtype determines the type of traversal to perform.
	 */
	private void traverse(BSTNode r, int travType) {
		if (r != null) {
			switch (travType) {
			case INORDER:
				traverse(r.getLeft(), travType);
				visit(r);
				traverse(r.getRight(), travType);
				break;
			case PREORDER:
				visit(r);
				traverse(r.getLeft(), travType);
				traverse(r.getRight(), travType);
				break;
			case POSTORDER:
				traverse(r.getLeft(), travType);
				traverse(r.getRight(), travType);
				visit(r);
				break;
			}
		}
	}

	private void visit(BSTNode r) {
		if (r != null)
			System.out.println(r.getKey() + r.getData());
	}

}
