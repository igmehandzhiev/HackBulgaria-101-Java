
public class P29_hackNumbers {
	public static boolean isHack(Integer n) {
		//if n even = false
		String toBinary = n.toBinaryString(n);
		if(isPalindrome(toBinary) && oddOnes(toBinary)) {
			return true;
		}
		return false;
		
	}
	
	static boolean oddOnes(String argument) {
		int count = 0;
		for(int i = 0; i < argument.length(); i++) {
			if(argument.charAt(i) == '1') {
				count++;
			}
		}
		return count % 2 != 0;
	}
	
	static boolean isPalindrome(String argument) {
		String reversed = "";
		for(int i = argument.length() - 1; i >= 0; i--) {
			reversed += argument.charAt(i);
		}
		return argument.equals(reversed);	
	}
	
	static int nextHack(Integer n) {
		boolean found = false;
		n++;
		while(!found) {
			if(isHack(n)) {
				found = true;
			} else {
				n++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(isHack(8031));
		System.out.println(nextHack(8031));

	}

}
