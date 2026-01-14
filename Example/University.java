import java.util.Scanner;

/* Test out the Faculty Class */

public class University {

    public static void main( String[] args) {

        // Create two Faculty Objects
        Faculty f1 = new Faculty();
        Faculty f2 = new Faculty();

        // Set up a Scanner
        Scanner s = new Scanner( System.in);
        // The data is one line per item. i.e. name on the first line, then email, then rank 
        // then number of years. 

        // Read first one... 
        String w = s.nextLine();
        f1.setName( w);
        w = s.nextLine();
        f1.setEmail( w);
        w = s.nextLine();
        f1.setRank(w);
        w = s.nextLine();
        f1.setYears( Integer.parseInt(w));

        // Read second one ... 
        w = s.nextLine();
        f2.setName( w);
        w = s.nextLine();
        f2.setEmail( w);
        w = s.nextLine();
        f2.setRank(w);
        w = s.nextLine();
        f2.setYears( Integer.parseInt(w));

        s.close();

        // Print the records 
        System.out.println( f1.toString());
        System.out.println( f2.toString());

        // Compare the two based on years of service. 
        int cmp = f1.compareTo( f2);

        if (cmp > 0) {
            System.out.println( f1.getName() + " is more senior");
        } else if (cmp < 0) {
            System.out.println( f2.getName() + " is more senior");}
        else {
            System.out.println( "They are equal seniority");
        }
    }

}
