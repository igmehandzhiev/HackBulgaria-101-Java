package p14_maxSpan;

import java.util.Scanner;

public class P14_maxSpan {
	public static int maxSpan(int[] numbers) {
		int count = 0;
		int maxCount = 0;
		int toCheck = 0;

		for (int i = 0; i < numbers.length; i++) {
			toCheck = numbers[i];

			for (int j = numbers.length - 1; j > i; j--) {
				if (numbers[j] == toCheck) {
					count = j - i + 1;
					break;
				}
			}

			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int span = maxSpan(arr);
		System.out.println(span);
		sc.close();
	}

}