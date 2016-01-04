package p19_IncrDecrSequence;

public class Sequence {
	public static boolean isIncreasing(int[] sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			if(sequence[i] > sequence[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDecreasing(int[] sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			if(sequence[i] < sequence[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
}
