import java.util.*;

public class RatingCompare implements Comparator<Movie1> {
	public int compare(Movie1 m1, Movie1 m2) {
		if (m1.getRating() < m2.getRating())
			return -1;
		if (m1.getRating() > m2.getRating())
			return 1;
		else
			return 0;
	}

}