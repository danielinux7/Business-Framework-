package BusinessFramework;

import java.util.List;

public interface IAccount {
	public void addEntry(IEntry e);

	public List<IEntry> getEntryList();

	public void setBalance(double balance);

	public double getBalance();

	public void Deposit(double amount);

	public boolean Withdraw(double amount);

	public void setAccnr(String Accnr);

	public String getAccnr();

	public String getType();

	public void setType(String type);
}
