package userInput;

public class Main {

	public static void main(String[] args) {
		UserInputChecker checker = new UserInputChecker();
		UserInputChecker.PersonNameValidator nameValidator = checker.new PersonNameValidator();
		
		System.out.println("NAME: ");
		try {
			nameValidator.validate("sdas");
		} catch(IllegalArgumentException ex) {
			System.out.println("Illegal Name! " + ex.getMessage());
		}
		
		UserInputChecker.BulgarianPhoneNumberValidator phoneValidator = checker.new BulgarianPhoneNumberValidator();
		System.out.println("PHONES: ");
		System.out.println(phoneValidator.validate("359895123456"));
		System.out.println(phoneValidator.validate("0898111222"));
		System.out.println(phoneValidator.validate("0886111222"));
		System.out.println(phoneValidator.validate("0875111222"));
		
		
		
	}

}
