package p09_factorialFunc;

public class FactorialFunc {
	
	public static<V extends Number> double factorial(V n) {
	    double result = 1.0;
	    for (int i = 1; i <= n.intValue(); i++) {
	        result *= i;
	    }
	    return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(factorial(new Double (4.9)));

	}

}
