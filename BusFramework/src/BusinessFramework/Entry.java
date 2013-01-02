package BusinessFramework;

import java.util.Date;

public class Entry implements IEntry {
	private int id;
	private double amount;
	private Date date;

	@Override
	public void setAmount(double a) {
		this.amount = a;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setDate(Date d) {
		this.date = d;
	}

	@Override
	public Date getDate() {
		return date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
