package p06_doubleFac;

import java.util.Scanner;

public class P06_doubleFac {
	public static long factorial(long n) {
		if (n < 0) {
			throw new IllegalArgumentException("negative number");
		}
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static long doubleFactorial(int n) {
		long result = factorial(factorial(n));
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		try {
			System.out.println(doubleFactorial(num));
		} catch (IllegalArgumentException e) {
			System.out.println("Undefined. Number must be non-negative");
		}
		sc.close();
	}

}