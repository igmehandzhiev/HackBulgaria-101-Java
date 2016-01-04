package p04_rotateElements;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class RotateElems {

	public static <T> void rotate(Collection<T> collection, int rotateStep) {
		if (rotateStep == 0) {
			return;
		}

		Deque<T> myDeque = new ArrayDeque<>();
		myDeque.addAll(collection);

		if (rotateStep > 0) {
			for (int i = 0; i < rotateStep; i++) {

				myDeque.addFirst(myDeque.getLast());
				myDeque.removeLast();
			}
		} else if (rotateStep < 0) {
			for (int i = rotateStep; i < 0; i++) {

				myDeque.addLast(myDeque.getFirst());
				myDeque.removeFirst();
			}
		}

		collection.clear();
		collection.addAll(myDeque);

	}

}
