package p21_copyEveryChar;

import java.util.Scanner;

public class P21_copyEveryChar {
	public static String copyEveryChar(String input, int k) {
		StringBuilder newStr = new StringBuilder();
		char copyThis = '\0';
		for(int i = 0; i < input.length(); i++) {
			copyThis = input.charAt(i);
			for(int j = 0; j < k; j++) {
				newStr.append(copyThis);
			}
		}
		return newStr.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int k = sc.nextInt();
		
		System.out.println(copyEveryChar(input, k));
		sc.close();
	}

}