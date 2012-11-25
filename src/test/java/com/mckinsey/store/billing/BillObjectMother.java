package com.mckinsey.store.billing;

import com.mckinsey.store.Customer;
import com.mckinsey.store.CustomerObjectMother;
import com.mckinsey.store.Item;
import com.mckinsey.store.Product;
import com.mckinsey.store.ProductCategory;

public class BillObjectMother {

	public static Bill item(Customer customer) {
		return new Bill(customer);
	}

	public static Bill singleItem() {
		Bill bill = new Bill(CustomerObjectMother.normal());
		bill.addItem(new Item(new Product(10, ProductCategory.ELECTRONIC), 3));
		return bill;
	}

	public static Bill multipleItems() {
		return multipleItems(CustomerObjectMother.normal());
	}

	public static Bill multipleItems(Customer customer) {
		Bill bill = new Bill(customer);
		bill.addItem(new Item(new Product(10, ProductCategory.ELECTRONIC), 3));
		bill.addItem(new Item(new Product(20, ProductCategory.ELECTRONIC), 4));
		bill.addItem(new Item(new Product(30, ProductCategory.GROCERY), 5));
		return bill;
	}
}
