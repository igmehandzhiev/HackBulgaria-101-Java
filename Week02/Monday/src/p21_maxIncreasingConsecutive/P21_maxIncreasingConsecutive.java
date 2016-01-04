package p21_maxIncreasingConsecutive;

public class P21_maxIncreasingConsecutive {
	public static int maxIncreasingConsec(int[] items) {
		int consecutive = 1;
		int maxConsecutive = 0;
		
		for(int i = 0; i < items.length - 1; i++) {
			if(items[i + 1] >= items[i]) {
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
		int[] arr = {1, 2, 3, 3, 3, 3, 4, 3, 3};
		System.out.println(maxIncreasingConsec(arr));

	}

}
