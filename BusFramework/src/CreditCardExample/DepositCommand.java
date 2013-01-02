package CreditCardExample;

import BusinessFramework.DbFacade;
import BusinessFramework.JDialog_Deposit;
import CardGUI.CardFrm;

public class DepositCommand extends Cmd {

	public DepositCommand(CardFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		// get selected name
		int selection = this.bf.JTable1.getSelectionModel()
				.getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) this.bf.model.getValueAt(selection, 1);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();
			while (!dep.pull) {

			}
			if (!dep.cancelpull) {
				// compute new amount
				long deposit = Long.parseLong(dep.JTextField_Deposit.getText());
				String samount = (String) this.bf.model
						.getValueAt(selection, 4);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount + deposit;
				this.bf.model.setValueAt(String.valueOf(newamount), selection,
						4);
				// should be account number here.
				DbFacade.getInstance().getCustomer(accnr).getAccount(accnr)
						.Deposit(deposit);
			}
		}
	}
}
