package CreditCardExample;

import BusinessFramework.Customer;
import BusinessFramework.DbFacade;
import BusinessFramework.ICustomer;
import CardGUI.CardFrm;
import CardGUI.JDialog_Addcc;

public class NewAccCommand extends Cmd {

	public NewAccCommand(CardFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */
		ICustomer cust = new Customer();
		JDialog_Addcc ccac = new JDialog_Addcc();
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		while (!ccac.pull) {

		}
		if (!ccac.cancelpull) {
			// add row to table
			this.bf.rowdata[0] = ccac.clientName;
			this.bf.rowdata[1] = ccac.ccnumber;
			this.bf.rowdata[2] = ccac.expdate;
			this.bf.rowdata[3] = ccac.accountType;
			this.bf.rowdata[4] = "0";
			this.bf.model.addRow(this.bf.rowdata);
			this.bf.JTable1.getSelectionModel().setAnchorSelectionIndex(-1);

			cust.setCity(ccac.city);
			cust.setEmail(ccac.email);
			cust.setName(ccac.clientName);
			cust.setState(ccac.state);
			cust.setStreet(ccac.street);
			cust.setZip(ccac.zip);
			if (ccac.accountType != null
					&& ccac.accountType.equalsIgnoreCase("silver")) {
				Silver silver = new Silver("silver");
				silver.setAccnr(Integer.parseInt(ccac.ccnumber));
				silver.setDate(ccac.expdate);
				cust.addAccount(silver);
			} else if (ccac.accountType != null
					&& ccac.accountType.equalsIgnoreCase("gold")) {
				Gold gold = new Gold("gold");
				gold.setAccnr(Integer.parseInt(ccac.ccnumber));
				gold.setDate(ccac.expdate);
				cust.addAccount(gold);
			} else {
				Bronze bronze = new Bronze("bronze");
				bronze.setAccnr(Integer.parseInt(ccac.ccnumber));
				bronze.setDate(ccac.expdate);
				cust.addAccount(bronze);
			}
			DbFacade.getInstance().addCustomer(ccac.ccnumber, cust);
		}
	}
}
