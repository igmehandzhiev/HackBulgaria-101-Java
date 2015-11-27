import java.util.Scanner;

public class P1_OddNumber {

	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if (isOdd(number)) {
			System.out.println("Odd");
		} else {
			System.out.println("Even");
		}
		
		sc.close();
	}
}
