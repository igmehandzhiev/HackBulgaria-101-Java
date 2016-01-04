package p02_PairGeneric;

public class Main {
	public static void main(String[] args) {
		Pair<String, Integer> pair1 = new Pair<>("asa", 42);
		Pair<String, Integer> pair2 = new Pair<>("asa", 42);
		System.out.println(pair1.equals(pair2));
	}
}
