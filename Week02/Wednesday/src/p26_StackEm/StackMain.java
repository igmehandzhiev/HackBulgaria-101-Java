package p26_StackEm;

import java.util.NoSuchElementException;

public class StackMain {
	public static void main(String[] args) {
		MyStack st1 = new MyStack(2);
		st1.push(5);
		st1.push(6);
		st1.push(8);
		st1.push(2);
		st1.push(1);
		st1.push(23);
		st1.printStack();

		
		
		System.out.println();
		try {
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println("Capacity: " + st1.getCapacity());
			
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println("Capacity: " + st1.getCapacity());
			
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println("Capacity: " + st1.getCapacity());
			
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println("Capacity: " + st1.getCapacity());
		} catch (NoSuchElementException e) {
			System.out.println("Stack is Empty. Can not pop.");
		}
		st1.printStack();
		
	}
}
