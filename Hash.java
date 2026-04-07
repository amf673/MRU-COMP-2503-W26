/* An example hash table 
   A. Fedoruk 
   COMP 2503 
*/

public class Hash {
  
   private int TABLE_SIZE;
   Integer[] hash_table; 

   public Hash( int table_size) {
   // Initialize the table to all null
     TABLE_SIZE = table_size; 
     hash_table = new Integer[TABLE_SIZE];
     for ( int i = 0; i < TABLE_SIZE; i++) 
        hash_table[i] = null;
   }

   private int hash_function( int s) {
   // A hash function. The simplest you can have! 
      return s % TABLE_SIZE;
   }


   public boolean add( int s) {
   // Add s to the table. If the slot is full, use linear probing. 
   // if the table is full, return false
      int hash_index = hash_function( s); 
      int i = 0;
      boolean found = false;
      while ( i < TABLE_SIZE && ! found) {  
         if ( hash_table[hash_index] == null) // there is space! 
            found = true;
         else 
             hash_index = (hash_index + 1) % TABLE_SIZE; 
         i++;
      }
      if ( found) {
         hash_table[hash_index] = Integer.valueOf( s); 
         return true;
      } else 
         return false;
   }


   public void run() {

      int[] nums = {10, 20, 12, 14, 3, 2, 7, 8, 26, 16} ;
      // , 14, 26, 39, 17, 5};
      printTable(); 
      for ( int i = 0; i < nums.length; i++) {
         if ( add( nums[i])) 
            System.out.println( "Added " + nums[i]);
         else
            System.out.println( "Did not add " + nums[i]);
    
      }
      printTable(); 
      
   }

   public void printTable() {
   /* Print the table */
      System.out.println( "--------------------");
      for ( int i = 0; i < hash_table.length; i++) {
         if (hash_table[i] == null) 
            System.out.println( (i) + ".\t" + "Empty");
         else 
            System.out.println( (i) + ".\t" + hash_table[i].toString());
      }
      System.out.println( "--------------------");
   }

   public static void main( String[] args) {

      Hash h = new Hash( 13);
      h.run();
   }

}

