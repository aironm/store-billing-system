package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class PercentageDiscountTest {

	private PercentageDiscount discount;

	@Before
	public void setUp() {
		discount = new PercentageDiscount() {

			@Override
			public boolean isApplicableOn(Bill bill) {
				return true;
			}

			@Override
			protected float getDiscountRate() {
				return 10;
			}
		};
	}

	@Test
	public void shouldReturnDiscountForSingleItemBill() {
		double discountAmount = discount.getAmount(BillObjectMother.singleItem());
		assertThat(discountAmount, is(3d));
	}

	@Test
	public void shouldReturnDiscountForMultipleItemBillHavingGroceryItem() {
		double discountAmount = discount.getAmount(BillObjectMother.multipleItems());
		assertThat(discountAmount, is(11d));
	}
}