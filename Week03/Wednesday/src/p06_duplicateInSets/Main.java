package p06_duplicateInSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		Set<Integer> set2 = new HashSet<>();
		set2.add(4);
		set2.add(5);
		set2.add(6);

		Set<Integer> set3 = new HashSet<>();
		set3.add(5);
		set3.add(6);
		set3.add(7);
		set3.add(8);
		
		List<Set<Integer>> setsList = new ArrayList<>();
		setsList.add(set1);
		setsList.add(set2);
		setsList.add(set3);
		
		System.out.println(DuplicatesInSets.findDuplicates(setsList));
	}

}
