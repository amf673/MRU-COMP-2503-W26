import java.util.*;


public class RowCompare implements Comparator<Row> {
/* Compare the values of two rows field by field 
   
   Alan Fedoruk COMP 2503 
*/

  
   public int compare( Row r1, Row r2) {
      
      String[] r1_cols = r1.getCols(); 
      String[] r2_cols = r2.getCols(); 

      int i = 0; 
      int compare = 0;
      
      while ( i < r1_cols.length && compare == 0) {     
         compare = r1_cols[i].compareTo( r2_cols[i]);
         i++;
      }

      return compare;
   }
}
