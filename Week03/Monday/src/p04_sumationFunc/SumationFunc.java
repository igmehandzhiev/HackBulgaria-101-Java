package p04_sumationFunc;

public class SumationFunc {
	
	public static<F extends Number, S extends Number> double sumation(F first, S second) {
		return first.doubleValue() + second.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(sumation(new Integer(5), new Double(8.2)));

	}

}
