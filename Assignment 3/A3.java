import java.util.*;
import java.io.*;


public class A3 {
/* Assignment 3 COMP 2503 
   A. Fedoruk
*/

   public void run( String[] filenames) {

      // Load all of the tables. 
      Table[] tables = new Table[filenames.length];
      for ( int i = 0; i < filenames.length; i++) {
         tables[i] = new Table(filenames[i]);
   //      tables[i].setName(filenames[i]);  // added a setName feature. 
      }

      // Print all of the tables 
      for ( int i = 0; i < tables.length; i++) {
      
         System.out.println( "\n Table: " + tables[i].getName());
         System.out.println( "----------------------------");
         tables[i].printTable( 0);
     }
         
      // Add an index and use it to select by colour
      tables[0].addIndex( "colour");

      System.out.println( "\n3. Select colour = black ");
      System.out.println( "----------------------------");

      Table c = tables[0].select( "colour", "Black");
      System.out.println( c.numRows());
      c.printTable( 0);

      // Perform a cross operation between table[1] and table[2]
      Table d = tables[1].cross( tables[2]);
      System.out.println( d.numRows());
      d.printTable( 0);

      // Perform a union between table 1 and table 3
      Table e = tables[1].union( tables[3]);
      System.out.println( e.numRows());
      e.printTable( 0);
 
   }


   private void printArgs( String[] args) {
   // testing method
      for ( int i=0; i < args.length; i++) {
         System.out.println( i + " " + args[i]);
      }
   }


   public static void main( String[] args) {

      A3 a3 = new A3();

      // a2.printArgs( args);
      a3.run( args);

   }
}
