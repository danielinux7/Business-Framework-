package BusinessFramework;

import java.util.List;

public interface IDbFacade {
	public void addCustomer(String accnr, ICustomer cust);

	public ICustomer getCustomer(String accnr);

	public List<ICustomer> getCustomerList();
}
