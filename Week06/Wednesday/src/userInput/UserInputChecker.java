package userInput;


public class UserInputChecker {

	interface Validator {

		public boolean validate(String input);

	}

	class PersonNameValidator implements Validator {

		@Override
		public boolean validate(String input) {

			if (input.length() == 0) {
				throw new IllegalArgumentException("Name cannot have 0 letters");
			} else if (input.length() > 1) {
				input = input.replaceAll(" ", "");
			}

			boolean areOnlyLetters = input.matches("[a-zA-Z]+");
			boolean firstLetterUppercase = Character.isUpperCase(input.charAt(0));

			if(areOnlyLetters && firstLetterUppercase) {
				return true;
			}
			return false;
		}
	}

	class BulgarianPhoneNumberValidator implements Validator {

		@Override
		public boolean validate(String input) {
			
			if(!input.matches("[0-9]+")) {
				throw new IllegalArgumentException("Phone number has letters!");
			}
			
			if (input.length() != 10 && input.length() != 12) {
				throw new IllegalArgumentException("Phone number lenght is not valid");
			}

			StringBuilder firstThreeDigits = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				firstThreeDigits.append(input.charAt(i));
			}

			if (firstThreeDigits.toString().equals("088") || firstThreeDigits.toString().equals("087")
					|| firstThreeDigits.toString().equals("089")) {
				return true;

			} else if (firstThreeDigits.toString().equals("359")) {
				StringBuilder nextTwoDigits = new StringBuilder();

				for (int i = 3; i < 5; i++) {
					nextTwoDigits.append(input.charAt(i));
				}

				if (nextTwoDigits.toString().equals("88") || nextTwoDigits.toString().equals("87")
						|| nextTwoDigits.toString().equals("89")) {
					return true;
				}

			} else {
				return false;

			}

			return false;
		}
	}
	
	class PersonAgeValidator implements Validator {
		
		@Override
		public boolean validate(String input) {
			
			if(!input.matches("[0-9]+")) {
				return false;
			}
			
			int age = Integer.parseInt(input);
			
			return age > 0 && age < 100;
		}
	}
	
	class CreditCardNumberValidator implements Validator {
		
		@Override
		public boolean validate(String input) {
			
			
			return false;
		}
	}
}
