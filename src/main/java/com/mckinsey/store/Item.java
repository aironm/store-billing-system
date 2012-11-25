package com.mckinsey.store;

/**
 * Represents a instance of a product to be purchased or already purchased.
 * 
 */
public class Item {
	private final Product product;
	private int quantity;

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return quantity * product.getPrice();
	}

	public Product getProduct() {
		return product;
	}
}
