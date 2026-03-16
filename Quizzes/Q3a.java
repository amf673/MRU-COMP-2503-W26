public class Q3a {

   private String[] animals = { 
      "Moose", "Deer", "Elk", "Pika", "Bear",
      "Wolf", "Yellow-Bellied Marmot", "Chipmunk"};

   private void run() {
      BST<String> bst = new BST<String>();
      for ( int i = 0; i < animals.length; i++) {
         bst.add( animals[i]);
      }

      System.out.println( "Print the Tree" );
      bst.print();
   
      System.out.println( "Foo = " + bst.foo() );
   }

   public static void main( String[] args) {
      Q3a q = new Q3a();
      q.run();
   }
}
