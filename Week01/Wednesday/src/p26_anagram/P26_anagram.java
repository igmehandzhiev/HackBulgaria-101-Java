package p26_anagram;

import java.util.Arrays;
import java.util.Scanner;

public class P26_anagram {
	public static boolean anagram(String A, String B) {
		A = A.toLowerCase().replaceAll("\\s+", "");
		B = B.toLowerCase().replaceAll("\\s+", "");
		
		if(A.length() != B.length()) {
			return false;
		} else {
			char[] arr1 = A.toCharArray();
			Arrays.sort(arr1);
			char[] arr2 = B.toCharArray();
			Arrays.sort(arr2);
			
			for(int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("First String:");
		String a = sc.nextLine();
		System.out.print("Second String:");
		String b = sc.nextLine();
		System.out.println(anagram(a, b));
		sc.close();
	}

}