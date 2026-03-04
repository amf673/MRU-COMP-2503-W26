import java.util.*;


public class RowTextCmp implements Comparator<Row> {
/* Compare two Rows() based on the text in the row. 
 * Alan Fedoruk, COMP 2503
*/

   public int compare( Row r1, Row r2) {
	
      return r1.getText().compareTo( r2.getText());
	
   }
}
