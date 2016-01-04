package p32_palindromeScore;

import java.util.Scanner;

public class P32_palindromeScore {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arg = sc.nextInt();
		System.out.println(PalindromeScore.pScore(arg));
		sc.close();
	}
	
}
