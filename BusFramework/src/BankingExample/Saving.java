package BankingExample;

import BusinessFramework.Account;

public class Saving extends Account {
	public final static double MI = 0.05;
	public Saving(String type) {
		super();
		super.setType(type);
	}
}
