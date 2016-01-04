package p10_genericStack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;



public class GenericStackImpl<T> implements MyStack<T> {
	private List<T> top;

	public GenericStackImpl() {
		top = new ArrayList<>();
	}

	public int getSize() {
		return top.size();
	}

	public boolean isEmpty() {
		return top.size() == 0;
	}

	public void push(T value) {
		top.add(value);
	}

	public T pop() {
		T popped;
		try {
			popped = top.remove(getSize() -1);
		} catch (NoSuchElementException e) {
			throw new EmptyStackException();
		}
		return popped;
	}
	
	public T peek() {
		if(top.size() == 0) {
			throw new EmptyStackException();
		}
		
		return top.get(getSize() - 1);
	}

	public void clear() {
		top.clear();
	}


	public void printStack() {
		for(T elem: top) {
			System.out.println(elem);
		}	
	}
}

