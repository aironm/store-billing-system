package com.mckinsey.store.billing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.mckinsey.store.CustomerObjectMother;
import com.mckinsey.store.Item;
import com.mckinsey.store.Product;
import com.mckinsey.store.ProductCategory;

/**
 * Unit test for {@link Bill}.
 * 
 */
public class BillTest {

	private Bill bill;

	@Before
	public void setUp() {
		bill = new Bill(CustomerObjectMother.normal());
	}

	@Test
	public void shouldReturnTotalCostForOneItem() {
		bill.addItem(new Item(new Product(10, ProductCategory.ELECTRONIC), 3));

		assertThat(bill.getTotalAmount(), is(30d));
	}

	@Test
	public void shouldReturnTotalCostForMutiplebill() {
		bill.addItem(new Item(new Product(10, ProductCategory.ELECTRONIC), 3));
		bill.addItem(new Item(new Product(30, ProductCategory.GROCERY), 4));

		assertThat(bill.getTotalAmount(), is(150d));
	}

	@Test
	public void shouldReturnTotalWithZeroItem() {
		assertThat(bill.getTotalAmount(), is(0d));
	}
}
