package BankingExample;

import javax.swing.JOptionPane;

import BankGUI.BankFrm;
import BusinessFramework.DBsim;
import BusinessFramework.JDialog_Withdraw;

public class WithdrawCommand extends Cmd {

	public WithdrawCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {
		// get selected name
		int selection = this.bf.JTable1.getSelectionModel()
				.getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) this.bf.model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();
			while (!wd.pull) {

			}
			if (!wd.cancelpull) {
				// compute new amount
				long deposit = Long.parseLong(wd.JTextField_AMT.getText());
				String samount = (String) this.bf.model
						.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount - deposit;
				this.bf.model.setValueAt(String.valueOf(newamount), selection,
						5);
				if (newamount < 0) {
					JOptionPane.showMessageDialog(this.bf.JButton_Withdraw,
							" Account " + accnr + " : balance is negative: $"
									+ String.valueOf(newamount) + " !",
							"Warning: negative balance",
							JOptionPane.WARNING_MESSAGE);
				}
				DBsim.getInstance().getCustomer(accnr).getAccount(accnr)
						.Withdraw(deposit);
			}
		}
	}
}
