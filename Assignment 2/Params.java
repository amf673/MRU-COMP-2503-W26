
public class Params {

	public static void main( String[] args) {
	/* Shows how to access command line arguments */

		for ( int i = 0; i < args.length; i++) {
			System.out.println( i + ": " + args[i]); 
		}
		// Shows how to split a csv structured string into an array 
		String line = args[0];
		System.out.println( line); 
		String[] columns = line.split(",");

		for ( int i = 0; i < columns.length; i++) {
			System.out.println( i + ": " + columns[i]); 
		}
	}
}


