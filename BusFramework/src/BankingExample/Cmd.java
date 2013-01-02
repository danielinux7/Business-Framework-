package BankingExample;

import BankGUI.BankFrm;
import BusinessFramework.Command;
import Hibernate.MainSession;

public class Cmd extends Command {

	protected BankFrm bf;

	public Cmd(BankFrm bf) {
		super(bf);
		this.bf = bf;
	}

	@Override
	public void executeLogic() {

		Object object = this.event.getSource();
		if (object == this.bf.JButton_Exit){
			try {
				MainSession.tearDown();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		else if (object == this.bf.JButton_PerAC)
			new PersonalCommand(this.bf).execute();
		else if (object == this.bf.JButton_CompAC)
			new CompanyCommand(this.bf).execute();
		else if (object == this.bf.JButton_Deposit)
			new DepositCommand(this.bf).execute();
		else if (object == this.bf.JButton_Withdraw)
			new WithdrawCommand(this.bf).execute();
		else if (object == this.bf.JButton_Addinterest)
			new InterestCommand(this.bf).execute();
		else if (object == this.bf.JButton_GenBill)
			new GenBillCommand(this.bf).execute();

	}
}
