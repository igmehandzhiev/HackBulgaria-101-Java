package p08_powerFunc;

public class PowerFunc {
	public static<F extends Number> double division(F first, Integer second) {
		return Math.pow(first.doubleValue(), second.intValue());
	}
	
	
	public static void main(String[] args) {
		System.out.println(division (new Double(2.3), new Integer(4)));

	}
}
