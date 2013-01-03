package BusinessFramework;

import java.util.List;

public interface ICustomer {
	public void addAccount(IAccount account);

	public void setName(String name);

	public void setCity(String city);

	public void setStreet(String street);

	public void setState(String state);

	public void setZip(String zip);

	public void setEmail(String email);

	public List<IAccount> getAccountList();

	public IAccount getAccount(String accnr);

	public String getName();

	public String getCity();

	public String getStreet();

	public String getState();

	public String getZip();

	public String getEmail();
	public void setId(int id);
	public int getId();
}
