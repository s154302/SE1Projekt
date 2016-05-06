package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;

public class ShowActivityPanel extends JPanel {
	
	private Model model;
	private ButtonListener bL;
	private JButton edit;

	public ShowActivityPanel(Model model, Frame f) {
		// TODO Auto-generated constructor stub
		
		this.model = model;
		this.bL = f.getButtonListener();
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
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		edit = new JButton("Edit");
		edit.addActionListener(bL);
		this.add(edit, gbc);
		
		
	}

}
