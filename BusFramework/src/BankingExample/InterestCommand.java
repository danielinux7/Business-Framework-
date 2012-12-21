package BankingExample;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import BankGUI.BankFrm;
import BusinessFramework.DBsim;
import BusinessFramework.IAccount;
import BusinessFramework.ICustomer;
import CreditCardExample.Bronze;
import CreditCardExample.Gold;
import CreditCardExample.Silver;

public class InterestCommand extends Cmd {

	public InterestCommand(BankFrm bf) {
		super(bf);
	}

	@Override
	public void execute() {

		 int yes = JOptionPane.showConfirmDialog((Frame)null, "Add interest to all accounts");
		 if(yes == 0){
			 List<ICustomer> list = DBsim.getInstance().getCustomerList();
			 for(ICustomer cust:list){
			 for (IAccount acc : cust.getAccountList()){
					 if (acc.getClass().equals(new Checking("checking").getClass())) {
							acc.Deposit(acc.getBalance()*((Checking)acc).MI);

					} else if (acc.getClass().equals(new Saving("saving").getClass())) {
							acc.Deposit(acc.getBalance()*((Saving)acc).MI);
					} 
				 }
			 }
			 int row = 0;
			 while(row < this.bf.model.getRowCount()){
			 String accnr = (String) this.bf.model.getValueAt(row, 0);
			 IAccount acc1= DBsim.getInstance().getCustomer(accnr).getAccount(accnr);
			 this.bf.model.setValueAt(String.valueOf(acc1.getBalance()), row,
						5);
			 row++;
		 }
			 
	}
	}
}
