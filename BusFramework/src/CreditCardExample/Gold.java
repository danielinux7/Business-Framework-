package CreditCardExample;

import BusinessFramework.Account;

public class Gold extends Account {
	private String date;
	public final static double MI = 0.14;
	public final static double MP = 0.12;
	public Gold(String type) {
		super();
		super.setType(type);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
