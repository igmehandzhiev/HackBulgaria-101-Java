package p02_isPrime;

import java.util.Scanner;

public class P02_isPrime {
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if (isPrime(number)) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}
		
		sc.close();
	}
}