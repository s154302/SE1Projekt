package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Activity;

public class EmployeesPanel extends JPanel {

	private JTable table;
	private Object[][] data;
	private String[] columnNames = { "Employee", "Completed Hours" };
	private JScrollPane tableContainer;

	//panel for overview of employees added in a activity
	public EmployeesPanel(Activity a, ButtonListener bL) {
		this.setLayout(new BorderLayout());
		data = new Object[a.employeeList.size()][2];

		for (int i = 0; i < a.employeeList.size(); i++) {
			data[i][0] = a.employeeList.get(i).getName();
			data[i][1] = a.getTimeManager().getTime(a.employeeList.get(i));
		}

		table = new JTable(data, columnNames);
		table.setModel(new TableModel(data, columnNames));
		
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		
		tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		JButton back = new JButton("Back");
		back.addActionListener(bL);
		this.add(back, "South");
		
	}
}
