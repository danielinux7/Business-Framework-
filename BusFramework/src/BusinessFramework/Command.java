package BusinessFramework;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Command implements ICommand {
	protected ActionEvent event;
	protected BusFrm bf;
	public Command(BusFrm bf) {
		this.bf = bf;
	}

	@Override
	public void executeLogic() {
		Object object = this.event.getSource();
		String string = "";
		if (object == this.bf.JButton_Exit)
			System.exit(0);
		else if (object == this.bf.JButton_NewAccount)
			new JDialog_AddAcc().setVisible(true);
		else if (object == this.bf.JButton_Deposit)
			new JDialog_Deposit(string).setVisible(true);
		else if (object == this.bf.JButton_Withdraw)
			new JDialog_Withdraw(string).setVisible(true);
		else if (object == this.bf.JButton_GenBill)
			new JDialogGenBill(string).setVisible(true);
		else if (object == this.bf.JButton_Addinterest)
			JOptionPane.showConfirmDialog((Frame)null, "Add interest to all accounts");
	}

	@Override
	public void setEvent(ActionEvent event) {
		this.event = event;
	}

	@Override
	public void execute() {
	}

}
