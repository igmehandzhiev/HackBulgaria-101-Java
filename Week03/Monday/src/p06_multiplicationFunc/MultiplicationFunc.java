package p06_multiplicationFunc;

public class MultiplicationFunc {
	
	public static<F extends Number, S extends Number> double multiplication(F first, S second) {
		return first.doubleValue() * second.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(multiplication(new Integer(5), new Double(8.2)));

	}

}
