package p29_stackWithLinkedList;

import java.util.EmptyStackException;

public class Main {
	public static void main(String[] args) {
		StackImplDLinkedList myStack = new StackImplDLinkedList();
		myStack.push(5);
		myStack.push(23);
		myStack.push(42);
		myStack.push(19);
		myStack.printStack();
		
		try {
			System.out.println(myStack.peek());
		} catch (EmptyStackException e) {
			System.out.println("Empty stack. No peaking!");
		}
		
		try {
			myStack.pop();
			myStack.printStack();
			myStack.pop();
			myStack.printStack();
			myStack.pop();
			myStack.printStack();
			myStack.pop();
			myStack.printStack();
			myStack.pop();
		} catch (EmptyStackException e) {
			System.out.println("Empty stack. Can not pop!");
		}
		myStack.printStack();

	}
}
