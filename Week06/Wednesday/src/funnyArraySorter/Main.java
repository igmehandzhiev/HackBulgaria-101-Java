package funnyArraySorter;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(6, 10, 8, 7, 9);
		
		FunnyArraySorter sorter = new FunnyArraySorter(2);
		sorter.pivotSubtractionSort(list);
		
		for(Integer i: list) {
			System.out.print(i + " ");
		}
	}

}
