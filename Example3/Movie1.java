
public class Movie1 implements Comparable<Movie1> {

	private double rating;
	private String name;
	private int year;

	public int compareTo(Movie1 m) {
		return this.year - m.year;
	}

	public Movie1(String n, double r, int y) {
		this.name = n;
		this.rating = r;
		this.year = y;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		Movie1 m = (Movie1) other;
		return this.year == m.getYear();
	}
}
