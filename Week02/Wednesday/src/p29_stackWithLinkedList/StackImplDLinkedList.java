package p29_stackWithLinkedList;


import java.util.EmptyStackException;
import java.util.NoSuchElementException;

interface Stack {
	public int getSize();

	public boolean isEmpty();

	public void push(int value);

	public int pop();
	
	public int peek();

	public void clear();

	public void printStack();
}

public class StackImplDLinkedList implements Stack {
	private DoublyLinkedList top;

	public StackImplDLinkedList() {
		top = new DoublyLinkedList();
	}

	public int getSize() {
		return top.getLength();
	}

	public boolean isEmpty() {
		return top.getLength() == 0;
	}

	public void push(int value) {
		top.addLastElem(value);
	}

	public int pop() {
		int popped;
		try {
			popped = top.removeLast();
		} catch (NoSuchElementException e) {
			throw new EmptyStackException();
		}
		return popped;
	}
	
	public int peek() {
		if(top.getLength() == 0) {
			throw new EmptyStackException();
		}
		
		return top.getTail();
	}

	public void clear() {
		top.clear();
	}
	

	public void printStack() {
		top.printList();
		System.out.println();
	}
}