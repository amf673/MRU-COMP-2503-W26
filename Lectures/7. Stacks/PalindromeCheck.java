import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
	/**
	 * iSPallindrome checks if the input string is a palindrome. This implementation
	 * is case sensitive and does not ignore spaces or punctuation.
	 * 
	 * @param myString
	 * @return true if the input is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String myString) {
		Stack<Character> st1 = new Stack<>();
		Queue<Character> q1 = new LinkedList<>();

		for (int i = 0; i < myString.length(); i++) {
			st1.push(myString.charAt(i));
			q1.add(myString.charAt(i));
		}

		while (!q1.isEmpty()) {
			if (q1.remove() != st1.pop())
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("racecar is " + (PalindromeCheck.isPalindrome("racecar") ? "a" : "not a") + " palindrome.");
		System.out.println(
				"albatross is " + (PalindromeCheck.isPalindrome("albatross") ? "a" : "not a") + " palindrome.");
	}

}
