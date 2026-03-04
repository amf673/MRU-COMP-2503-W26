import java.util.*;


public class Table {
/* Table class. 
 * 
 * This implements a table data structure, in 
 * this case a set of rows each consisting of 
 * an id and a text string. 
 *
 * Alan Fedoruk, COMP 2503 
 */

   /* The table itself is an ArrayList of Row() objects 
    */
   ArrayList<Row> rows  = new ArrayList<Row>();

   public void addRow( int row, String text) {
   /* Add a row of text */

      rows.add( new Row( row, text));

   }


   public void printTable( int r) {
   /* Print the first r rows in the table. If r is 0, print the 
    * whole table. 
    */

      if ( r == 0 || r > numRows()) 
         r = numRows();

      for ( int i = 0; i < r; i++) 
         System.out.println( rows.get( i).toString());

   }


   public int numRows() {
   /* Return the current number of rows in the table */

      return rows.size();
	
   }


   public Table select( String s) {
   /* Create a new Table object that contains only 
    * rows that contain the string s. 
    */

      Table sel = new Table();
      int i = 0;
      for ( Row line : rows) {
         if ( line.getText().contains( s)) {
            sel.addRow( i++,  line.getText());
         }
      }
      return sel;
	
   }


   public void sort() {
   /* Sort the table rows by the natural ordering of Row() */

      Collections.sort( rows);

   }


   public void sortText() {
   /* Sort the table rows by the text in the  Row() */

      Collections.sort( rows, new RowTextCmp());

   }
}

