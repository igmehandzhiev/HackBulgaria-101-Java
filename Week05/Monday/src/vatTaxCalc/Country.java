package vatTaxCalc;

final public class Country {
	private final String countryID;
	private final double VATTax;
	private final boolean isDefault;
	private final String countryName;
	
	public Country(String name, String id, double tax, boolean isDefault) {
		
		if (tax < 0 || tax > 1) {
			throw new IllegalArgumentException("Invalid Vat Tax");
		}
		
		countryName = name;
		countryID = id;
		VATTax = tax;
		this.isDefault = isDefault;
	}
	
	public boolean isDefault() {
		return isDefault;
	}
	
	public double getVATTax() {
		return VATTax;
	}
	
	public String getCountryID() {
		return countryID;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
}
