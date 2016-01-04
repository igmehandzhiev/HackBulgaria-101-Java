package p07_kthFac;

import java.util.Scanner;

public class P07_kthFac {
	public static long kthFac(int k, int n) {
		long result = 0;
		long help = n;

		for (int i = 0; i < k; i++) {
			result = 1;
			for (int j = 2; j <= help; j++) {
				result *= j;
			}
			help = result;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("k: ");
		int k = sc.nextInt();
		
		System.out.print("n: ");
		int n = sc.nextInt();
		
		System.out.println(kthFac(k, n));
		sc.close();

	}

}