package com.mckinsey.store.billing;

/**
 * Defines the interface for bill calculation. An alternate was to model this as
 * responsibility of {@link Bill} which give the net payable amount. But since
 * the problem statement specifically mentioned that bill is given, hence
 * modeled as separate service.
 * 
 */
public interface BillCalculator {

	abstract double calculatePayableAmount(Bill bill);

}