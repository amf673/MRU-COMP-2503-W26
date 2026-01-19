import java.util.*;

public class NameCompare implements Comparator<Movie1> {
	public int compare(Movie1 m1, Movie1 m2) {
		return m1.getName().compareTo(m2.getName());
	}
}