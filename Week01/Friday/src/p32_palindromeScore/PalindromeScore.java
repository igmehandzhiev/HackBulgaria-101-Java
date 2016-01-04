package p32_palindromeScore;

public class PalindromeScore {
	static boolean isPalindrome(int argument) {
		
		StringBuilder str = new StringBuilder();
		str.append(argument);
		
		return str.toString().equals(str.reverse().toString());
	}
	
	static int pScore(int n) {
		if(isPalindrome(n)) {
			return 1;
		} else {
			
			StringBuilder str = new StringBuilder();
			str.append(n);
			
			int reverseN = Integer.parseInt(str.reverse().toString());
			
			int sum = n + reverseN;
			return (1 + pScore(sum));
		}
	}
}
