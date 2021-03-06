package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;
import code.Project;

public class CreateProjectPanel extends JPanel {

	private Model model;
	public JComboBox<String> startDay, startMonth, startYear, endDay, endMonth, endYear, employees;
	public JTextField name;
	private ButtonListener bL;
	private GridBagConstraints gbc;
	private JButton delete;
 
	//a panel for the create project frame.
	public CreateProjectPanel(Model model,ButtonListener bL) {
		this.model = model;
		this.bL = bL;
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

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

		this.name = new JTextField();

		this.add(name, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel startDate = new JLabel("Start Date:");
		this.add(startDate, gbc);


		this.startDay = new JComboBox<String>();

		startDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			startDay.addItem("" + i);
		}

		this.startMonth = new JComboBox<String>();

		startMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			startMonth.addItem("" + i);
		}


		this.startYear = new JComboBox<String>();

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


		this.endDay = new JComboBox<String>();

		endDay.addItem("dd");
		for (int i = 1; i <= 31; i++) {
			endDay.addItem("" + i);
		}


		this.endMonth = new JComboBox<String>();

		endMonth.addItem("mm");
		for (int i = 1; i <= 12; i++) {
			endMonth.addItem("" + i);
		}


		this.endYear = new JComboBox<String>();

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


		this.employees = new JComboBox<String>();

		employees.addItem("");
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
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(bL);
		this.add(confirm, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(bL);
		this.add(cancel, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		delete = new JButton("Delete project");
		delete.addActionListener(bL);
		delete.setEnabled(false);
		this.add(delete, gbc);
	
	}
	
	public void editProject(Project p) {
		delete.setEnabled(true);
		this.name.setText(p.getName());
		
		
		
		for (int i = 0; i < model.employeeList.size(); i++) {
			if (model.employeeList.get(i).equals(p.getProjectManager())) {
				this.employees.setSelectedIndex(i+1);
			}
		}
		if (p.getStartDate() != null) {
			this.startDay.setSelectedIndex(p.getStartDate().getDayOfMonth());
			this.startMonth.setSelectedIndex(p.getStartDate().getMonthValue());
			for (int i = 0; i < this.startYear.getItemCount(); i++) {
				if (!(this.startYear.getItemAt(i).equals("yyyy"))
						&& (p.getStartDate().getYear() == Integer.parseInt(this.startYear.getItemAt(i)))) {
					this.startYear.setSelectedIndex(i);
				}
			}
		}

		if (p.getEndDate() != null) {
			this.endDay.setSelectedIndex(p.getEndDate().getDayOfMonth());
			this.endMonth.setSelectedIndex(p.getEndDate().getMonthValue());
			for (int i = 0; i < this.endYear.getItemCount(); i++) {
				if (!(this.endYear.getItemAt(i).equals("yyyy"))
						&& (p.getEndDate().getYear() == Integer.parseInt(this.endYear.getItemAt(i)))) {
					this.endYear.setSelectedIndex(i);
				}
			}
		}
	}
}
