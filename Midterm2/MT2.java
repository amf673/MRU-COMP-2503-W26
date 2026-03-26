
public class MT2 {

   public static void main( String[] args) {
      
      SLL<String> s = new SLL<String>();
      s.addHead( "Moose");
      s.addHead( "Squirrel");
      s.addHead( "Elk");
      s.addHead( "Deer");
      s.addHead( "Wolf");
      s.addHead( "Wolverine");
      s.addHead( "Chipmunk");

      s.traverse();
      s.traverseR();

      BST<String> t = new BST<String>();
      t.add( "Moose");
      t.add( "Squirrel");
      t.add( "Elk");
      t.add( "Deer");
      t.add( "Wolf");
      t.add( "Wolverine");
      t.add( "Chipmunk");
      t.print();
      System.out.println( t.countLeaves());

   }
}

