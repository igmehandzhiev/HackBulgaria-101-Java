import java.util.Arrays;
import java.util.NoSuchElementException;

interface Stack {
	public int getSize();
	public int getCapacity();
	public boolean isFull();
	public boolean isEmpty();
	public void resize();
	public void push(Object obj);
	public Object pop();
	public void clear();
	public void printStack();
}

class MyStack implements Stack{
	private static final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private int current;
	private Object arr[];

	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public MyStack(int capacity) {
		this.capacity = capacity;
		arr = new Object[capacity];
	}

	public int getSize() {
		return current;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public boolean isFull() {
		return capacity == current;
	}

	public boolean isEmpty() {
		return current == 0;
	}

	public void resize() {
		capacity *= 2;
		arr = Arrays.copyOf(arr, capacity);
	}

	public void push(Object obj) {
		if (this.isFull()) {
			this.resize();
		}

		arr[current] = obj;
		current++;
	}

	public Object pop() {

		if (this.isEmpty()) {
			throw new NoSuchElementException("Empty Stack");
		}

		Object top = arr[--current];
		arr[current] = null;
		if(current == capacity / 2) {
			capacity /= 2;
		}
		return top;
	}
	
	public void clear() {
		Arrays.fill(arr, null);
		current = 0;
	}
	
	public void printStack() {
		for(int i = 0; i < current; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

public class StackImpl {

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
			System.out.println(st1.getCapacity());
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println(st1.getCapacity());
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println(st1.getCapacity());
			st1.pop();
			st1.printStack();
			System.out.println();
			System.out.println(st1.getCapacity());
		} catch (NoSuchElementException e) {
			System.out.println("Stack is Empty. Can not pop.");
		}
		st1.printStack();
		
	}

}
