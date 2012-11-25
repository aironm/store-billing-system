package com.mckinsey.store.billing;

import com.mckinsey.store.Item;

public abstract class PercentageDiscount implements Discount {

	public double getAmount(Bill bill) {
		double totalDiscount = 0;
		for (Item item : bill.getItems()) {
			if (isDiscountedItem(item)) {
				totalDiscount += item.getTotalPrice() * getDiscountRate() / 100;
			}
		}
		return totalDiscount;
	}

	private boolean isDiscountedItem(Item item) {
		return !item.getProduct().isGrocery();
	}

	/**
	 * Provides the flexibility to retrieve the rate from anywhere. The concrete
	 * classes can pull it from database or can be provided while creating
	 * (spring Spring dependency injection). Since the discount rates can
	 * change, it is better to put them in database.
	 */
	protected abstract float getDiscountRate();
}
