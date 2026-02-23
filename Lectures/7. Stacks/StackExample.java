import java.util.*;
public class StackExample
{
    public static void main(String args[])
    {
        Stack<Integer> s1 = new Stack<Integer>();

        s1.push(0);
        s1.push(5);
        s1.push(6);  
        
        while(!s1.isEmpty())
        {
           System.out.println( s1.pop() );
        }
        // This will throw an exception   
        System.out.println( s1.pop() );
        
    }
    
}
