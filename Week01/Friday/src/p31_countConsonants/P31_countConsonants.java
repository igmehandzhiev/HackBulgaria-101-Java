package p31_countConsonants;

import java.util.Scanner;

public class P31_countConsonants {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(CountConsonants.countConsonants(str));
		sc.close();
	}

}
