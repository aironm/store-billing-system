package com.mckinsey.store.billing;

import java.util.List;

/**
 * Implements {@link BillCalculator}. The percentage discounts should be in
 * order of decreasing order of discount rate so that customer can get maximum
 * benefit. Whichever one is applicable first is applied rest are ignored.
 * 
 */
public class BillCalculatorImpl implements BillCalculator {

	private List<Discount> percentageDiscounts;
	private Discount amountDiscount;

	@Override
	public double calculatePayableAmount(Bill bill) {
		double totalDiscount = 0;
		for (Discount discount : percentageDiscounts) {
			if (discount.isApplicableOn(bill)) {
				totalDiscount += discount.getAmount(bill);
				break;
			}
		}
		totalDiscount += amountDiscount.getAmount(bill);

		return bill.getTotalAmount() - totalDiscount;
	}

	public void setPercentageDiscounts(List<Discount> percentageDiscounts) {
		this.percentageDiscounts = percentageDiscounts;
	}

	public void setAmountDiscount(Discount amountDiscount) {
		this.amountDiscount = amountDiscount;
	}
}
