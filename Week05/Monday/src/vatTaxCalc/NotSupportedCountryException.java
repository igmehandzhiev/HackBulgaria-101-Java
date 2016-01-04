package vatTaxCalc;

public class NotSupportedCountryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4869641549961243948L;
	public NotSupportedCountryException() {
		super();
	}
	public NotSupportedCountryException(String message) {
		super(message);
	}
	
}
