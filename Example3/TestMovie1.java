import java.util.*;

public class TestMovie1 {

	public static void printList( ArrayList<Movie1> list) {

		for (Movie1 movie : list) {
			System.out.println(movie.getRating() + " " + movie.getName() + " " + movie.getYear());
		}
	}

	public static void main(String[] args) {

		ArrayList<Movie1> list = new ArrayList<Movie1>();

		list.add( new Movie1( "Force Awakens",       8.3, 2015));
		list.add( new Movie1( "Star Wars",           8.7, 1977));
		list.add( new Movie1( "Empire Strikes Back", 8.8, 1980));
		list.add( new Movie1( "Return of the Jedi",  8.4, 1983));

		// Sort by rating : 
		// (1) Create a Comparator object
		// (2) Call Collections.sort
		// (3) Print Sorted list
		
		// Example 1: Sort by rating:
		//
		System.out.println( "Sorted by rating");

		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort( list, ratingCompare);

		printList( list);

		// Example 2: Sort by name:
		//
		System.out.println( "\nSorted by name");

		NameCompare nameCompare = new NameCompare();
		Collections.sort( list, nameCompare);

		printList( list);

		// Example 3: Sort by year (already implemented as natural ordering of Movie1 class
		//
		System.out.println("\nSorted by year");

		Collections.sort( list);

		printList( list);
	}

}
