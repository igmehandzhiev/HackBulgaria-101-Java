package shopInventory;

import java.util.ArrayList;
import java.util.List;

import vatTaxCalc.Country;

public class Main {

	public static void main(String[] args) {
		Country bg = new Country("Bulgaria", "BG", 20, true);
		Product p1 = new Product("Fanta", 2.20, bg ,29, 2231230);
		Product p2 = new Product("Kinder", 0.60, bg ,100, 878330);
		Product p3 = new Product("Clever", 0.22, bg ,55, 2135230);
		Product p4 = new Product("Nescafe", 1.70, bg ,32, 367430);
		
		

		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		Inventory inventory = new Inventory(products);
		
		System.out.println("AUDIT: " + inventory.Audit());
		
		Order ord = new Order();
		ord.add(2135230, 55);
		ord.add(367430, 31);
		ord.add(878330, 10);
		
		
		System.out.println(p3.getPriceAfterTax());
		System.out.println(p4.getPriceAfterTax());
		System.out.println(p2.getPriceAfterTax());
		
		try {
			System.out.println(inventory.RequestOrder(ord));
		} catch (NotAvailableInInventoryException e) {
			System.out.println(e.getMessage());
		}
	}

}
