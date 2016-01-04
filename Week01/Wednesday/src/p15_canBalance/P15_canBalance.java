package p15_canBalance;

import java.util.Scanner;

public class P15_canBalance {
	public static boolean canBalance(int[] numbers) {
		boolean canBalance = false;
		int leftSide = 0;
		int rightSide = 0;
		
		for(int i = 1; i < numbers.length; i++) {
			
			for(int j = 0; j < i; j++) {
				rightSide += numbers[j];
			}
			for(int j = i; j < numbers.length; j++) {
				leftSide += numbers[j];
			}
			
			if(leftSide == rightSide) {
				return true;
			}
			
			rightSide = 0;
			leftSide = 0;
		}
		
		return canBalance;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean canBalance = canBalance(arr);
		System.out.println(canBalance);
		sc.close();
	}

}