package BankingExample;

import BankGUI.BankFrm;
import BusinessFramework.DBsim;
import BusinessFramework.JDialog_Deposit;

public class DepositCommand extends Cmd {

	public DepositCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		// get selected name
		int selection = this.bf.JTable1.getSelectionModel()
				.getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) this.bf.model.getValueAt(selection, 0);

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
						.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount + deposit;
				this.bf.model.setValueAt(String.valueOf(newamount), selection,
						5);
				DBsim.getInstance().getCustomer(accnr).getAccount(accnr)
						.Deposit(deposit);
			}
			// IEntry e = new Entry();
			// e.setAmount(deposit);
			// e.setDate(new Date());
			// e.setBalance(newamount);
		}
	}
}
