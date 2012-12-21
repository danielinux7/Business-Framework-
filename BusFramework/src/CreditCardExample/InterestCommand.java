package CreditCardExample;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import BankingExample.Bank;
import BusinessFramework.*;
import CardGUI.CardFrm;

public class InterestCommand extends Cmd {

	public InterestCommand(CardFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {

		
		 int yes = JOptionPane.showConfirmDialog((Frame)null, "Add interest to all accounts");
		 if(yes == 0){
			 List<ICustomer> list = DBsim.getInstance().getCustomerList();
			 for(ICustomer cust:list){
			 for (IAccount acc : cust.getAccountList()){
					 if (acc.getClass().equals(new Bronze("bronze").getClass())) {
							acc.Withdraw(acc.getBalance()*((Bronze)acc).MI);

					} else if (acc.getClass().equals(new Gold("gold").getClass())) {
							acc.Withdraw(acc.getBalance()*((Gold)acc).MI);
					} else if (acc.getClass().equals(
								new Silver("silver").getClass())) {
							acc.Withdraw(acc.getBalance()*((Silver)acc).MI);
						}
		 
				 }
			 }
			 int row = 0;
			 while(row < this.bf.model.getRowCount()){
			 String accnr = (String) this.bf.model.getValueAt(row, 1);
			 IAccount acc1= DBsim.getInstance().getCustomer(accnr).getAccount(accnr);
			 this.bf.model.setValueAt(String.valueOf(acc1.getBalance()), row,
						4);
			 row++;
		 }
			 
	}
  }
}
