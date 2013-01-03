package BusinessFramework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import Hibernate.MainSession;

public class DbFacade implements IDbFacade {
	private static IDbFacade db = new DbFacade();
	private Map<String, ICustomer> customermap = new HashMap();

	private DbFacade() {
	}

	public static IDbFacade getInstance() {
		return db;
	}

	@Override
	public ICustomer getCustomer(String accnr) {
		Session session = MainSession.getFactory().openSession();
		session.beginTransaction();
		ICustomer cust = (Customer)session.createSQLQuery("select * From Customer where ACC_NR = "+accnr);
		session.getTransaction().commit();
		session.close();
		return cust;
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
		Session session = MainSession.getFactory().openSession();
		session.beginTransaction();
		cust.setId(5);
		session.save(cust);
		session.save(cust.getAccount(accnr));
		//session.createQuery( "update Account set CUST_ID ="+cust.getId()+" where ACC_NR = "+Integer.parseInt(accnr));
		session.getTransaction().commit();
		session.close();
	}

}
