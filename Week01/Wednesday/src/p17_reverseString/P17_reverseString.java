package p17_reverseString;

import java.util.Scanner;

public class P17_reverseString {
	
	public static String reverseMe(String argument) {
		StringBuilder reversed = new StringBuilder(argument.length());
		for(int i = argument.length() - 1; i >= 0; i--) {
			reversed.append(argument.charAt(i));
		}
		return reversed.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String toReverse = sc.nextLine();
		
		System.out.println(reverseMe(toReverse));
		sc.close();
	}

}