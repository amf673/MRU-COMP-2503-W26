public class Q2a {

   public int sum( int n) {

      if ( n == 1) 
         return 1;
      else
         return n + sum( n - 1);
   } 


   public static void main( String args[]) {

      Q2a q2a = new Q2a();
      System.out.println( q2a.sum( 4)); 

   }
}
