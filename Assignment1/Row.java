

public class Row implements Comparable<Row> {
/* A Table Row. 
 *
 * The row consists of an id 
 * and then a line of text. 
 * 
 * Alan Fedoruk, COMP 2503
 */

   private int line_number;
   private String line_text;


   public Row( int i, String l) {
   /* Construct a new Row() */

      line_number = i;
      line_text = l;

   }


   /* Getters and setters */
   public String getText()           { return line_text;}
   public void setText( String line) { line_text = line;}

   public int getNum()               { return line_number;}
   public void setNum( int i)        { line_number = i ;}


   public int compareTo( Row l) { 
   /* The natural ordering for a Row, by the id */

      return this.getNum() - l.getNum();

   }


   public boolean equals(Object o) { 
   /* An equals consistent with compareTo */

      if ( o ==  null ) 
         return false;
      if ( this == o) 
         return true;

      return ( this.getNum() == ((Row)o).getNum()); 

   }


   public String toString() {
   /* toString() for simple printing */

      return getNum() + ": " + getText();

   }
}

