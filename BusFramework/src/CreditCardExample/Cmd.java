package CreditCardExample;

import BusinessFramework.BusFrm;
import BusinessFramework.Command;
import CardGUI.CardFrm;
public class Cmd extends Command {

	protected CardFrm bf;

	public Cmd(CardFrm bf) {
		super(bf);
		this.bf = bf;
	}

	@Override
	public void executeLogic() {

		Object object = this.event.getSource();
		if (object == this.bf.JButton_Exit)
			System.exit(0);
		else if (object == this.bf.JButton_NewAccount)
			new NewAccCommand(this.bf).execute();
		else if (object == this.bf.JButton_Deposit)
			new DepositCommand(this.bf).execute();
		else if (object == this.bf.JButton_Withdraw)
			new WithdrawCommand(this.bf).execute();
		else if (object == this.bf.JButton_GenBill)
			new GenBillCommand(this.bf).execute();
		else if (object == this.bf.JButton_Addinterest)
			new InterestCommand(this.bf).execute();
	}
}
