import java.util.Scanner;

public class P13_maximalScalarSum {
	public static long maximalScalarSum(int[] a, int[] b) {
		if (a.length != b.length) {
			return 0;
		} else {
			long maxScalarSum = 0;

			insertionSort(a);
			insertionSort(b);

			for (int i = 0; i < a.length; i++) {
				maxScalarSum += a[i] * b[i];
			}
			return maxScalarSum;
		}
	}

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
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] a = new int[size];
		int[] b = new int[size];

		System.out.println("vector a: ");
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println("vector b: ");
		for (int i = 0; i < size; i++) {
			b[i] = sc.nextInt();
		}

		System.out.println(maximalScalarSum(a, b));
		sc.close();
	}

}
