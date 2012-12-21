package BankingExample;

import BusinessFramework.Account;

public class Checking extends Account {
	public final static double MI = 0.10;
	public Checking(String type) {
		super();
		super.setType(type);
	}
}
