class Node
{
   private String data = ""; 
   private Node next = null;
   private Node other = null;

   public Node (String d) { data = d;}

   public String getData() { return data;}
   public void setNext( Node link) { next = link; }
   public Node getNext() { return next; }
   public void setOther( Node link) { other = link; }
   public Node getOther() { return other; }
}

public class Q2
{
   public static void main( String args[])
   {
      Node r1;
      Node r2;
      r1 = new Node( "Tunnel");
      r2 =  new Node( "Rundle");
      r1.setNext( r2);
      r2.setNext( new Node( "Cory"));

      r2 = new Node("Edith");
      r2.setNext( r1); 
      r1.getNext().getNext().setNext(r2);

      Node curr = r1;
      for ( int i = 0; i < 6; i++) {
         System.out.println( i + " " + curr.getData());
         curr = curr.getNext();
      }
      System.out.println(curr.getData());
   }
}

