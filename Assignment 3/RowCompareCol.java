import java.util.*;


public class RowCompareCol implements Comparator<Row> {
/* Compare the values of two rows field by field 
   
   Alan Fedoruk COMP 2503 
*/

   int col = 0 ;

   public RowCompareCol( int c) {

      col = c;

   }

  
   public int compare( Row r1, Row r2) {
      
      String r1_col = r1.getCol( col); 
      String r2_col = r2.getCol( col); 

      return r1_col.compareTo( r2_col);

   }
}
