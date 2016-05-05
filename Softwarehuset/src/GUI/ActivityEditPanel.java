package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;

public class ActivityEditPanel extends JPanel{

	private Model model;
	private ButtonListener bL;

	public ActivityEditPanel(Model model, ButtonListener bL) {
		// TODO Auto-generated constructor stub
		
		this.model = model;
		this.bL = bL;
		// this.setBackground(Color.GREEN);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel pName = new JLabel("Activity Name:");
		this.add(pName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;

		JTextField name = new JTextField();

		this.add(name, gbc);
		
	}

}
