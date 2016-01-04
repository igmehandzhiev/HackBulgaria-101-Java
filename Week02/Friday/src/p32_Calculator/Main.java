package p32_Calculator;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		getInput();
	}
	
	public static void getInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Hello, this is my Calculator!");
		System.out.println("Type \"exit\" to quit.");

		while(true){
			System.out.print("Enter expression:>");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;
			}
			
			System.out.println("Output:> " + Calculator.calculate(input));
		}
		
		System.out.println("Bye!");
		sc.close();
	}
}
