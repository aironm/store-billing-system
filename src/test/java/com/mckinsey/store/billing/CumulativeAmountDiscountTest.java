package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class CumulativeAmountDiscountTest {

	private CumulativeAmountDiscount discount;

	@Before
	public void setUp() {
		discount = new CumulativeAmountDiscount();
	}

	@Test
	public void shouldReturnDiscountForSingleItemBill() {
		double amount = discount.getAmount(BillObjectMother.singleItem());
		assertThat(amount, is(0d));
	}

	@Test
	public void shouldReturnDiscountForMultipleItemBill() {
		double amount = discount.getAmount(BillObjectMother.multipleItems());
		assertThat(amount, is(10d));
	}
}
