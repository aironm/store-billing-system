package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.mckinsey.store.CustomerObjectMother;

/**
 * Unit test for {@link LoyaltyDiscount}.
 * 
 */
public class LoyalCustomerDiscountTest {

	private LoyaltyDiscount discount;

	@Before
	public void setUp() {
		discount = new LoyaltyDiscount();
	}

	@Test
	public void shouldBeApplicableWhenCustomerIsEmployee() {
		boolean applicable = discount.isApplicableOn(BillObjectMother.item(CustomerObjectMother.loyal()));
		assertThat(applicable, is(true));
	}

	@Test
	public void shouldNotBeApplicableCustomerIsNotEmployee() {
		boolean applicable = discount.isApplicableOn(BillObjectMother.item(CustomerObjectMother.notLoyal()));
		assertThat(applicable, is(false));
	}
}
