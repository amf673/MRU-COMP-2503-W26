import java.util.*;
import java.io.*;

public class Table {
/* A Table data structure. A table is a header row and then a set of 
 * data rows. 
 *
 * Alan Fedoruk COMP 2503 
 */

   /* Store the header row (column names) separately */
   Row header = null; 
   /* The table is an ArrayList of Rows */
   ArrayList<Row> rows  = new ArrayList<Row>();
   /* the name of this table */
   String name = ""; 
 
   /* If there are any indexes they are stored here. */
   ArrayList<BST<Row>> indexes = new ArrayList<BST<Row>>();

   public Table() { 
   /* A simple constructor */
   }

   public Table( String filename) {
   /* Create a data with the data from the given 
      file. The file should be in correct csv format */

      this.setName( filename.substring( 0, filename.lastIndexOf( '.')));
      try ( Scanner inp = new Scanner( new File(filename)) ) { 
         int num = 0;
         while ( inp.hasNext()) {
            String line = inp.nextLine();
            addRow( num, line);
            num++;
	 }
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      // separate out the header. 
      setHeader( rows.get( 0));
      rows.remove( 0);
      // Set up the array of indexes
      // for now leave them null
      for ( int i = 0; i < this.numColumns(); i++ ) 
         indexes.add( null);
   }

   private void addRow( Row r) {
   /* Add a row object */
      rows.add( r);
   }

   private void addRow( int rownum, String text) {
   /* Adds a row with a given id and the fields in a CSV string */
      rows.add( new Row( rownum, text));
   }

   private void addRow( int rownum, String[] fields) {
   /* Adds a row that is an array of strings */
      rows.add( new Row( rownum, fields));
   }

   private void addRows( ArrayList<Row> new_rows) {
   /* Add the rows in new_rows to the Table */
      for (int i = 0; i < new_rows.size(); i++) {
         addRow( new_rows.get( i));
      }
   }

   public Row getHeader()        { return this.header; }
   public void setHeader( Row h) { this.header = h; }
   public int numRows()          { return this.rows.size(); }
   public String getName()       { return this.name;}
   public void setName( String n) { this.name = n;}
   public int numColumns() { 
   /* Return the number of columns in this table */
      if ( getHeader() == null) 
         return 0;
      else 
         return getHeader().numCols();
   }

   public Row getRow(int i) {
   /* Return the ith row in the table */
      if (i < 0 || i >= this.numRows()) 
         return null;
      else 
         return rows.get( i);  
   }

   public void printTable( int n) {
   /* Print n rows from the table without worrying too much about format. */

      if ( n == 0 || n > numRows()) 
         n = numRows();
      System.out.println( "-------------------");
      System.out.println( header.toString());

      for ( int i = 0; i < n; i++ ) {
         System.out.println( rows.get( i).toString());
      }
      System.out.println( "-------------------");
   }

   public void addIndex( String col) {
   /* Add an index to the table using the column col */ 

      int index = getHeader().getColIndex( col);
      BST<Row> bst = new BST<Row>();
      for ( int i = 0; i < numRows(); i++ ) {
         Row row = rows.get( i);
         String item = row.getCol( index); 
         bst.add( item, row); 
      }
      indexes.set( index, bst);
   }

   public Table project (String[] cols) {
   /* Return a new Table that is a projection 
    * of the existing table. cols is an array 
    * of columns to project over. 
    */

      // get an array of the indexes ofthe columns we want
      int[] col_indexes = new int[cols.length];
      Row header = getHeader();

      for (int i = 0; i < cols.length; i++) {
         col_indexes[i] = header.getColIndex( cols[i]);
      }

      // Set up a new table with the correct header */
      Table projection = new Table();

      Row head = getHeader().project_row( col_indexes);
      head.setID(0);
      projection.setHeader( head);

      // Add the projected rows 

      for ( Row row : rows) 
	 projection.addRow( row.project_row( col_indexes));

      return projection;
   }

   public Table select( String field, String value) {
   /* Returns a new table consisting only of rows 
    * where field = value. 
    */

      // get the column index we care about. 
      Row header = getHeader();
      int column = header.getColIndex( field);

      // Do we have an index?
      BST<Row> index = indexes.get( column);

      // Set up the new table
      Table selection = new Table();
      selection.setHeader( getHeader());

      if ( index == null)  {
         // Scan the table and find the appropriate rows
         for ( int i = 0; i < rows.size(); i++) {
            Row row = rows.get( i);
	    String col = row.getCol( column);

            if ( row.getCol( column).equals( value)) 
	       selection.addRow( row);
         }
      } else {
         ArrayList<Row> rows = index.find( value);
         System.out.println("Using Index");
         if ( rows != null )  
            selection.addRows( rows);
      }

      return selection;
   }

   public Table union (Table t) {
   /* Return a new table that is the union of this table and 
      the given Table t */

      // Check if the tables are the union compatible. 
      if (this.numColumns() != t.numColumns()) 
         return null;
      
      Table union_tab = new Table();
      union_tab.setHeader( this.getHeader());
      for ( int i = 0; i< this.numRows(); i++) {
         union_tab.addRow( this.getRow(i).copy()); 
      }

      for ( int i = 0; i< t.numRows(); i++) {
         union_tab.addRow( t.getRow(i).copy()); 
      }
      return union_tab;
   }

   public Table cross (Table t) {
   /* Return the cross product of this table with table t */

      Table cross_tab = new Table();
      // Create the new header 
      Row cross_header = getHeader().append_row( t.getHeader());
      cross_header.setID(0);
      cross_tab.setHeader( cross_header);

      int id = 0;

      for ( int i = 0; i < this.numRows(); i++) { 
         for ( int j = 0; j < t.numRows(); j++) {
            Row new_row = this.getRow( i).copy().append_row( t.getRow(j));
            new_row.setID( ++id);
            cross_tab.addRow( new_row);
         }
      }
      
      return cross_tab;
   }

   public void sort() {
   /* Sort the rows by the natural order */
      Collections.sort( rows);
   }

   public void sortbyCol( String col) {
   /* Sort the rows by one of the columns  */
      Row header = getHeader();
      int column = header.getColIndex( col);
      Collections.sort( rows, new RowCompareCol( column));
   }
}
