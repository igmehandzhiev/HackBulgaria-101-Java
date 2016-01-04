package p19_IncrDecrSequence;

import java.util.Scanner;

public class P19_IncrDecrSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
			
		}
		System.out.println(Sequence.isIncreasing(arr));
		System.out.println(Sequence.isDecreasing(arr));
		sc.close();
	}
}
