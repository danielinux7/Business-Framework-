package BankingExample;

import BankGUI.BankFrm;
import BankGUI.JDialog_Addcom;
import BusinessFramework.DbFacade;

public class CompanyCommand extends Cmd {

	public CompanyCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */
		Company cust = new Company();
		JDialog_Addcom pac = new JDialog_Addcom();
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		while (!pac.pull) {

		}
		if (!pac.cancelpull) {
			// add row to table
			this.bf.rowdata[0] = pac.accountnr;
			this.bf.rowdata[1] = pac.clientName;
			this.bf.rowdata[2] = pac.city;
			this.bf.rowdata[3] = "C";
			this.bf.rowdata[4] = pac.accountType;
			this.bf.rowdata[5] = "0";
			this.bf.model.addRow(this.bf.rowdata);
			this.bf.JTable1.getSelectionModel().setAnchorSelectionIndex(-1);

			cust.setCity(pac.city);
			cust.setNumOfEmp(pac.empnr);
			cust.setEmail(pac.email);
			cust.setName(pac.clientName);
			cust.setState(pac.state);
			cust.setStreet(pac.street);
			cust.setZip(pac.zip);
			if (pac.accountType != null
					&& pac.accountType.equalsIgnoreCase("S")) {
				Saving save = new Saving("Saving");
				save.setAccnr(Integer.parseInt(pac.accountnr));
				cust.addAccount(save);
			} else {
				Checking check = new Checking("Checking");
				check.setAccnr(Integer.parseInt(pac.accountnr));
				cust.addAccount(check);
			}
			DbFacade.getInstance().addCustomer(pac.accountnr, cust);
		}
	}
}
