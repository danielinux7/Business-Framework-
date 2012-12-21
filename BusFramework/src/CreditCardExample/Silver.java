package CreditCardExample;

import BusinessFramework.Account;

public class Silver extends Account {
	private String date;
	public final static double MI = 0.18;
	public final static double MP = 0.14;
	public Silver(String type) {
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
