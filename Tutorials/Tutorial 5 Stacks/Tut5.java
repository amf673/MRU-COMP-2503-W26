import java.util.Scanner;

public class Tut5 {
	private Scanner inp;

	public static void main(String[] args) {
		Tut5 t5 = new Tut5();
		t5.run();
	}

	// Return true if ch is one of the left
	// delimiters.
	private boolean isLeftDelim(char ch) {
		return (ch == '{' || ch == '[' || ch == '(');
	}

	// Return true if ch is one of the right
	// delimiters.
	private boolean isRightDelim(char ch) {
		return (ch == '}' || ch == ']' || ch == ')');
	}

	// Return true if ch1 and ch2 are matched
	// delimiters.
	private boolean match(char ch1, char ch2) {
		return ((ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']') || (ch1 == '(' && ch2 == ')'));
	}

	// Return true if str has all of its delimiters
	// matched, false otherwise.
	private boolean delimitersBalanced(String str) {
		// TODO: Implement...
		boolean matched = false;
		return matched;
	}

	private void run() {
		inp = new Scanner(System.in);
		System.out.print("Enter a string with delimiters: ");
		String str = inp.nextLine();

		boolean balanced = delimitersBalanced(str);
		String output = "balanced";
		if (!balanced)
			output = "not " + output;

		System.out.println("The string is: " + str + ", and the delimiters are " + output + ".");
	}
}