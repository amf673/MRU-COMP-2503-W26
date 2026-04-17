
public class Row implements Comparable<Row> {
/* A row class for use with the Table class 
 * 
 * Alan Fedoruk
 */

   // Each row consists of a line number 
   private int line_number;
   // and an array of fields (all strings)
   private String[] fields;

   /* Constructors */

   public Row( int i, String l) {
   /* Create a Row() from a csv string */
     line_number = i;
     fields = l.split(",");

   }


   public Row( int i, String[] l) {
   /* Create a Row() from an array of strings */
     line_number = i;
     fields = l;

   }

   public Row copy() {
   /* Return a copy of this row */

      String[] new_fields = new String[numCols()]; 
      for ( int i = 0; i < numCols(); i++) 
         new_fields[i] = fields[i];
      int new_id = getID();
      Row r = new Row( new_id, new_fields); 

      return r; 
   }


   public int compareTo( Row l) { 
   /* The natural ordering, by line number */
      return this.getNum() - l.getNum();

   }


   public boolean equals(Object o) { 
   /* The equals to match compareTo */
      if ( o == null) 
         return false;
      if ( this == o) 
         return true;
      return ( this.getNum() == ((Row)o).getNum()); 
   }

   public int getID()                  { return line_number;} 
   public void setID( int i)           { line_number = i;} 

   public String[] getText()           { return fields;}
   public void setText( String[] line) { fields = line;}

   public int getNum()                 { return line_number;}
   public void setNum( int i)          { line_number = i;}

   public int numCols()                { return fields.length;}
   public String getCol( int col)      { return fields[col]; }

   public String[] getCols() 	       { return fields; }

   public int getColIndex( String col) {
   /* Return the index of the string col, -1 if not found */
      int i = 0;
      boolean found = false;
      while ( i < fields.length && !found) {
         if (fields[i].compareTo( col) == 0) 
            found = true;
	 i++;
      }
      if (found)
         return i - 1;
      else 
         return -1;

   }


   public String toString() {
   /* Return a string representation of the row */
      String cols = ""; 
      for ( int i = 0; i < fields.length; i++) 
	 if ( cols.length() == 0) 
            cols = fields[i];
         else
            cols = cols + ",\t" + fields[i];
      return getNum() + ":\t" + cols;
   }


   public Row project_row( int[] indexes) {
   /* Return a new row that only contains the 
    * columns given in the array indexes. 
    */

      String[] new_fields = new String[indexes.length];

      for ( int i = 0; i < indexes.length; i++) 
         new_fields[i] = this.getCol( indexes[i]);   

      return new Row( this.getNum(), new_fields);
   }

   public Row append_row( Row r) {
   /* Return a new row that appends the columns from 
      this row with the columns of the other row r */

      String[] new_rol_cols = new String[ this.numCols() + r.numCols()];
      for ( int i = 0; i < this.numCols(); i++)
         new_rol_cols [i] = getCol(i);
      for ( int i = 0; i < r.numCols(); i++)
         new_rol_cols [this.numCols() + i] = r.getCol(i);
      return new Row( 0, new_rol_cols); 
   }

}
