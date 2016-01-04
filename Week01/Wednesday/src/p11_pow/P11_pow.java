package p11_pow;

import java.util.Scanner;

public class P11_pow {
	public static long pow (int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		if( b % 2 == 0) {
			return pow (a*a, b/2);
		} else {
			return a * pow(a*a, b/2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		long result = pow (a, b);
		System.out.println(result);
		sc.close();
	}

}