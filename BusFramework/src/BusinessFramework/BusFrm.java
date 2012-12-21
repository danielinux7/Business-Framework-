package BusinessFramework;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import BusinessFramework.AccManager;
import BusinessFramework.Command;
import BusinessFramework.IAccManager;
import CreditCardExample.Cmd;

/**
 * A basic JFC based application.
 */
public class BusFrm extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	

	public DefaultTableModel model;
	public JTable JTable1;
	public JScrollPane JScrollPane1;
	public BusFrm thisframe;
	public Object rowdata[];

	public BusFrm() {
		thisframe = this;

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, WithdrawCommand and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_NewAccount.setText("Add new account");
		JPanel1.add(JButton_NewAccount);
		JButton_NewAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		this.addWindowListener(aSymWindow);
		AccManager.getInstance().setCommand(new Command(this));
		JButton_Exit.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_NewAccount.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_GenBill.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_Deposit.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_Withdraw.addActionListener(AccManager.getInstance()
				.getActionListener());
		JButton_Addinterest.addActionListener(AccManager.getInstance()
				.getActionListener());
	}
	public javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	public javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	public javax.swing.JButton JButton_NewAccount = new javax.swing.JButton();
	public javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	public javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	public javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	public javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		@Override
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BusFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}
}
