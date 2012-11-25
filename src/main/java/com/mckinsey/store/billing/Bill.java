package com.mckinsey.store.billing;

import java.util.ArrayList;
import java.util.List;

import com.mckinsey.store.Customer;
import com.mckinsey.store.Item;

/**
 * Represents a bill in the billing system.
 * 
 */
public class Bill {
	private final Customer customer;
	private List<Item> items = new ArrayList<Item>();

	public Bill(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public double getTotalAmount() {
		double total = 0;
		for (Item item : items) {
			total += item.getTotalPrice();
		}
		return total;
	}
}
