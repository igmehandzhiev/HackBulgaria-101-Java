package p08_smallestMultiple;


public class P08_smallestMultiple {
	public static long getSmallestMultiple(int upperBound) {
		int result = upperBound * 2;
		boolean found = false;

		while (!found) {
			found = true;
			for (int i = 3; i <= upperBound; i++) {
				if (result % i != 0) {
					result++;
					found = false;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		long result = getSmallestMultiple(23);
		System.out.println(result);

	}
}