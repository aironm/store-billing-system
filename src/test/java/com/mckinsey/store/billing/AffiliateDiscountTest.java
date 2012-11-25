package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.mckinsey.store.CustomerObjectMother;

/**
 * Unit test for {@link AffiliateDiscount}.
 * 
 */
public class AffiliateDiscountTest {

	private AffiliateDiscount discount;

	@Before
	public void setUp() {
		discount = new AffiliateDiscount();
	}

	@Test
	public void shouldBeApplicableWhenCustomerIsEmployee() {
		boolean applicable = discount.isApplicableOn(BillObjectMother.item(CustomerObjectMother.affiliate()));
		assertThat(applicable, is(true));
	}

	@Test
	public void shouldNotBeApplicableCustomerIsNotEmployee() {
		boolean applicable = discount.isApplicableOn(BillObjectMother.item(CustomerObjectMother.normal()));
		assertThat(applicable, is(false));
	}
}
