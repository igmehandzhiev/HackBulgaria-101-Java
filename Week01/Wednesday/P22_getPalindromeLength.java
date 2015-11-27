import java.util.Scanner;

public class P22_getPalindromeLength {
	public static int getPalindromeLength(String input) {
		int indexStar = input.indexOf('*');	
		int boundry = 0;
		
		if (indexStar < input.length() - 1 - indexStar) {
			boundry = indexStar;
		} else {
			boundry = input.length() - 1 - indexStar;
		}
		
		int palindromeLength = 0;
		
		for(int i = 1; i <= boundry; i++) {
			if(input.charAt(indexStar - i) == input.charAt(indexStar + i)) {
				palindromeLength++;
			} else {
				return palindromeLength;
			}
		}
		return palindromeLength;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(getPalindromeLength(input));
		sc.close();
	}

}
