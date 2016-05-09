package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Model;
import code.Project;

public class AbsencePanel extends JPanel {

	private Model model;
	private ButtonListener bL;
	private boolean firstRun;
	private JScrollPane tableContainer;
	private Object[][] data;
	private JTable table;
	private TableListener tableListener;
	private String[] columnNames = { "Employees", "Courses", "Sickness", "Vacation", "Other" };

	private AbsenceFrame aF;
	private JButton addTime;

	//overview of absence.
	public AbsencePanel(Model model, ButtonListener bL, AbsenceFrame aF) {
		this.model = model;
		this.bL = bL;
		this.aF = aF;
		this.setLayout(new BorderLayout());
		firstRun = true;

		updateList();

		addTime = new JButton("Add Absence Time");
		addTime.addActionListener(bL);
		this.add(addTime, "South");

	}

	public void updateList() {
		if (!firstRun) {
			this.remove(tableContainer);
			table.removeAll();
		}

		data = new Object[model.employeeList.size()][model.nonProjectActivityList.size() + 1];

		// setting names
		for (int i = 0; i < model.employeeList.size(); i++) {
			data[i][0] = model.employeeList.get(i).getName();
		}

		// setting absence
		for (int i = 0; i < model.nonProjectActivityList.size(); i++) {
			for (int j = 0; j < model.nonProjectActivityList.get(i).getEmployeeList().size(); j++) {
				
				data[j][i + 1] = "" + model.nonProjectActivityList.get(i).getTimeManager()
							.getTime(model.nonProjectActivityList.get(i).getEmployeeList().get(j));
				
			}
		}

		table = new JTable(data, columnNames);
		table.setModel(new TableModel(data, columnNames));
		tableContainer = new JScrollPane(table);

		this.add(tableContainer, BorderLayout.CENTER);
		firstRun = false;
	}

}
