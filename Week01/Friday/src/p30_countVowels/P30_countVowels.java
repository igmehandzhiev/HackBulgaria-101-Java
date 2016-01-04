package p30_countVowels;

import java.util.Scanner;

public class P30_countVowels {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(CountVowels.countVowels(str));
		sc.close();
	}
}
