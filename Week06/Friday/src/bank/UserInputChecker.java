package bank;


public class UserInputChecker {

	interface Validator {

		public void validate(String input);

	}

	class PersonNameValidator implements Validator {

		@Override
		public void validate(String input) throws IllegalArgumentException {

			if (input.length() == 0) {
				throw new IllegalArgumentException("Name cannot have 0 letters");
			} else if (input.length() > 1) {
				input = input.replaceAll(" ", "");
			}

			boolean areOnlyLetters = input.matches("[a-zA-Z]+");
			if(!areOnlyLetters) {
				throw new IllegalArgumentException("Name is not only letters!");
			}
			
			boolean firstLetterUppercase = Character.isUpperCase(input.charAt(0));
			if (!firstLetterUppercase) {
				throw new IllegalArgumentException("Name must start with an uppercase letter!");
			}
		}
	}

	
	class PersonAgeValidator implements Validator {
		
		@Override
		public void validate(String input) {
			
			if(!input.matches("[0-9]+")) {
				throw new IllegalArgumentException("Age must not contain letters!");
			}
			
			int age = Integer.parseInt(input);
			
			if(age < 18 || age > 100) {
				throw new IllegalArgumentException("Age must be between 18 and 99!");
			}
		}
	}
	/*
	class CreditCardNumberValidator implements Validator {
		
		@Override
		public boolean validate(String input) {
			
			
			return false;
		}
	}*/
}
