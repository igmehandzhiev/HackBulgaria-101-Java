package p01_sortStudents;

public class Student implements Comparable<Student> {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		Student other = (Student) obj;
		if (this.getGrade() == other.getGrade() && this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Student st) {
		if (this.grade == st.grade) {
			return this.name.compareTo(st.name);

		} else {
			if (this.grade > st.grade) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
