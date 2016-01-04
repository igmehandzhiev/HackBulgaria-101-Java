package p32_Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalcUtilityMethods {

	public static List<String> toReversePolish(String input) {

		StringBuilder processedInput = new StringBuilder();
		processedInput.append(input.replaceAll("\\s+", ""));

		List<String> result = new ArrayList<>();

		Stack<Character> operationsStack = new Stack<Character>();

		for (int i = 0; i < processedInput.length(); i++) {
			
			if (processedInput.charAt(i) >= '0' && processedInput.charAt(i) <= '9') {
				
				String number = getNumber(processedInput.toString(), i);
				result.add(number);
				i += number.length() - 1;
				
			} else {
				if (!operationsStack.isEmpty()) {
					if (processedInput.charAt(i) == ')') {

						while (operationsStack.peek() != '(') {
							char operation = operationsStack.pop();
							result.add(Character.toString(operation));
						}
						operationsStack.pop();

					} else if (getPriority(operationsStack.peek()) >= getPriority(processedInput.charAt(i))
							&& operationsStack.peek() != '(') {

						while (!operationsStack.isEmpty()
								&& getPriority(operationsStack.peek()) >= getPriority(processedInput.charAt(i))
								&& operationsStack.peek() != '(') {
							char operation = operationsStack.pop();
							result.add(Character.toString(operation));
						}
						operationsStack.push(processedInput.charAt(i));

					} else {
						operationsStack.push(processedInput.charAt(i));
					}
				} else {
					operationsStack.push(processedInput.charAt(i));
				}
			}
		}

		while (!operationsStack.isEmpty()) {
			String operation = operationsStack.pop().toString();
			result.add(operation);
		}

		return result;
	}

	static int getPriority(char op) {
		int result = 0;

		switch (op) {
		case '(':
		case ')':
			result = 5;
			break;
		case '*':
		case '/':
			result = 4;
			break;
		case '+':
		case '-':
			result = 3;
			break;
		}

		return result;
	}

	static double executeOperation(double number1, double number2, String operation) {
		double result = 0.0;
		switch (operation) {
		case "+":
			result = number2 + number1;
			break;
		case "-":
			result = number2 - number1;
			break;
		case "*":
			result = number2 * number1;
			break;
		case "/":
			result = number2 / number1;
			break;
		}
		return result;
	}

	static boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	static String getNumber(String input, int index) {

		StringBuilder result = new StringBuilder();
		StringBuilder inputTrimmed = new StringBuilder();
		inputTrimmed.append(input.replaceAll("\\s+", ""));

		for (int i = index; i < inputTrimmed.length(); i++) {
			if (inputTrimmed.charAt(i) >= '0' && inputTrimmed.charAt(i) <= '9') {
				result.append(inputTrimmed.charAt(i));
			} else {
				return result.toString();
			}
		}

		return result.toString();
	}

}
