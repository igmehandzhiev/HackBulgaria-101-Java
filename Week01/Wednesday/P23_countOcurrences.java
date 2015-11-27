import java.util.Scanner;

public class P20_countOcurrences {
	public static int countOcurrences(String needle, String haystack) {
		return (haystack.length() - haystack.replace(needle, "").length()) / needle.length();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Haystack: ");
		String haystack = sc.nextLine();
		
		System.out.print("Needle: ");
		String needle = sc.nextLine();
		
		System.out.println(countOcurrences(needle, haystack));
		sc.close();
	}

}
