package p29_stackWithLinkedList;

public interface DLinkedList {

	public void addFirstElem(int dataToAdd);

	public void addLastElem(int dataToAdd);

	public void addElem(int position, int dataToAdd);

	public void remove(int position);
	
	public int removeFirst() ;
	
	public int removeLast();
	
	public void printList();

	public boolean isEmpty();

	public int getLength();

	public int get(int index);

	public int getHead();

	public int getTail();
}