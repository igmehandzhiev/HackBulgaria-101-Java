package p17_fibonacciNumbers;

import java.util.Scanner;

public class P17_fibonacciNumbers {
	public static long fibonacci(long n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static long fibNumber(long n) {
		StringBuilder str = new StringBuilder();
		for (long i = 1; i <= n; i++) {
			str.append(fibonacci(i));
		}
		return Long.parseLong(str.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(fibNumber(n));
		sc.close();
	}

}