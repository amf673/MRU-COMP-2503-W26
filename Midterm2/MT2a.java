import java.util.Arrays;
public class MT2a {

  public static void main( String[] args) {
      int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
      inception( data.length - 1 , data );
   }

   public static int inception( int i, int[] list) {
      System.out.println( "in inception( " + i + "," + Arrays.toString( list) + " )");
      int result = 0;
      if ( i <= 0) 
         result = i;
      else {
         result += list[i];
         list[i] = inception( i / 2 , list);
         list[i] += result;
         System.out.println( list[i]);
      }
      System.out.println( "out inception( " + i + "," + Arrays.toString( list)+ " )");
      return result;
   }
}


