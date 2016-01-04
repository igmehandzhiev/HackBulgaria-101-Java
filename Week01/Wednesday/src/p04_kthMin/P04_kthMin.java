package p04_kthMin;

import java.util.Scanner;

public class P04_kthMin {

	public static void insertionSort(int[] arr) {
		int j = 0;
		int temp = 0;

		for (int i = 1; i < arr.length; i++) {
			j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
	}

	public static int kthMin(int k, int[] arr) {
		if(k > arr.length) {
			throw new IllegalArgumentException();
		}
		insertionSort(arr);
		return arr[k - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.print("k: ");
		int k = sc.nextInt();

		try {
			System.out.println(kthMin(k, arr));
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument: k is bigger than the array size.");
		}

		sc.close();

	}

}