package p32_Calculator;


import java.util.List;
import java.util.Stack;

public class Calculator {

	public static double calculate(String input) {

		List<String> reversePolish = CalcUtilityMethods.toReversePolish(input);

		Stack<Double> numbers = new Stack<>();

		for (int i = 0; i < reversePolish.size(); i++) {
			if (CalcUtilityMethods.isNumeric(reversePolish.get(i))) {

				double number = Double.parseDouble(reversePolish.get(i));
				numbers.push(number);

			} else {
				if (numbers.size() < 2) {
					if (reversePolish.get(i).equals("-")) {
						double number = numbers.pop();
						number = number * (-1.0);
						numbers.push(number);
					}
				} else {
					double number1 = numbers.pop();
					double number2 = numbers.pop();
					double result = CalcUtilityMethods.executeOperation(number1, number2, reversePolish.get(i));
					numbers.push(result);

				}

			}
		}

		double endResult = numbers.get(0);

		return endResult;
	}

}
