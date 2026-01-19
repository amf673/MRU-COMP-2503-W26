/** Student class starting code. 
 *  COMP 2503 Winter 2023
 *  
 */

public class Student 
{
	/*
	 * Alter the code for student class to implement the Comparable interface. 
	 * Comparable should implement an ordering based on �natural ordering�. 
	 * What is a good natural ordering? 
	 * Add a Comparator for this class. It should order students in order 
	 * of ascending program, descending OWL, then ascending ID. 
	 */
	
    // this is an example of using static. i is our counter for 
    // student ids. Because it is static there will only ever be one 
    // instance of i so we can use it to keep track of the next id. 
    private static int i; 
    	
	
	private int id; 
    private String firstName;
    private String lastName;
    private String program;
    private int owl;

    
    public Student()
    {
        id = i++;
        firstName = "";
        lastName = "";
        program = "";
        owl = 0;
    }
    
    public int getID() { return id;}
    public void setFirstName( String fn) { firstName = fn;}
    public void setLastName( String ln) { lastName = ln;}
    public void setOWL( int g) { owl = g;}
    public String getFirstName( ) { return firstName;}
    public String getLastName( ) { return lastName;}
    public int getOWL( ) { return owl;}
    public void setProgram( String p) { program = p;}
    public String getProgram() { return program ;}
}
