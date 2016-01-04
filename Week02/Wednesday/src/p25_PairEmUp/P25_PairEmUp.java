package p25_PairEmUp;

public class P25_PairEmUp {

	public static void main(String[] args) {
		Pair<String, Integer> pair1 = Pair.<String,Integer>makePair("sds", 22);
		Pair<String, Integer> pair2 = Pair.<String,Integer>makePair("sds", 22);
		System.out.println(pair1.equals(pair2));

	}

}
