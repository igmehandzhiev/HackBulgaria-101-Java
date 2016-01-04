package p03_TripleGeneric;

public class Main {
	
	public static void main(String[] args) {
		Triple<String, Integer, Double> triplet = new Triple<>("one", 1, 1.0);
		System.out.println(triplet.toString());
	}
}
