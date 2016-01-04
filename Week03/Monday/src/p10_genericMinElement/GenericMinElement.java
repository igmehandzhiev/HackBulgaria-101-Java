package p10_genericMinElement;

public class GenericMinElement {
	
	public static<T extends Comparable<T> > T minElement(T[] arr) {
		T min = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(min.compareTo(arr[i]) > 0) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(minElement(new Integer[] { 6, 1, 12, 42, 2 }));
		System.out.println(minElement(new Double[] { 6.2, 1.9, 1.2, 42.2, 2.0 }));
		System.out.println(minElement(new String[] { "zzzz", "two", "three", "a", "five" }));
	}

}
