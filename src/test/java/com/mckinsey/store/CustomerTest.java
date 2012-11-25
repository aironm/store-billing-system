package com.mckinsey.store;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Unit test for {@link Customer}.
 * 
 */
public class CustomerTest {

	@Test
	public void shouldBeEmployeeForCustomerTypeEmployee() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, new Date());

		assertThat(customer.isEmployee(), is(true));
		assertThat(customer.isAffiliated(), is(false));
	}

	@Test
	public void shouldBeAffiliatedForCustomerTypeAffiliated() {
		Customer customer = new Customer(CustomerType.AFFILIATED, new Date());

		assertThat(customer.isAffiliated(), is(true));
		assertThat(customer.isEmployee(), is(false));
	}

	@Test
	public void shouldBeNormalForCustomerTypeNormal() {
		Customer customer = new Customer(CustomerType.NORMAL, new Date());

		assertThat(customer.getType(), is(CustomerType.NORMAL));
		assertThat(customer.isAffiliated(), is(false));
		assertThat(customer.isEmployee(), is(false));
	}

	@Test
	public void shouldBeLoyalCustomer() {
		Calendar registrationDate = Calendar.getInstance();
		registrationDate.set(2010, 10, 10);
		Customer customer = new Customer(CustomerType.NORMAL, registrationDate.getTime());

		assertThat(customer.isLoyal(), is(true));
	}

	@Test
	public void shouldBeLoyalCustomerForBoundaryRegistrationDate() {
		Calendar registrationDate = Calendar.getInstance();
		registrationDate.setTime(new Date());
		registrationDate.add(Calendar.YEAR, -2);
		registrationDate.add(Calendar.SECOND, -1);
		Customer customer = new Customer(CustomerType.NORMAL, registrationDate.getTime());

		assertThat(customer.isLoyal(), is(true));
	}

	@Test
	public void shouldNotBeLoyalCustomerForRegistrationExactlyTwoYearsBack() {
		Calendar registrationDate = Calendar.getInstance();
		registrationDate.setTime(new Date());
		registrationDate.add(Calendar.YEAR, -2);
		Customer customer = new Customer(CustomerType.NORMAL, registrationDate.getTime());

		assertThat(customer.isLoyal(), is(false));
	}

	@Test
	public void shouldNotBeLoyalCustomerForBoundaryRegistrationDate() {
		Calendar registrationDate = Calendar.getInstance();
		registrationDate.setTime(new Date());
		registrationDate.add(Calendar.YEAR, -2);
		registrationDate.add(Calendar.SECOND, 5);
		Customer customer = new Customer(CustomerType.NORMAL, registrationDate.getTime());

		assertThat(customer.isLoyal(), is(false));
	}
}
