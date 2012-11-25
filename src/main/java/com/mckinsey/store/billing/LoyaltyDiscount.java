package com.mckinsey.store.billing;

public class LoyaltyDiscount extends PercentageDiscount {

	public boolean isApplicableOn(Bill bill) {
		return bill.getCustomer().isLoyal();
	}

	@Override
	protected float getDiscountRate() {
		return 5;
	}

}
