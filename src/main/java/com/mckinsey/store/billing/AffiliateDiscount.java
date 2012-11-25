package com.mckinsey.store.billing;

public class AffiliateDiscount extends PercentageDiscount {

	public boolean isApplicableOn(Bill bill) {
		return bill.getCustomer().isAffiliated();
	}

	@Override
	protected float getDiscountRate() {
		return 10;
	}

}
