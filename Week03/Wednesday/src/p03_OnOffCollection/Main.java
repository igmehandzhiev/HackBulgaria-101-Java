package p03_OnOffCollection;

public class Main {
	
	public static void main(String[] args) {
		MyHashSet<Integer> myHS= new MyHashSet<>();
		
		myHS.add(5);
		myHS.add(6);
		myHS.add(6);
		myHS.add(6);
		
		
		for(Integer elems: myHS) {
			System.out.println(elems);
		}
	}
}
