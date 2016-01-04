package p18_reverseEveryChar;

import java.util.Scanner;

public class P18_reverseEveryChar {

	public static String reverseEveryChar(String arg) {
		StringBuilder reversed = new StringBuilder();
		StringBuilder helper = new StringBuilder();

		for (int i = 0; i < arg.length(); i++) {
			if ((arg.charAt(i) < 'A' || arg.charAt(i) > 'Z') && (arg.charAt(i) < 'a' || arg.charAt(i) > 'z')) {
				String temp = reverseMe(helper.toString());
				reversed.append(temp).append(arg.charAt(i));
				helper.setLength(0);
			} else {
				helper.append(arg.charAt(i));
			}
		}
		
		if (!helper.equals("")) {
			String temp = reverseMe(helper.toString());
			reversed.append(temp);
		}
		
		return reversed.toString();
	}

	public static String reverseMe(String argument) {
		StringBuilder reversed = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--) {
			reversed.append(argument.charAt(i));
		}

		return reversed.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String result = reverseEveryChar(str);
		System.out.println(result);
		sc.close();
	}

}