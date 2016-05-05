package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import code.Model;

public class ButtonPanel extends JPanel {

	public ButtonPanel(Frame f, Model model) {
		ButtonListener bL =f.getButtonListener();
		System.out.println("button");
		// this.setBackground(Color.GREEN);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton cP = new JButton("Edit Project");
		cP.addActionListener(bL);
		this.add(cP, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JButton("Get Repport"), gbc);

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
