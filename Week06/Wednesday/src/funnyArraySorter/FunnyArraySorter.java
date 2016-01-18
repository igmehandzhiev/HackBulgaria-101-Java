package funnyArraySorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunnyArraySorter {
	private Integer mPivot;
	
	public FunnyArraySorter(Integer pivot) {
		mPivot = pivot;
	}
	
	public void reverseSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
	}
	
	public void pivotSubtractionSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer> () {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer newFirstNum = o1 - mPivot;
				
				return newFirstNum.compareTo(o2);
			}
		});
	}
	
	public void pivotDivisionSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer> () {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer newFirstNum = o1 / mPivot;
				
				return newFirstNum.compareTo(o2);
			}
		});
	}
}
