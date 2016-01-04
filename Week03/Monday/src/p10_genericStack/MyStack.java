package p10_genericStack;

public interface MyStack<T> {
	public int getSize();

	public boolean isEmpty();

	public void push(T value);

	public T pop();
	
	public T peek();

	public void clear();

	public void printStack();
}
