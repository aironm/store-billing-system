package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link BillCalculatorImpl}.
 * 
 */
public class BillCalculatorImplTest {

	private BillCalculatorImpl billCalculator;

	private static final class MockDiscount implements Discount {

		private boolean applicable;
		private double discountAmount;

		public MockDiscount(boolean applicable, double discountAmount) {
			this.applicable = applicable;
			this.discountAmount = discountAmount;
		}

		@Override
		public boolean isApplicableOn(Bill bill) {
			return applicable;
		}

		@Override
		public double getAmount(Bill bill) {
			return discountAmount;
		}
	}

	@Before
	public void setUp() {
		billCalculator = new BillCalculatorImpl();

		List<Discount> percentageDiscounts = new ArrayList<Discount>();
		percentageDiscounts.add(new MockDiscount(true, 10));
		percentageDiscounts.add(new MockDiscount(false, 8));
		percentageDiscounts.add(new MockDiscount(true, 5));

		billCalculator.setPercentageDiscounts(percentageDiscounts);
		billCalculator.setAmountDiscount(new MockDiscount(true, 4));
	}

	@Test
	public void shouldReturnNetAmountForSingleItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.singleItem());
		assertThat(payableAmount, is(16d));
	}

	@Test
	public void shouldReturnNetAmountForMultiItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.multipleItems());
		assertThat(payableAmount, is(246d));
	}

	@Test
	public void shouldReturnNetAmountForMultiItemBillWithLastPercenatgeDiscount() {
		List<Discount> percentageDiscounts = new ArrayList<Discount>();
		percentageDiscounts.add(new MockDiscount(false, 10));
		percentageDiscounts.add(new MockDiscount(false, 8));
		percentageDiscounts.add(new MockDiscount(true, 5));

		billCalculator.setPercentageDiscounts(percentageDiscounts);
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.multipleItems());
		assertThat(payableAmount, is(251d));
	}
}
