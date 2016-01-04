package p07_divisionFunc;

public class DivisionFunc {
	
	public static<F extends Number, S extends Number> double division(F first, S second) {
		return first.doubleValue() / second.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(division (new Integer(5), new Double(8.2)));

	}
}
