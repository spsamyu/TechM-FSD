package WarehouseInventoryManagementSystem;

import java.util.List;

// Represents an order with priority
class Order implements Comparable<Order> {
	private final String orderID;
	private final List<String> productIDs;
	private final Priority priority;

	// Enum for order priority levels
	public enum Priority { STANDARD, EXPEDITED }

	// Constructor to initialize order details
	public Order(String orderID, List<String> productIDs, Priority priority) {
		this.orderID = orderID;
		this.productIDs = productIDs;
		this.priority = priority;
	}

	public List<String> getProductIDs() { return productIDs; }
	public Priority getPriority() { return priority; }
	public String getOrderID() { return orderID; }

	// Compare orders based on priority
	@Override
	public int compareTo(Order order) {
		return this.priority.compareTo(order.priority);
	}
}