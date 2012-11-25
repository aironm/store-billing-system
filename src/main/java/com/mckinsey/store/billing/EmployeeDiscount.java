package com.mckinsey.store.billing;

public class EmployeeDiscount extends PercentageDiscount {

	public boolean isApplicableOn(Bill bill) {
		return bill.getCustomer().isEmployee();
	}

	@Override
	protected float getDiscountRate() {
		return 30;
	}

}
