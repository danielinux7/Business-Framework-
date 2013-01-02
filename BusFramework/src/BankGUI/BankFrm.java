package BankGUI;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import BankingExample.Cmd;
import BusinessFramework.AccManager;
import Hibernate.MainSession;

/**
 * A basic JFC based application.
 */
public class BankFrm extends BusinessFramework.BusFrm {
	

	public BankFrm() {
		super();
		setTitle("Bank Application.");
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		JPanel1.remove(JButton_NewAccount);
		JButton_GenBill.setBounds(468, 70, 96, 33);
		JButton_Withdraw.setBounds(468, 190, 96, 33);
		JButton_Deposit.setBounds(468, 140, 96, 33);
		JButton_Addinterest.setBounds(468, 20, 96, 33);
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		AccManager.getInstance().setCommand(new Cmd(this));
		JButton_PerAC.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_CompAC.addActionListener(AccManager.getInstance()
				.getActionListener());
		AccManager.getInstance().setCommand(new Cmd(this));
		

	}
	public javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	public javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	
}
