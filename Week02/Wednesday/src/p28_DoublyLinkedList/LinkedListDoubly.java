package p28_DoublyLinkedList;

class LinkedListDoubly implements DLinkedList {

	private class Node {
		private int info;
		private Node next;
		private Node previous;

		public Node(int info) {
			this.info = info;
		}
	}

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
			newNode.next = null;
			newNode.previous = null;
			first = newNode;
			last = newNode;
		} else {
			newNode.next = first;
			newNode.previous = null;
			first.previous = newNode;
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
			newNode.previous = last;
			newNode.next = null;
			last.next = newNode;
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
			iterate = iterate.next;
			counter++;
		}

		Node newNode = new Node(dataToAdd);
		newNode.next = iterate;
		newNode.previous = iterate.previous;
		iterate.previous.next = newNode;
		iterate.previous = newNode;
		++length;

	}

	public void remove(int position) {
		if (position < 0 || position >= length) {
			throw new IndexOutOfBoundsException("Index out of bounds. Can not remove.");
		}

		Node iterate = first;
		int counter = 0;
		while (counter < position) {
			iterate = iterate.next;
			counter++;
		}

		if (iterate == first) {
			iterate.next.previous = null;
			first = iterate.next;
			iterate = null;
			length--;
		} else if (iterate == last) {
			iterate.previous.next = null;
			last = iterate.previous;
			iterate = null;
			length--;
		} else {
			
			iterate.next.previous = iterate.previous;
			iterate.previous.next = iterate.next;
			iterate.next = null;
			iterate.previous = null;
			length--;
		}

	}

	public int removeFirst() {
		int valueLast = first.info;
		Node temp = first;

		if (temp.next != null) {
			temp.next.previous = null;
			first = temp.next;
			temp.next = null;
		} else {
			first = null;
			last = null;
		}

		--length;
		return valueLast;
	}

	public int removeLast() {
		int valueLast = last.info;
		Node temp = last;

		temp.previous.next = null;
		last = temp.previous;
		temp.previous = null;

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
			iterate = iterate.next;
			counter++;
		}
		return iterate.info;
	}

	public int getHead() {
		return first.info;
	}

	public int getTail() {
		return last.info;
	}

	public void clear() {
		while (length != 1) {
			removeLast();
		}
		removeFirst();
	}

	public void printList() {
		Node current = first;
		while (current != null) {
			System.out.print(current.info + " ");
			current = current.next;
		}
	}
}
