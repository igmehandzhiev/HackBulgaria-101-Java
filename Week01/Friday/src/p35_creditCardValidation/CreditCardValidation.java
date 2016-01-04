package p35_creditCardValidation;

public class CreditCardValidation {
		public static boolean is_credit_card_valid(String number) {
			int[] arrayNumbers = new int[number.length()];
			
			if(number.length() % 2 != 0 ) {
				for(int i = 0; i < number.length(); i++ ) {
					if(i % 2 == 0) {
						int x = Character.getNumericValue(number.charAt(i));
						arrayNumbers[i] = x;
					} else {
						int x = Character.getNumericValue(number.charAt(i)) * 2;
						arrayNumbers[i] = x;
	 				}
				}
				
			} else {
				return false;
			}
			
			int sumArr = sum(arrayNumbers);
			if(sumArr % 10 == 0) {
				return true;
			}
			return false;
		}
		
		public static int sum(int[] array) {
			int allElems = 0;
			
			for (int i = 0; i < array.length; ++i) {
				allElems += array[i];
			}
			return allElems;
		}
}
