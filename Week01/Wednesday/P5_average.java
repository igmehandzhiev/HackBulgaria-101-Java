import java.util.Scanner;

public class P5_average {
	public static int getAverage(int[] array) {
		int allElems = 0;
		
		for (int i = 0; i < array.length; ++i) {
			allElems += array[i];
		}
		return allElems / array.length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		int average = getAverage(arr);
		System.out.println(average);
		sc.close();
	}

}
