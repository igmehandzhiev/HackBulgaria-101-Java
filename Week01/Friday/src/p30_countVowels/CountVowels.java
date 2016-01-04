package p30_countVowels;

public class CountVowels {
	
	static int countVowels(String str) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
		String newStr = str.toLowerCase();
		int countVowels = 0;
		for(int i = 0; i < vowels.length; i++) {
			countVowels += containsCount(newStr, vowels[i]);
		}
		return countVowels;
	}
	static int containsCount(String str, char ch) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
}
