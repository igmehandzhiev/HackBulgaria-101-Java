package p31_countConsonants;

public class CountConsonants {
	
	static int countConsonants(String str) {
		char[] vowels = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 
				'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
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
