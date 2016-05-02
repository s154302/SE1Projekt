package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;

public class CreateProjectPanel extends JPanel {

	private Model model;

	public CreateProjectPanel(Model model) {
		this.model = model;
		ButtonListener bL = new ButtonListener(model);
		System.out.println("button");
		// this.setBackground(Color.GREEN);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel pName = new JLabel("Project Name:");
		this.add(pName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JTextField name = new JTextField();
		this.add(name, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel startDate = new JLabel("Start Date:");
		this.add(startDate, gbc);

		JComboBox<String> startDay = new JComboBox<String>();
		startDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			startDay.addItem("" + i);
		}

		JComboBox<String> startMonth = new JComboBox<String>();
		startMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			startMonth.addItem("" + i);
		}

		JComboBox<String> startYear = new JComboBox<String>();
		startYear.addItem("yyyy");
		for (int i = 2016; i <= 2100; i++) {
			startYear.addItem("" + i);
		}

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(startDay, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(startMonth, gbc);

		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(startYear, gbc);

		JComboBox<String> endDay = new JComboBox<String>();
		endDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			endDay.addItem("" + i);
		}

		JComboBox<String> endMonth = new JComboBox<String>();
		endMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			endMonth.addItem("" + i);
		}

		JComboBox<String> endYear = new JComboBox<String>();
		endYear.addItem("yyyy");
		for (int i = 2016; i <= 2100; i++) {
			endYear.addItem("" + i);
		}

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel pM = new JLabel("Project Manager:");
		this.add(pM, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel endDate = new JLabel("End Date:");
		this.add(endDate, gbc);

		JComboBox<String> employees = new JComboBox<String>();
		employees.addItem(null);
		for (int i = 0; i < this.model.employeeList.size(); i++) {
			employees.addItem(this.model.employeeList.get(i).getName());
		}

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(employees, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(endDay, gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(endMonth, gbc);

		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(endYear, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(bL);
		this.add(confirm, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(bL);
		this.add(cancel, gbc);

		// gbc.gridx = 0;
		// gbc.gridy = 1;
		// gbc.gridwidth = 2;
		// gbc.gridheight = 1;
		// this.add(new JButton("Button3"), gbc);
	}
}
