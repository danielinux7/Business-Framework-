package CardGUI;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import BusinessFramework.AccManager;
import BusinessFramework.BusFrm;
import BusinessFramework.Command;
import BusinessFramework.IAccManager;
import CreditCardExample.Cmd;

/**
 * A basic JFC based application.
 */
public class CardFrm extends BusFrm {
	
	public CardFrm(){
		super();
		setTitle("Credit-card processing Application.");
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[7];
		JButton_NewAccount.setText("Add Credit-card account");
		AccManager.getInstance().setCommand(new Cmd(this));
	}
}
