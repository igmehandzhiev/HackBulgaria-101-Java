package p04_rotateElements;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		RotateElems.rotate(list, -3);
		
		for(String elem: list) {
			System.out.println(elem);
		}
		
	}
}
