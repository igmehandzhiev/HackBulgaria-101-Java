package p01_sortStudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o1.compareTo(o2);
	}
}


public class StudentsSorting {
	
	public static List<Student> sortStudents(List<Student> st) {
		
		Collections.sort(st, new MyComparator());
		
		List<Student> sorted = new ArrayList<>();
		sorted.addAll(st);
		
		return sorted;
	}
}
