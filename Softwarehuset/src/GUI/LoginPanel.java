package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Model;

public class LoginPanel extends JPanel{

	private Model model;
	private ButtonListener bL;

	public LoginPanel(Model model, ButtonListener bL) {
		// TODO Auto-generated constructor stub
		this.model = model;
		JComboBox<String> employees = new JComboBox<String>();
		this.bL = bL;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel pName = new JLabel("Employee");
		this.add(pName, gbc);

		employees.addItem("Guest");
		for (int i = 0; i < this.model.employeeList.size(); i++) {
			employees.addItem(this.model.employeeList.get(i).getName());
		}

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(employees, gbc);
		
		JButton login = new JButton("Login");
		login.addActionListener(bL);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(login, gbc);
		
		
	}



}
