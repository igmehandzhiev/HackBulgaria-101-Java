package p18_lucasNumbers;

import java.util.Scanner;

public class P18_lucasNumbers {
	public static int nthLucas(int n) {
		if(n == 0) {
			return 2;
		} else if ( n == 1) {
			return 1;
		} else {
			return nthLucas(n - 1) + nthLucas (n -2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(nthLucas(n));
		sc.close();
	}
}
