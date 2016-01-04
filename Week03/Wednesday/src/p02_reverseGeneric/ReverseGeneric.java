package p02_reverseGeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class ReverseGeneric {
	
	static <T> void reverse (Collection<T> collection) {
		Stack<T> holder = new Stack<>();
		
		holder.addAll(collection);
		collection.clear();
		
		while(!holder.isEmpty()) {
			collection.add(holder.pop());
		}
	}
	
	
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		lst.add(5);
		lst.add(6);
		lst.add(7);
		lst.add(8);
		reverse(lst);
		
		for(Integer elems: lst) {
			System.out.println(elems);
		}
	}
}
