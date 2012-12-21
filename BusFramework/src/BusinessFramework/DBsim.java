package BusinessFramework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBsim implements IDBsim {
	private static IDBsim db = new DBsim();
	private Map<String, ICustomer> customermap = new HashMap();

	private DBsim() {
	}

	public static IDBsim getInstance() {
		return db;
	}

	@Override
	public ICustomer getCustomer(String accnr) {
		return customermap.get(accnr);
	}

	@Override
	public List<ICustomer> getCustomerList() {
		Set<String> keys = this.customermap.keySet();
		List<ICustomer> list = new LinkedList();
		for (String key : keys) {
			list.add(this.customermap.get(key));
		}
		return list;
	}

	@Override
	public void addCustomer(String accnr, ICustomer cust) {
		this.customermap.put(accnr, cust);
	}

}
