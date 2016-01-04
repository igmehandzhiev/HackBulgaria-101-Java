package p05_firstUniqueElementCollection;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 2, 3, 4, 5, 5, 7, 4, 3, 1);
		
		try {
			System.out.println(UniqueElement.findFirstUnique(ints));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

}