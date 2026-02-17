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

public class MT
{
   public static void main( String args[])
   {
      Node r1;
      Node r2;
      r1 = new Node( "Athabasca");
      r1.setNext( new Node( "Prairie") );
      r1.setOther( new Node( "Victoria") );
      r2 = r1;
      r2 = r2.getNext();
      r2.setNext( r1.getOther() );
      r2.setOther( new Node( "Hector"));
      r2 = r2.getOther();
      r2.setNext( new Node( "Eiffel") );
      r2 = r2.getNext();
      System.out.println( r1.getNext().getOther().getData());
   }
}

