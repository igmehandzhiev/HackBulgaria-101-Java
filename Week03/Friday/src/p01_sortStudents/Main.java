package p01_sortStudents;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Student ivan = new Student("ivan", 3);
		Student pesho = new Student("pesho", 2);
		Student vanko = new Student("vanko1", 4);
		Student gosho = new Student("gosho", 6);
		Student rado = new Student("rado", 5);
		
		List<Student> students = new ArrayList<>();
		
		students.add(ivan);
		students.add(pesho);
		students.add(vanko);
		students.add(gosho);
		students.add(rado);
		
		List<Student> sorted = StudentsSorting.sortStudents(students);
		
		for(Student st: sorted) {
			System.out.print(st.getName() + ": " + st.getGrade() + ",");
		}
	}

}
