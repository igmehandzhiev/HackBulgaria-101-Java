import java.util.Scanner;

public class P12_getOddOccurence {

	public static int getOddOccurrence(int[] array) {
		int counter = 0;
		int check = 0;
		
		for(int i = 0; i < array.length; i++) {
			check = array[i];
			for(int j = 0; j < array.length; j++) {
				if(check == array[j]) {
					counter++;
				}
			}
			if(counter % 2 != 0) {
				return check;
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(getOddOccurrence(arr));
		sc.close();
	}

}
