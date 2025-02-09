package WarehouseInventoryManagementSystem;

// Represents a storage location in the warehouse
public class Location {
	private final int aisle, shelf, bin;

	// Constructor to initialize location details
	public Location(int aisle, int shelf, int bin) {
		this.aisle = aisle;
		this.shelf = shelf;
		this.bin = bin;
	}

	// Returns a formatted location string
	@Override
	public String toString() {
		return "Aisle " + aisle + ", Shelf " + shelf + ", Bin " + bin;
	}
}