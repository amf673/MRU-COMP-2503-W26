
/* Some sample sorting programs */
public class Sorts {

   public void run() {

      String[] animals = {
            "Grizzly Bear", "Black Bear", "Hoary Marmot", 
            "White Tailed Deer", "Elk", "Moose", 
            "Red Squirrel", "Pika", "Mallard", 
            "Raven", "Bald Eagle", "Crow", 
            "Chickadee", "Oregon Junco", "Columbian Ground Squirrel", 
            "Wolverine", "Wolf", "Otter", 
            "Harlequin Duck", "Black Tailed Deer", "Bobcat", 
	    "Lynx", "Cougar", "Deer mouse", 
            "Robin", "Hoary Marmot", "Golden Mantled Groud Squirrel", 
            "Chipmunk", "Mountain Whitefish", 
            "Clark's Nutcracker", "Gray Jay"};

      String[] ani = {"wolf", "Bear", "Deer", "Crow", "Pika"};
      printList( ani);
      sort( ani, 4); 
      printList( ani);
      
   }

   public void printList( String[] list) {
   /* Print the list */
      System.out.println( "--------------------");
      for ( int i = 0; i < list.length; i++) {
         System.out.println( (i + 1) + ".\t" + list[i].toString());
      }
      System.out.println( "--------------------");
   }

   private void swap( int i, int j, String[] list) {
   /* Swap element i with element j in list */
      String temp = list[i];
      list[i] = list[j];
      list[j] = temp;
   }

   public void insertion_sort( String[] list) {
   /* Sort list using an insertion sort */

      for( int index1 = 1; index1 < list.length; index1++) {
         for( int index2 = index1; index2 > 0 && 
                list[index2].compareTo( list[ (index2 - 1)]) < 0 ; index2--)
            swap( index2,  index2 - 1, list);
      }
   }


   public void selection_sort( String[] list) {
   /* Sort list using a selection sort */

      for ( int i = 0; i < list.length; i++) {

         int smallest = i; 

         for ( int j = i + 1; j < list.length; j++)

            if ( list[j].compareTo( list[smallest]) < 0 )
               smallest = j; // new smallest element
			     //
	 if ( i != smallest)
            swap( i, smallest, list);
      }
   } 

   public void bubble_sort( String[] list) {
   /* Sort list using a bubble sort */
      for( int index1 = 0; index1 < list.length; index1++) {

         for( int index2 = 1; index2 < list.length; index2++)

            if( list[index2].compareTo( list[(index2 - 1)]) < 0 )
                 swap( index2, (index2 - 1), list);
      }
   }

   private void merge ( String[] list, int first, int mid, int last) {
      // We have two sublists, left: first-mid, and right: mid+1 to last 
      //
      int leftlen = mid - first + 1;
      int rightlen = last - mid;
      System.out.println( "leftlen = " + leftlen + " rightlen = " + rightlen);

      String left[] = new String[leftlen];
      String right[] = new String[rightlen];

      // Copy the values into the temp left
      for ( int i = 0; i < leftlen; i++)
         left[i] = list[ first + i];

      // Copy the values into the temp right
      for ( int j = 0; j < rightlen; j++)
         right[j] = list[ mid + 1 + j];
	
      // Merge the two lists 
      // indexes for the left, right and main list
      int left_i = 0; 
      int right_i = 0; 
      int main_i = first;

      while ( left_i < leftlen && right_i < rightlen) {

         if ( left[left_i].compareTo( right[right_i]) < 0) {
            // left list item is lower so copy it to main
            list[main_i] = left[left_i];
            left_i++;
         } else {
            // right list item is lower (or equal) so copy it to main 
            list[main_i] = right[right_i];
            right_i++;
         } 
         main_i++;
      }
      // We reached the end of one list but 
      // if we haven't reached the end of left, copy it in
      while ( left_i < leftlen) {
         list[ main_i] = left[ left_i];
         left_i++;
         main_i++;
      }

      // if we haven't reached the end of right, copy it in
      while ( right_i < rightlen) {
         list[main_i] = right[right_i];
         right_i++;
         main_i++;
      }
   }


   public void merge_sort( String[] list, int first, int last) {
      System.out.println( "first = " + first + " last = " + last); 
      if ( first < last) { // if only one item, dont need to do anything
         int mid = ( first + last) / 2;
         merge_sort( list, first, mid);
         merge_sort( list, mid + 1, last);

         merge( list, first, mid, last);
      }
   }


   public void merge_sort( String[] list) {
      merge_sort( list, 0, list.length - 1);
   }

   private int partition( String[] list, int low, int high) {
   // Partition the list. Return the index of the pivot

   System.out.println("In partition " + low + " " + high);
   printList(list);

      // Choose the last element as the pivot
      String pivot = list[high]; 

      int i = ( low - 1);
      for ( int j = low; j < high; j++) {
         // If current element is smaller than or
         // equal to pivot
         if ( list[j].compareTo( pivot) < 0) {
            i++;
            swap( i, j, list); 
         }
      }

      swap( i + 1, high, list); 

   System.out.println("out partition " + (i+1));
   printList(list);
      return i + 1;
    }

   private void quicksort( String[] list, int low, int high) {

      if ( low < high) {
         int p = partition( list, low, high); 
         quicksort( list, low, p - 1);
         quicksort( list, p + 1, high);
      }
   }


   public void quicksort( String[] list) {
      quicksort( list, 0, list.length - 1);

   }

   public void sort( String[] list, int sort) {

     if ( sort == 0) {
        System.out.println( "Selection Sort");
        selection_sort( list);
     } else if ( sort == 1) {
        System.out.println( "Insertion Sort");
        insertion_sort( list);
     } else if ( sort == 2) {
        System.out.println( "Bubble Sort");
        bubble_sort( list);
     } else if ( sort == 3) {
        System.out.println( "Merge Sort");
        merge_sort( list);
     } else if ( sort == 4)  {
        System.out.println( "Quick Sort");
        quicksort( list);
     } else 
        System.out.println( "Out of Sorts");
   }


   public static void main( String[] args) {

      Sorts s = new Sorts();
      s.run();
   }

}
