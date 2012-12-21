package BusinessFramework;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Account implements IAccount {
	private double balance;
	private String Accnr;
	private String type;
	private List<IEntry> entrylist;

	public Account() {
		entrylist = new LinkedList<IEntry>();
		balance = 0;
	}

	@Override
	public void addEntry(IEntry e) {
		this.entrylist.add(e);

	}

	@Override
	public List<IEntry> getEntryList() {
		return this.entrylist;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void Deposit(double amount) {
		this.balance += amount;
		IEntry e = new Entry();
		e.setAmount(this.balance);
		e.setDate(new Date());
		this.entrylist.add(e);
	}

	@Override
	public boolean Withdraw(double amount) {
		if (this.balance > 0) {
			this.balance -= amount;
			IEntry e = new Entry();
			e.setAmount(this.balance);
			e.setDate(new Date());
			this.entrylist.add(e);
			return true;
		} else
			return false;
	}

	@Override
	public void setAccnr(String Accnr) {
		this.Accnr = Accnr;

	}

	@Override
	public String getAccnr() {
		return this.Accnr;
	}

	@Override
	public String getType() {

		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;

	}

}
