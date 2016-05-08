package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Activity;
import code.Model;

public class ShowActivityPanel extends JPanel {
	
	private Model model;
	private ButtonListener bL;
	private JButton edit, delete;

	public ShowActivityPanel(Model model, Frame f, Activity a) {
		
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

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;

		JLabel name = new JLabel(a.getName());

		this.add(name, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel expWorkloadLabel = new JLabel("Expected Workload:");
		this.add(expWorkloadLabel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;

		JLabel expWorkload = new JLabel("" + a.getExpectedWorkload());

		this.add(expWorkload, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		edit = new JButton("Edit Activity");
		edit.addActionListener(bL);
		this.add(edit, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		delete = new JButton("Delete Activity");
		delete.addActionListener(bL);
		this.add(delete, gbc);
	}

}
