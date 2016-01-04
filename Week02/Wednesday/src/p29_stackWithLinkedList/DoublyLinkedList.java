package p29_stackWithLinkedList;


import java.util.NoSuchElementException;

class Node {
	private int info;
	private Node next;
	private Node previous;
	
	public Node(int info) {
		this.info = info;
	}
	
	public int getInfo() {
		return info;
	}
	
	public Node getNext() {
		return next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}

public class DoublyLinkedList implements DLinkedList {


	private Node first;
	private Node last;
	private int length;

	
	public boolean isEmpty() {
		return length == 0;
	}

	public int getLength() {
		return length;
	}

	public void addFirstElem(int dataToAdd) {
		Node newNode = new Node(dataToAdd);

		if (this.isEmpty()) {
			newNode.setNext(null);
			newNode.setPrevious(null);
			first = newNode;
			last = newNode;
		} else {
			newNode.setNext(first);
			newNode.setPrevious(null);
			first.setPrevious(newNode);
			first = newNode;
		}
		++length;
	}

	public void addLastElem(int dataToAdd) {
		Node newNode = new Node(dataToAdd);

		if (this.isEmpty()) {
			addFirstElem(dataToAdd);
			return;
		} else {
			newNode.setPrevious(last);
			newNode.setNext(null);
			last.setNext(newNode);
			last = newNode;
			length++;
		}
	}

	public void addElem(int position, int dataToAdd) {

		if (position < 0 || position > length) {
			throw new IndexOutOfBoundsException("Index out of bounds. Can not add another element");
		}

		if (position == 0) {
			addFirstElem(dataToAdd);
			return;
		}
		if (position == length) {
			addLastElem(dataToAdd);
			return;
		}

		Node iterate = first;
		int counter = 0;

		while (counter < position) {
			iterate = iterate.getNext();
			counter++;
		}

		Node newNode = new Node(dataToAdd);
		newNode.setNext(iterate);
		newNode.setPrevious(iterate.getPrevious());
		iterate.getPrevious().setNext(newNode);
		iterate.setPrevious(newNode);
		++length;

	}

	public void remove(int position) {
		if (position < 0 || position >= length) {
			throw new IndexOutOfBoundsException("Index out of bounds. Can not remove.");
		}

		Node iterate = first;
		int counter = 0;
		while (counter < position) {
			iterate = iterate.getNext();
			counter++;
		}

		if (iterate == first) {
			iterate.getNext().setPrevious(null);
			first = iterate.getNext();
			iterate = null;

		} else if (iterate == last) {
			iterate.getPrevious().setNext(null);
			last = iterate.getPrevious();
			iterate = null;
		} else {

			iterate.getNext().setPrevious (iterate.getPrevious());
			iterate.getPrevious().setNext(iterate.getNext());
			iterate.setNext(null);
			iterate.setPrevious(null);
		}
		--length;
	}
	
	public int removeFirst() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		int valueLast = first.getInfo();
		Node temp = first;
		
		if(temp.getNext() != null) {
			temp.getNext().setPrevious(null);
			first = temp.getNext();
			temp.setNext(null);
		} else {
			first = null;
			last = null;
		}
		
		--length;
		return valueLast;
	}

	public int removeLast() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		int valueLast = last.getInfo();
		
		if(last.getPrevious() == null) {
			first = null;
			last = null;
		} else {
			Node temp = last;
			temp.getPrevious().setNext(null);
			last = temp.getPrevious();
			temp.setPrevious(null);			
		}


		--length;
		return valueLast;
	}

	public int get(int index) {

		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index out of bounds. No element at this index.");
		}

		Node iterate = first;
		int counter = 0;
		while (counter < index) {
			iterate = iterate.getNext();
			counter++;
		}
		return iterate.getInfo();
	}

	public int getHead() {
		return first.getInfo();
	}

	public int getTail() {
		return last.getInfo();
	}
	
	public void clear() {
		while(length != 1) {
			removeLast();
		}
		removeFirst();
		
	}

	public void printList() {
		Node current = first;
		while (current != null) {
			System.out.print(current.getInfo() + " ");
			current = current.getNext();
		}
	}

}