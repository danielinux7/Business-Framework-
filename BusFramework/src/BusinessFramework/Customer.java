package BusinessFramework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer implements ICustomer {
	protected int id;
	private String name;
	private String city;
	private String state;
	private String street;
	private String email;
	private String zip;
	private List<IAccount> accountlist;

	public Customer() {
		accountlist = new LinkedList();
	}

	@Override
	public void addAccount(IAccount account) {
		this.accountlist.add(account);
		
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setCity(String city) {
		this.city = city;

	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public void setState(String state) {
		this.state = state;

	}

	@Override
	public void setZip(String zip) {
		this.zip = zip;

	}

	@Override
	public void setEmail(String email) {
		this.email = email;

	}

	@Override
	public List<IAccount> getAccountList() {
		
		return this.accountlist;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getCity() {
		return this.city;
	}

	@Override
	public String getStreet() {
		return this.street;
	}

	@Override
	public String getState() {
		return this.state;
	}

	@Override
	public String getZip() {
		return this.zip;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public IAccount getAccount(String accnr) {
		for(IAccount acc:this.accountlist){
			if((""+acc.getAccnr()).equalsIgnoreCase(accnr))
				return acc;
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<IAccount> getAccountlist() {
		return accountlist;
	}

	public void setAccountlist(List<IAccount> accountlist) {
		this.accountlist = accountlist;
	}

}
