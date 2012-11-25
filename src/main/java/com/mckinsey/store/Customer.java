package com.mckinsey.store;

import java.util.Calendar;
import java.util.Date;

/**
 * Represents a customer. Leaving details not relevant to the exercise.
 * 
 */
public class Customer {
	private static final int REGISTERED_NO_OF_YEARS_FOR_LOYAL_CUSTOMER = 2;
	private CustomerType type;
	private Date registrationDate;

	public Customer(CustomerType type, Date registrationDate) {
		this.type = type;
		this.registrationDate = registrationDate;
	}

	// Utility Methods

	public boolean isEmployee() {
		return type == CustomerType.EMPLOYEE;
	}

	public boolean isAffiliated() {
		return type == CustomerType.AFFILIATED;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public boolean isLoyal() {
		Calendar date = Calendar.getInstance();
		date.setTime(registrationDate);
		date.add(Calendar.YEAR, REGISTERED_NO_OF_YEARS_FOR_LOYAL_CUSTOMER);
		return date.before(Calendar.getInstance());
	}
}
