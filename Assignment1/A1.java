import java.util.*;


public class A1 {
/* Driver class for Assignment 1, COMP 2503 
 *
 * Written by: Alan Fedoruk
 * Winter 2026
 */

   Table a = new Table();

   public void run() {

      // read a file from standard input and load the rows 
      // into the table.

      Scanner inp = new Scanner( System.in); 

      int num = 0;
	
      while ( inp.hasNext()) {
         String line = inp.nextLine();
         num++;
         a.addRow( num, line);

      }

      System.out.println( "\n------------------------\nOriginal Table");
      System.out.println( "Number of Rows = " + a.numRows());
      a.printTable( 1000);

      System.out.println( "\n------------------------\nSorted by Text");
      a.sortText();
      System.out.println( "Number of Rows = " + a.numRows());
      a.printTable( 10);

      System.out.println( "\n------------------------\nSorted by ID");
      a.sort();
      System.out.println( "Number of Rows = " + a.numRows());
      a.printTable( 10);

      System.out.println( "\n------------------------\nSELECT on the");
      Table b = a.select("the");
      System.out.println( "Number of Rows = " + b.numRows());
      b.printTable( 0);

   }

   public static void main( String[] args) {

      A1 a1 = new A1();
      a1.run();
	
   }
}

