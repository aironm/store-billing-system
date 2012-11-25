package com.mckinsey.store.billing;

/**
 * Represents a discount strategy.
 * 
 */
public interface Discount {
	boolean isApplicableOn(Bill bill);

	double getAmount(Bill bill);
}
