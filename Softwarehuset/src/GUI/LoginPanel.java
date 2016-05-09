
package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import code.Employee;
import code.Model;

public class LoginPanel extends JPanel{

	private Model model;
	private ButtonListener bL;
	public JComboBox<String> employees;
	
	
	//the first panel, for when the employee chooses who he is
	public LoginPanel(Model model, ButtonListener bL) {
		this.model = model;
		employees = new JComboBox<String>();
		this.bL = bL;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		employees.setRenderer(renderer);

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.LINE_END;
		gbc.gridheight = 1;

		updateEmployeeComboBox();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		this.add(employees, gbc);
		
		JButton login = new JButton("Login");
		login.addActionListener(bL);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(login, gbc);
		
		JButton addEmployee = new JButton("Add employee");
		addEmployee.addActionListener(bL);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(addEmployee, gbc);
		
		JButton removeEmployee = new JButton("Remove employee");
		removeEmployee.addActionListener(bL);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(removeEmployee, gbc);
	}

	public void updateEmployeeComboBox(){
		employees.removeAllItems();
		employees.addItem("Guest");
		for (Employee employee : this.model.employeeList){
			employees.addItem(employee.getName());
		}
	}

}