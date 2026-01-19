/*
 * Comparable interface: it is capable of comparing itself with another object. The class
 * must implement java.lang.Comparable interface to compare its instances
 * 
 * This example shows using Collections.sort
 */

import java.util.*;

public class MovieTest {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);
		System.out.println("Movies after sorting : ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());

		}
	}

}