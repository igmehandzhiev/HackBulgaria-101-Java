package vatTaxCalc;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			
		Country c1 = new Country("Bulgaria", "BG", 0.20, true);
		Country c2 = new Country("Belgium", "BE", 0.21, false);
		Country c3 = new Country("Croatia", "HR", 0.25, false);
		Country c4 = new Country("Finland", "FI", 0.24, false);
		Country c5 = new Country("Germany", "DE", 0.19, false);
		Country c6 = new Country("Greece", "GR", 0.23, false);
		Country c7 = new Country("Italy", "IT",  0.22, false);
		
		List<Country> countriesEU = new ArrayList<>();
		
		
		CountryManager manager = CountryManager.getInstance();
		
		manager.add(c1);
		manager.add(c2);
		manager.add(c3);
		manager.add(c4);
		manager.add(c5);
		manager.add(c6);
		manager.add(c7);
		
		System.out.println(VatTaxCalc.CalculateTax(100.0));			
		System.out.println();
		
		System.out.println(VatTaxCalc.CalculateTax(100, "IT"));			
		
		} catch (NotSupportedCountryException nsc) {
			System.out.println(nsc.getMessage());
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		

	}

}
