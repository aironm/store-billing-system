package com.mckinsey.store;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Unit test for {@link Item}.
 * 
 */
public class ItemTest {

	@Test
	public void shouldReturnTotalPrice() {
		Item item = new Item(new Product(10, ProductCategory.ELECTRONIC), 3);
		assertThat(item.getTotalPrice(), is(30d));
	}
	
	@Test
	public void shouldReturnTotalPriceForGroceryProduct() {
		Item item = new Item(new Product(30, ProductCategory.GROCERY),5);
		assertThat(item.getTotalPrice(), is(150d));
	}
}
