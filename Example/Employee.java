/* 
A general Employee class 
*/

public class Employee {

    String name;
    String email;
    int years;

    public Employee() {}

    public Employee( String n, int y) {
        this.setName(n);
        this.setYears(y);
        this.setEmail("");
    }

    public void setYears(int y) { years = y;}

    public int getYears() { return years;}

    public void setName(String n) { name = n;}

    public void setEmail(String e) {email = e;}

    public String getName() {return name;}
    
    public String getEmail() {return email;}
}
