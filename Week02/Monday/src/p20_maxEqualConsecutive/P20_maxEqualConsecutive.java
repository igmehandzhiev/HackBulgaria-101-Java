package p20_maxEqualConsecutive;

public class P20_maxEqualConsecutive {
	public static int maxEqualConsec(int[] items) {
		
		int maxConsecutive = 0;
		int consecutive = 1;
		
		for(int i = 0; i < items.length - 1; i++) {
				if(items[i + 1] == items[i]) {
					consecutive++;
				} else {
					maxConsecutive = Math.max(maxConsecutive, consecutive);
					consecutive = 1;
				}
		}
		
		maxConsecutive = Math.max(maxConsecutive, consecutive);
		
		return maxConsecutive;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
		System.out.println(maxEqualConsec(arr));

	}
}
