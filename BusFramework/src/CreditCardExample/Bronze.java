package CreditCardExample;

import BusinessFramework.Account;

public class Bronze extends Account {
	private String date;
	public final static double MI = 0.2;
	public final static double MP = 0.22;
	public Bronze(String type) {
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
