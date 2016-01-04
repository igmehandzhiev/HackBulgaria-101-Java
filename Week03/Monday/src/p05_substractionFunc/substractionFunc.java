package p05_substractionFunc;

public class substractionFunc {
	
	public static<F extends Number, S extends Number> double substraction(F first, S second) {
		return first.doubleValue() -	 second.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(substraction(new Integer(5), new Double(8.2)));

	}
}
