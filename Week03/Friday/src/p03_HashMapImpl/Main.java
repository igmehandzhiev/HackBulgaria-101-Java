package p03_HashMapImpl;

public class Main {
	public static void main(String[] args) {
		MyHashMap<String, Integer> myMap = new MyHashMap<>();
		
		for(int i = 0; i < 120; i++) {
			myMap.put(i + "", i);
		}
		myMap.put(null, 42);
		myMap.display();

		/*MyHashMap<String, Integer> myMap2 = new MyHashMap<>();
		myMap2.putAll(myMap);
		myMap2.display();*/
		
	}
}
