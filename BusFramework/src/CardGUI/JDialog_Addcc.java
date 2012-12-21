package CardGUI;

import BusinessFramework.JDialog_AddAcc;

public class JDialog_Addcc extends JDialog_AddAcc{
	public String ccnumber, expdate;
	public JDialog_Addcc(){
	super.setTitle("Add credit card account");
	JRadioButton_Gold.setText("Gold");
	JRadioButton_Gold.setActionCommand("Checkings");
	getContentPane().add(JRadioButton_Gold);
	JRadioButton_Gold.setBounds(36, 12, 84, 24);
	JRadioButton_Silver.setText("Silver");
	JRadioButton_Silver.setActionCommand("Savings");
	getContentPane().add(JRadioButton_Silver);
	JRadioButton_Silver.setBounds(36, 36, 84, 24);
	JRadioButton_Bronze.setText("Bronze");
	JRadioButton_Bronze.setActionCommand("Savings");
	getContentPane().add(JRadioButton_Bronze);
	JRadioButton_Bronze.setBounds(36, 60, 84, 24);
	JLabel6.setText("Exp. Date");
	getContentPane().add(JLabel6);
	JLabel6.setForeground(java.awt.Color.black);
	JLabel6.setBounds(12, 255, 96, 24);
	JLabel8.setText("CC Nr");
	getContentPane().add(JLabel8);
	JLabel8.setForeground(java.awt.Color.black);
	JLabel8.setBounds(12, 230, 48, 24);
	getContentPane().add(JTextField_CCNR);
	JTextField_CCNR.setBounds(84, 230, 156, 20);
	getContentPane().add(JTextField_ExpDate);
	JTextField_ExpDate.setBounds(84, 255, 156, 20);
	JButton_OK.setBounds(48, 300, 84, 24);
	JButton_Cancel.setBounds(156, 300, 84, 24);
	JTextField_EM.setBounds(84, 205, 156, 20);
	JLabeEM.setBounds(12, 205, 48, 24);
	// {{REGISTER_LISTENERS
			SymMouse aSymMouse = new SymMouse();
			JRadioButton_Gold.addMouseListener(aSymMouse);
			JRadioButton_Silver.addMouseListener(aSymMouse);
	
	
	}
	// {{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
		javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
		javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
		javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
		javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
		class SymMouse extends java.awt.event.MouseAdapter {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent event) {
				Object object = event.getSource();
				if (object == JRadioButton_Gold)
					JRadioButtonChk_mouseClicked(event);
				else if (object == JRadioButton_Silver)
					JRadioButtonSav_mouseClicked(event);
				else if (object == JRadioButton_Bronze)
					JRadioButtonBronze_mouseClicked(event);

			}
		}

		void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
			JRadioButton_Gold.setSelected(true);
			JRadioButton_Silver.setSelected(false);
			JRadioButton_Bronze.setSelected(false);
		}

		void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
			JRadioButton_Gold.setSelected(false);
			JRadioButton_Silver.setSelected(true);
			JRadioButton_Bronze.setSelected(false);

		}

		void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event) {
			JRadioButton_Gold.setSelected(false);
			JRadioButton_Silver.setSelected(false);
			JRadioButton_Bronze.setSelected(true);

		}

		
		public void JButtonOK_actionPerformed(){
			ccnumber = JTextField_CCNR.getText();
			expdate = JTextField_ExpDate.getText();
			if (JRadioButton_Gold.isSelected())
				accountType = "Gold";
			else {
				if (JRadioButton_Silver.isSelected())
					accountType = "Silver";
				else
					accountType = "Bronze";
			}
		}
		
}