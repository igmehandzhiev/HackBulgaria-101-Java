package shopInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Inventory {

	private Map<Integer, Product> products;

	public Inventory(List<Product> prods) {
		this.products = new HashMap<>();
		for (Product product : prods) {
			products.put(product.getID(), product);
		}
	}

	public double Audit() {
		double earnings = 0;
		for (Product product : products.values()) {
			earnings += product.getPriceAfterTax() * product.getQuantity();
		}
		return earnings;
	}

	public double RequestOrder(Order ord) throws NotAvailableInInventoryException {
		Map<Integer, Integer> order = ord.getOrder();

		double result = 0.0;

		for (Entry<Integer, Integer> product : order.entrySet()) {

			if (!products.containsKey(product.getKey())) {
				throw new NotAvailableInInventoryException("Product not available! Order canceled.");
			} else if (product.getValue() > products.get(product.getKey()).getQuantity()) {
				throw new NotAvailableInInventoryException("Product not available! Order canceled.");
			}

			Product prod = products.get(product.getKey());
			result += prod.getPriceAfterTax() * product.getValue();
		}

		return result;
	}
}
