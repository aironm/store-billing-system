package com.mckinsey.store;

/**
 * Represents a product in the retail store. For simplicity, just defining bare
 * minimum fields.
 * 
 */
public class Product {

	private double price;
	private ProductCategory productCategory;

	public Product(double price, ProductCategory productCategory) {
		this.price = price;
		this.productCategory = productCategory;
	}

	public boolean isGrocery() {
		return productCategory == ProductCategory.GROCERY;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
}
