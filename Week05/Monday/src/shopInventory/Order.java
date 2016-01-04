package shopInventory;

import java.util.HashMap;
import java.util.Map;

public class Order {																				
	private final static int DEFAULT_NUM_PRODUCTS = 10;
	private Map<Integer, Integer> order;

	public Order() {
		this(DEFAULT_NUM_PRODUCTS);
	}
	
	public Order(int numProducts) {
		order = new HashMap<>(numProducts);
	}
	
	public void add(Integer id, int quantity) {
		
		if(order.containsKey(id)) {
			int newQuantity = quantity + order.get(id);
			order.put(id, newQuantity);
		} else {
			order.put(id, quantity);
		}
	}
	
	public Map<Integer, Integer > getOrder() {
		return order;
	}
}
