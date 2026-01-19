public class Movie implements Comparable<Movie> {

	private String name;
	private double rating;
	private int year;

	public Movie(String n, double r, int y) {
		this.name = n;
		this.rating = r;
		this.year = y;
	}

	public double getRating() { return rating; }
	public String getName() { return name; }
	public int getYear() { return year; }

	public int compareTo(Movie m) {
		// This compareTo method assumes the natural ordering for Movie objects
		// is by ascending order of year
		if (this.year == m.getYear())
			return 0;
		else if (this.year < m.getYear())
			return -1;
		else
			return 1;
		
		// For comparing integer values, we can use the following short-hand:
		//return this.year - m.year;
	}
	
	// You must override the equals to match the ordering defined
	// by compareTo()
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		Movie m = (Movie) other;
		return this.year == m.getYear();
	}
}
