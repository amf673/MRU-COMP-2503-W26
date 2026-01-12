import java.util.Scanner;

/**
 * Lab 1 COMP 2503 Winter 2023 Last Updated by: @author Maryam Elahi
 * 
 */
public class Lab1Review {
	Scanner input;

	public void run() {
		input = new Scanner( System.in);
		while ( input.hasNext()) {
			String word = input.next().trim().toLowerCase().replaceAll( "[^a-z]", "");
			if ( word.length() > 0) {
				System.out.println( word);
			}
		}
		System.out.println( "End of stream detected. Terminating the program.");
	}

	public static void main( String[] args) {
		Lab1Review lab1 = new Lab1Review();
		lab1.run();
	}
}
