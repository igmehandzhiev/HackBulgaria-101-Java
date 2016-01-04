package p01_OddNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class P01_OddNumber {

	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			int number = sc.nextInt();
		
			if (isOdd(number)) {
				System.out.println("Odd");
			} else {
				System.out.println("Even");
			}
			
		} catch(InputMismatchException e) {
			System.out.println("Invalid input");
		} finally {
			sc.close();
		}
		
	}
}