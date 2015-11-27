import java.util.Arrays;
import java.util.Scanner;

public class P27_hasAnagramOf {
	public static boolean hasAnagramOf(String A, String B) {
		A = A.toLowerCase().replaceAll("\\s+", "");
		B = B.toLowerCase();
		char[] arr1 = A.toCharArray();
		Arrays.sort(arr1);
		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i <= B.length() - arr1.length; i++) {
			temp.setLength(0);
			
			for(int j = i; j < i + arr1.length; j++) {
				temp.append(B.charAt(j));
			}
			
			char[] tempArr = temp.toString().toCharArray();
			Arrays.sort(tempArr);
			
			if(Arrays.equals(arr1, tempArr)) {
				return true;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("First String:");
		String a = sc.nextLine();
		System.out.print("Second String:");
		String b = sc.nextLine();
		
		System.out.println(hasAnagramOf(a, b));
		sc.close();
	}

}
