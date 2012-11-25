package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BillCalculatorImplTest {

	private BillCalculatorImpl billCalculator;

	private final class MockPercentageDiscount extends PercentageDiscount {

		private boolean applicable;
		private float discountRate;

		public MockPercentageDiscount(boolean applicable, float discountRate) {
			this.applicable = applicable;
			this.discountRate = discountRate;
		}

		@Override
		public boolean isApplicableOn(Bill bill) {
			return applicable;
		}

		@Override
		protected float getDiscountRate() {
			return discountRate;
		}
	}

	@Before
	public void setUp() {
		billCalculator = new BillCalculatorImpl();

		List<Discount> percentageDiscounts = new ArrayList<Discount>();
		percentageDiscounts.add(new MockPercentageDiscount(true, 10));
		percentageDiscounts.add(new MockPercentageDiscount(false, 8));
		percentageDiscounts.add(new MockPercentageDiscount(true, 5));

		billCalculator.setPercentageDiscounts(percentageDiscounts);
		billCalculator.setAmountDiscount(new CumulativeAmountDiscount());
	}

	@Test
	public void shouldReturnNetAmountForSingleItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.singleItem());
		assertThat(payableAmount, is(27d));
	}

	@Test
	public void shouldReturnNetAmountForMultiItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.multipleItems());
		assertThat(payableAmount, is(239d));
	}

	@Test
	public void shouldReturnNetAmountForMultiItemBillWithLastPercenatgeDiscount() {
		List<Discount> percentageDiscounts = new ArrayList<Discount>();
		percentageDiscounts.add(new MockPercentageDiscount(false, 10));
		percentageDiscounts.add(new MockPercentageDiscount(false, 8));
		percentageDiscounts.add(new MockPercentageDiscount(true, 5));

		billCalculator.setPercentageDiscounts(percentageDiscounts);
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.multipleItems());
		assertThat(payableAmount, is(244.5d));
	}
}
