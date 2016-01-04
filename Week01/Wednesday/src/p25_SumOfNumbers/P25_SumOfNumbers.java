package p25_SumOfNumbers;

import java.util.Scanner;

public class P25_SumOfNumbers {
	public static int sumOfNumbers(String input) {
		int result = 0;
		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				temp.append(input.charAt(i));
			} else if (!temp.toString().equals("")) {
				int toAdd = Integer.parseInt(temp.toString());
				
				result += toAdd;
				temp.setLength(0);
			}
		}
		if (!temp.toString().equals("")) {
			result += Integer.parseInt(temp.toString());
		}
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arg = sc.nextLine();
		System.out.println(sumOfNumbers(arg));
		sc.close();
	}

}