package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Model;

public class ButtonPanel extends JPanel {

	public ButtonPanel(Frame f, Model model) {
		ButtonListener bL =f.getButtonListener();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;

		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel currentEmployee = new JLabel();
		if(model.getCurrentEmployee() == null){
			currentEmployee.setText("You are logged in as: Guest");
		}else{
			currentEmployee.setText("You are logged in as: " + model.getCurrentEmployee().getName());
		}
		this.add(currentEmployee, gbc);
		
		
		
		JButton logout = new JButton ("Logout");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		logout.addActionListener(bL);
		this.add(logout, gbc);
		
		gbc.gridx = 0;
		gbc.gridy =0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton cP = new JButton("Edit Project");
		cP.addActionListener(bL);
		this.add(cP, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton getReport = new JButton("Get Project Report");
		getReport.addActionListener(bL);
		this.add(getReport, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JButton("Add Time"), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JButton("Absence"), gbc);

	}

}
