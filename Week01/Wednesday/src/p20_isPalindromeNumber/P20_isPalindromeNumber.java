package p20_isPalindromeNumber;

import java.util.Scanner;

public class P20_isPalindromeNumber {
	public static boolean isPalindrome(int argument) {
		int temp = argument;
		int reverseN = 0;
		
		while(temp != 0) {
			reverseN *= 10;
			reverseN += (temp % 10);
			temp /= 10;
		}
		return argument == reverseN;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(isPalindrome(number));
		sc.close();
	}

}