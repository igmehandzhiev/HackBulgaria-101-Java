import java.util.Scanner;

public class P19_isPalindrome {
	public static boolean isPalindrome(String argument) {
		String reversed = reverseMe(argument);
		return argument.equals(reversed);	
	}
	
	public static String reverseMe(String argument) {
		StringBuilder reversed = new StringBuilder(argument.length());
		for(int i = argument.length() - 1; i >= 0; i--) {
			reversed.append(argument.charAt(i));
		}
		return reversed.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String argument = sc.nextLine();
		System.out.println(isPalindrome(argument));
		sc.close();
	}

}
