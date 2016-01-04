package vatTaxCalc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VatTaxCalc {
	/*private Map<String, Country> countries;
	private Country defaultCountry;

	public Country getDefaultCountry() {
		return defaultCountry;
	}

	public VatTaxCalc(List<Country> c) {
		countries = new HashMap<>();
		for (Country country : c) {
			countries.put(country.getCountryID(), country);
		}
		
		findDefault();
	}

	private boolean findDefault() {
		for (Country country : countries.values()) {
			if (country.isDefault()) {
				defaultCountry = country;
				return true;
			}
		}
		return false;
	}
	
	
	private Country findCountry(String countryID) {
		
		Country found = countries.get(countryID);
		
		return found;
	}

	public double CalculateTax(String countryID, double productPrice) throws NotSupportedCountryException {
		
		Country country = findCountry(countryID);
		if(country == null) {
			throw new NotSupportedCountryException("Country not present in list!");
		}
		
		double vatPercentage = country.getVATTax();
		double vatTax = productPrice * vatPercentage;
		double totalPrice = productPrice + vatTax;
		
		System.out.println("Net price: " + productPrice);
		System.out.println("VAT (" + vatTax + "): ");
		System.out.println("Total Price: " + totalPrice);
		
		return vatTax;
	}

	public double CalculateTax(double productPrice) {
		
		double vatPercentage = defaultCountry.getVATTax();
		double vatTax = productPrice * vatPercentage;
		double totalPrice = productPrice + vatTax;
		
		System.out.println("Net price: " + productPrice);
		System.out.println("VAT (" + vatTax + "): ");
		System.out.println("Total Price: " + totalPrice);
		
		return vatTax;
	}
	
	public static double CalculateTax(Country country, double productPrice) {
		
		
		double vatPercentage = country.getVATTax();
		double vatTax = productPrice * vatPercentage;
		double totalPrice = productPrice + vatTax;
		
		System.out.println("Net price: " + productPrice);
		System.out.println("VAT (" + vatTax + "): ");
		System.out.println("Total Price: " + totalPrice);
		
		return vatTax;
	}*/
	
	public static double CalculateTax(double price, String countryCode) throws NotSupportedCountryException {
		Country country = CountryManager.getInstance().getCountry(countryCode);
		return price * country.getVATTax() + price;
	}
	
	public static double CalculateTax(double price) throws NotSupportedCountryException {
		return CalculateTax(price, 
				CountryManager.getInstance().getDefaultCountryCode());
	}
	
	public static String CalculateTaxFormatted(double price, String countryCode) throws NotSupportedCountryException {
		return String.format("%.2f%s", CalculateTax(price), countryCode);
	}
	
	public static String CalculateTaxFormatted(double price) throws NotSupportedCountryException {
		return CalculateTaxFormatted(price, 
				CountryManager.getInstance().getDefaultCountryCode());
	}


}
