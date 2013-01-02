package BankingExample;

import java.util.List;

import BankGUI.BankFrm;
import BusinessFramework.DbFacade;
import BusinessFramework.IAccount;
import BusinessFramework.ICustomer;
import BusinessFramework.IEntry;
import BusinessFramework.JDialogGenBill;

public class GenBillCommand extends Cmd {

	public GenBillCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		String billstring = "";
		List<ICustomer> custlist = DbFacade.getInstance().getCustomerList();
		for (ICustomer cust : custlist) {
			// generate the string for the monthly bill
			billstring += "Name= " + cust.getName() + "\r\n";
			billstring += "Address=" + cust.getStreet() + ", " + cust.getCity()
					+ ", " + cust.getState() + ", " + cust.getZip() + "\r\n";
			for (IAccount acc : cust.getAccountList()) {
				billstring += "Account number= " + acc.getAccnr() + "\r\n";
				billstring += "Account type= " + acc.getType() + "\r\n";
				for (IEntry e : acc.getEntryList()) {
					// billstring +=
					// "Date = "+e.getDate().getMonth()+" / "+e.getDate().getDay()+" / "+(e.getDate().getYear()+1900)+"  balance = $ "+e.getAmount()+"\r\n";
					billstring += e.getDate() + ", balance = $" + e.getAmount()
							+ "\r\n";

				}
				if (cust.getClass().equals(new Personal().getClass())) {
					billstring += "BirthDate= " + ((Personal) cust).getDOB()
							+ "\r\n";
					billstring += "Email= " + ((Personal) cust).getEmail()
							+ "\r\n";
				} else if (cust.getClass().equals(new Company().getClass())) {
					billstring += "Nr of Emp= "
							+ ((Company) cust).getNumOfEmp() + "\r\n";
					billstring += "Email= " + ((Company) cust).getEmail()
							+ "\r\n";
				}

				billstring += "\r\n";
				billstring += "\r\n";

			}

		}// System.out.println(billstring);
			// //////////////////////////////////////////////////////
		JDialogGenBill billFrm = new JDialogGenBill(billstring);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}
}
