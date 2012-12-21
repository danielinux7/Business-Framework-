package BusinessFramework;

import java.util.List;

public interface IDBsim {
	public void addCustomer(String accnr, ICustomer cust);

	public ICustomer getCustomer(String accnr);

	public List<ICustomer> getCustomerList();
}
