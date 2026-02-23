import java.util.*;


public class ReversingAListWithStack
{
    public void printList(int[] list)
    {
        for(int value: list)
            System.out.print("["+value+"]");
        System.out.println();
    }

    public void revWithLoop(int[] list)
    {
        int temp = 0;
        int start = 0;
        int end = list.length-1;

        while(start < end)
        {
            temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            
            start++;
            end--;
        }
    }

    public void revWithStack(int[] list)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        
        for(int value: list)
             stack.push( value);

        while(!stack.isEmpty())
        {
         list[count] = stack.pop();
         count++;
        }
    }

    public static void main(String args[])
    {
        int[] list = {5,2,1,7};
        ReversingAListWithStack rev = new ReversingAListWithStack();

        rev.printList(list);
        //rev.revWithLoop(list);
        rev.revWithStack(list);
        rev.printList(list);
    }
}
