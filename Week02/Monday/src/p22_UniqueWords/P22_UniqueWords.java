package p22_UniqueWords;

import java.util.HashSet;
import java.util.Set;

public class P22_UniqueWords {
	public static int uniqueWordsCount(String[] arr) {
		Set<String> hSet = new HashSet<String>();
		
		for(String item: arr) {
			hSet.add(item);
		}
		
		return hSet.size();
	}
	
	public static void main(String[] args) {
		String[] str = new String[] {"apple", "banana", "apple", "pie"};
		System.out.println(uniqueWordsCount(str));

	}
}
