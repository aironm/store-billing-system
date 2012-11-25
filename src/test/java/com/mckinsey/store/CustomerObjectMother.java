package com.mckinsey.store;

import java.util.Calendar;
import java.util.Date;

public class CustomerObjectMother {

	public static Customer normal() {
		return new Customer(CustomerType.NORMAL, getDate(2010, 10, 1));
	}

	public static Customer employee() {
		return new Customer(CustomerType.EMPLOYEE, getDate(2010, 10, 1));
	}

	public static Customer affiliate() {
		return new Customer(CustomerType.AFFILIATED, getDate(2010, 10, 1));
	}

	public static Customer loyal() {
		return new Customer(CustomerType.AFFILIATED, getDate(2010, 10, 1));
	}

	public static Customer notLoyal() {
		return new Customer(CustomerType.AFFILIATED, new Date());
	}

	private static Date getDate(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}
}
