package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mckinsey.store.CustomerObjectMother;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main-context.xml")
public class BillCalculatorIntegrationTest {

	@Autowired
	private BillCalculator billCalculator;

	@Test
	public void shouldReturnNetPayableAmountForSingleItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother.singleItem());
		assertThat(payableAmount, is(28.5d));
	}

	@Test
	public void shouldReturnNetPayableAmountForMultiItemBill() {
		double payableAmount = billCalculator.calculatePayableAmount(BillObjectMother
				.multipleItems(CustomerObjectMother.employee()));
		assertThat(payableAmount, is(217d));
	}
}
