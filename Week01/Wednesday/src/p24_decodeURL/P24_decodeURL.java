package p24_decodeURL;

import java.util.Scanner;

public class P24_decodeURL {
	public static String decodeUrl(String input) {
		String decoded = input.replaceAll("%20", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
		
		return decoded;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = sc.nextLine();
		System.out.println(decodeUrl(url));
		sc.close();
	}

}
	
