package p38_zeroInsertion;


public class P38_zeroInsertion {
	public static int zero_insert(int n) {
		StringBuilder number = new StringBuilder();
		String numberStr = Integer.toString(n);
		
		for (int i = 0; i < numberStr.length(); i++) {

			if ( i - 1 >= 0) {
				int num1 = Character.getNumericValue(numberStr.charAt(i - 1));
				int num2 = Character.getNumericValue(numberStr.charAt(i));
				if (num1 == num2 || (num1 + num2) % 10 == 0) {
					number.append('0');
			    }
			}
			
			number.append(numberStr.charAt(i));
		}
		return Integer.parseInt(number.toString());
	}

	public static void main(String[] args) {
		System.out.println(zero_insert(6446));

	}

}
