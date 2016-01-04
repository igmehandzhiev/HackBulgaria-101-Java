package p01_correctBrackets;

import java.util.Stack;

public class Brackets {
	public static boolean areCorrect(String input) {
		
		Stack<Character> brackets = new Stack<Character>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				brackets.push(input.charAt(i));
			} else {
				if(brackets.isEmpty()) {
					return false;
				}
				brackets.pop();
			}
		}
		return brackets.isEmpty();
	}
}
