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
<<<<<<< HEAD
	public JComboBox<String> startDay, startMonth, startYear, endDay, endMonth, endYear, employees;
	public JTextField name;
	
	public CreateProjectPanel(Model model, ButtonListener bL) {
		this.model = model;
=======

	public CreateProjectPanel(Model model) {
		this.model = model;
		ButtonListener bL = new ButtonListener(model);
>>>>>>> Emilie
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
<<<<<<< HEAD
		this.name = new JTextField();
=======
		JTextField name = new JTextField();
>>>>>>> Emilie
		this.add(name, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel startDate = new JLabel("Start Date:");
		this.add(startDate, gbc);

<<<<<<< HEAD
		this.startDay = new JComboBox<String>();
=======
		JComboBox<String> startDay = new JComboBox<String>();
>>>>>>> Emilie
		startDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			startDay.addItem("" + i);
		}

<<<<<<< HEAD
		this.startMonth = new JComboBox<String>();
=======
		JComboBox<String> startMonth = new JComboBox<String>();
>>>>>>> Emilie
		startMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			startMonth.addItem("" + i);
		}

<<<<<<< HEAD
		this.startYear = new JComboBox<String>();
=======
		JComboBox<String> startYear = new JComboBox<String>();
>>>>>>> Emilie
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

<<<<<<< HEAD
		this.endDay = new JComboBox<String>();
=======
		JComboBox<String> endDay = new JComboBox<String>();
>>>>>>> Emilie
		endDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			endDay.addItem("" + i);
		}

<<<<<<< HEAD
		this.endMonth = new JComboBox<String>();
=======
		JComboBox<String> endMonth = new JComboBox<String>();
>>>>>>> Emilie
		endMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			endMonth.addItem("" + i);
		}

<<<<<<< HEAD
		this.endYear = new JComboBox<String>();
=======
		JComboBox<String> endYear = new JComboBox<String>();
>>>>>>> Emilie
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

<<<<<<< HEAD
		this.employees = new JComboBox<String>();
=======
		JComboBox<String> employees = new JComboBox<String>();
>>>>>>> Emilie
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
