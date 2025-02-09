package WarehouseInventoryManagementSystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WarehouseSystem {
	public static void main(String[] args) {
		// Create an instance of InventoryManager
		InventoryManager manager = new InventoryManager();

		// Add products to the inventory
		manager.addProduct(new Product("P1", "Mobile Phone", 10, new Location(1, 2, 3)));
		manager.addProduct(new Product("P2", "Dell Laptop", 5, new Location(4, 5, 6)));

		// Create product lists for orders
		List<String> products1 = Arrays.asList("P1", "P2");
		List<String> products2 = Collections.singletonList("P1");

		// Place orders with different priority levels
		manager.placeOrder(new Order("O1", products1, Order.Priority.EXPEDITED));
		manager.placeOrder(new Order("O2", products2, Order.Priority.STANDARD));

		// Process the placed orders
		manager.processOrders();
	}
}