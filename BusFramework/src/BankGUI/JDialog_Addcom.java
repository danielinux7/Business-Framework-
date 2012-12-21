package BankGUI;

import BusinessFramework.JDialog_AddAcc;

public class JDialog_Addcom extends JDialog_AddAcc{
	public String accountnr, empnr;
	public JDialog_Addcom(){
	super.setTitle("Add company account");
	JRadioButton_Chk.setText("Checkings");
	JRadioButton_Chk.setActionCommand("Checkings");
	getContentPane().add(JRadioButton_Chk);
	JRadioButton_Chk.setBounds(36, 0, 84, 24);
	JRadioButton_Sav.setText("Savings");
	JRadioButton_Sav.setActionCommand("Savings");
	getContentPane().add(JRadioButton_Sav);
	JRadioButton_Sav.setBounds(36, 24, 84, 24);
	JLabel6.setText("No of employees");
	getContentPane().add(JLabel6);
	JLabel6.setForeground(java.awt.Color.black);
	JLabel6.setBounds(12, 204, 96, 24);
	JLabel8.setText("Acc Nr");
	getContentPane().add(JLabel8);
	JLabel8.setForeground(java.awt.Color.black);
	JLabel8.setBounds(12, 60, 48, 24);
	getContentPane().add(JTextField_NoOfEmp);
	JTextField_NoOfEmp.setBounds(84, 204, 156, 20);
	getContentPane().add(JTextField_ACNR);
	JTextField_ACNR.setBounds(84, 60, 156, 20);
	// {{REGISTER_LISTENERS
			SymMouse aSymMouse = new SymMouse();
			JRadioButton_Chk.addMouseListener(aSymMouse);
			JRadioButton_Sav.addMouseListener(aSymMouse);
	
	
	}
	// {{DECLARE_CONTROLS
		javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
		javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
		javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
		class SymMouse extends java.awt.event.MouseAdapter {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent event) {
				Object object = event.getSource();
				if (object == JRadioButton_Chk)
					JRadioButtonChk_mouseClicked(event);
				else if (object == JRadioButton_Sav)
					JRadioButtonSav_mouseClicked(event);
			}
		}

		void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
			// When Checking radio is clicked make this radio on
			// and make Saving account radio off
			JRadioButton_Chk.setSelected(true);
			JRadioButton_Sav.setSelected(false);
		}

		void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
			// When Saving radio is clicked make this radio on
			// and make Checking account radio off
			JRadioButton_Chk.setSelected(false);
			JRadioButton_Sav.setSelected(true);

		}
		public void JButtonOK_actionPerformed(){
			accountnr = JTextField_ACNR.getText();
			empnr = JTextField_NoOfEmp.getText();
			if (JRadioButton_Chk.isSelected())
				accountType = "Ch";
			else
				accountType = "S";
		}
		
}