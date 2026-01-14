/* 
Faculty class. Extends Employee and implements 
Comparable */

public class Faculty extends Employee implements Comparable<Faculty>  {

    String rank; 
    
    public String getRank() { return rank;}

    public void setRank( String r) { rank = r;}

    @Override
    public int compareTo(Faculty other) {
        // 0 if equal, + if this is bigger, - otherwise 
        return this.getYears() - other.getYears();  
    }


    public String toString() {
        return "Name: " + getName() + "\nEmail: " + getEmail() + "\nRank: " + getRank()  + "\nService: " + getYears();
    }
}
