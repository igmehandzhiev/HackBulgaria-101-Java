package p29_hackNumbers;

public class HackNumbers {
	public static boolean isHack(Integer n) {
		if(n % 2 == 0) {
			return false;
		}
		
		String toBinary = Integer.toBinaryString(n);
		if (isPalindrome(toBinary) && oddOnes(toBinary)) {
			return true;
		}
		return false;

	}

	private static boolean oddOnes(String argument) {
		int count = 0;
		for (int i = 0; i < argument.length(); i++) {
			if (argument.charAt(i) == '1') {
				count++;
			}
		}
		return count % 2 != 0;
	}

	private static boolean isPalindrome(String argument) {
		StringBuilder reversed = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--) {
			reversed.append(argument.charAt(i));
		}
		return argument.equals(reversed.toString());
	}

	static int nextHack(Integer n) {
		boolean found = false;
		n++;
		while (!found) {
			if (isHack(n)) {
				found = true;
			} else {
				n++;
			}
		}
		return n;
	}

}
