package com.mckinsey.store;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Unit test for {@link Product}.
 * 
 */
public class ProductTest {

	@Test
	public void shouldBeGroceryProductForProductCategoryGrocery() {
		Product product = new Product(10, ProductCategory.GROCERY);
		assertThat(product.isGrocery(), is(true));
	}

	@Test
	public void shouldNotBeGroceryProductForProductCategoryElectronic() {
		Product product = new Product(10, ProductCategory.ELECTRONIC);
		assertThat(product.isGrocery(), is(false));
	}
}
