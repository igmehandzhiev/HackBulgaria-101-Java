package p28_DoublyLinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedListDoubly ll1 = new LinkedListDoubly();
		try {
			ll1.addFirstElem(8);
			ll1.addFirstElem(48);
			ll1.addFirstElem(5);
			ll1.addFirstElem(6);
			ll1.addFirstElem(12);
			ll1.addElem(5, 42);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		ll1.printList();		
		System.out.println();
		
		try {
			ll1.remove(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		ll1.printList();
		
		System.out.println();
		
		try {
			int index = 4;
			int getInt = ll1.get(index);
			System.out.println("Value at index " + index + ": " + getInt);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Head: " + ll1.getHead());
		System.out.println("Tail: " + ll1.getTail());
		
		ll1.clear();
		ll1.printList();
		ll1.addFirstElem(5);
		ll1.printList();

	}
}
