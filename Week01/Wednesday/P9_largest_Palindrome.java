import java.util.InputMismatchException;
import java.util.Scanner;

public class P9_largest_Palindrome {
	public static boolean isPalindrome(long n) {
		long temp = n;
		long reverseN = 0;
		while(temp != 0) {
			reverseN *= 10;
			reverseN += (temp % 10);
			temp /= 10;
		}
		return n == reverseN;
	}
	
	public static long getLargestPalindrome(long n) {
		
		while(n > 0) {
			if (isPalindrome(n)) {
				return n;
			} else {
				n--;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long input = sc.nextLong();
		
		System.out.println(getLargestPalindrome(input));
		
		sc.close();
	}

}
