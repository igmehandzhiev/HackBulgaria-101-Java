package shopInventory;

import vatTaxCalc.*;

public class Product {
	
	private String name;
	private double priceBeforeTax;
	private double priceAfterTax;
	private Country country;
	private int quantity;
	private int id;

	
	public Product(String name, double price, Country country, int quantity, int id) {
		this.name = name;
		this.priceBeforeTax = price;
		this.priceAfterTax = priceBeforeTax + VatTaxCalc.CalculateTax(priceBeforeTax, country.getCountryID());
		this.country = country;
		this.quantity = quantity;
		this.id = id;
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getPriceBeforeTax() {
		return priceBeforeTax;
	}
	
	public double getPriceAfterTax() {
		return priceAfterTax;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getID() {
		return id;
	}
	
	
}
