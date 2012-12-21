package BankingExample;

import BankGUI.BankFrm;
import BankGUI.JDialog_Addper;
import BusinessFramework.DBsim;

public class PersonalCommand extends Cmd {

	public PersonalCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */
		Personal cust = new Personal();
		JDialog_Addper pac = new JDialog_Addper();
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		while (!pac.pull) {

		}
		if (!pac.cancelpull) {
			// add row to table
			this.bf.rowdata[0] = pac.accountnr;
			this.bf.rowdata[1] = pac.clientName;
			this.bf.rowdata[2] = pac.city;
			this.bf.rowdata[3] = "P";
			this.bf.rowdata[4] = pac.accountType;
			this.bf.rowdata[5] = "0";
			this.bf.model.addRow(this.bf.rowdata);
			this.bf.JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			cust.setCity(pac.city);
			cust.setDOB(pac.birthdate);
			cust.setEmail(pac.email);
			cust.setName(pac.clientName);
			cust.setState(pac.state);
			cust.setStreet(pac.street);
			cust.setZip(pac.zip);
			if (pac.accountType.equalsIgnoreCase("S")) {
				Saving save = new Saving("Saving");
				save.setAccnr(pac.accountnr);
				cust.addAccount(save);
			} else {
				Checking check = new Checking("Checking");
				check.setAccnr(pac.accountnr);
				cust.addAccount(check);
			}
			DBsim.getInstance().addCustomer(pac.accountnr, cust);
		}
	}
}
