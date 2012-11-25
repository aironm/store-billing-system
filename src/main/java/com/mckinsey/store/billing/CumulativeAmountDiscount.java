package com.mckinsey.store.billing;

public class CumulativeAmountDiscount implements Discount {

	private static final int DISCOUNT_PER_HUNDRED = 5;

	public boolean isApplicableOn(Bill bill) {
		return true;
	}

	public double getAmount(Bill bill) {
		return Math.floor(bill.getTotalAmount() / 100) * DISCOUNT_PER_HUNDRED;
	}

}
