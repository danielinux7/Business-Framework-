package CreditCardExample;

import java.util.List;

import BankingExample.Company;
import BankingExample.Personal;
import BusinessFramework.DbFacade;
import BusinessFramework.IAccount;
import BusinessFramework.ICustomer;
import BusinessFramework.IEntry;
import BusinessFramework.JDialogGenBill;
import CardGUI.CardFrm;

public class GenBillCommand extends Cmd {

	public GenBillCommand(CardFrm bf) {
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

				if (acc.getClass().equals(new Bronze("bronze").getClass())) {
					billstring += "Exp Date= " + ((Bronze) acc).getDate()
							+ "\r\n";

				} else if (acc.getClass().equals(new Gold("gold").getClass())) {
					billstring += "Exp Date= " + ((Gold) acc).getDate()
							+ "\r\n";
				} else if (acc.getClass().equals(
						new Silver("silver").getClass())) {
					billstring += "Exp Date= " + ((Silver) acc).getDate()
							+ "\r\n";
				}

			}
			billstring += "Email= " + cust.getEmail() + "\r\n";
			billstring += "\r\n";
			billstring += "\r\n";
		}// System.out.println(billstring);
			// //////////////////////////////////////////////////////
		JDialogGenBill billFrm = new JDialogGenBill(billstring);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	}
}
