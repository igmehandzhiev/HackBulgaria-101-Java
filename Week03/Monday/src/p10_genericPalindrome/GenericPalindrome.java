package p10_genericPalindrome;

public class GenericPalindrome {

	public static <T> boolean isPalindrome(T argument) {

		StringBuilder argumentStr = new StringBuilder();
		argumentStr.append(argument.toString());

		StringBuilder reversed = argumentStr.reverse();

		return argumentStr.equals(reversed);
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(new String("damad")));

	}
}
