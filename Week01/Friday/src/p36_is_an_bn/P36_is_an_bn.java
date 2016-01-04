package p36_is_an_bn;

import java.util.Stack;

public class P36_is_an_bn {

public static boolean is_an_bn(String word) {
		
		Stack<Character> st = new Stack<Character>();
		int index = 0;
		int end = word.length();
		
		while (index < end && word.charAt(index) == 'a') {
			st.push(word.charAt(index));
			index++;
		}
		
		while (index < end && word.charAt(index) == 'b') {
			if(st.empty()) {
				return false;
			}
			st.pop();
			index++;
		}
		
		if (!st.isEmpty() && index == end) {
			return false;
		} else if (index != end) {
			return false;
		} else {
			return true;			
		}
	}

	public static void main(String[] args) {
		System.out.println(is_an_bn("aaabb"));

	}
}
