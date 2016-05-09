package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import code.Employee;
import code.Model;

public class CreateActivityPanel extends JPanel{
	private Model model;
	public JComboBox<String> startDay, startMonth, startYear, endDay, endMonth, endYear, employees, employeesAddedBox;
	public JTextField name, expectedWorkTime;
	private ButtonListener bL;
	private GridBagConstraints gbc;
	private Frame f;
	private boolean firstRun = true;
	private ArrayList<Employee> addedEmployees, tempEmployees;
	private JButton removeEmp;
	private JTextArea messageText;
	
	public CreateActivityPanel(Model model, ButtonListener bL, Frame f) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.bL = bL;
		this.f = f;
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		this.addedEmployees = new ArrayList<Employee>();
		this.tempEmployees = new ArrayList<Employee>();
		for(Employee e: model.employeeList){
			tempEmployees.add(e);
		}

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel aName = new JLabel("Activity Name:");
		this.add(aName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.name = new JTextField();
		this.add(name, gbc);

		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel eName = new JLabel("Expected Work Time:");
		this.add(eName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.expectedWorkTime = new JTextField();
		this.add(expectedWorkTime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel e = new JLabel("Employees");
		this.add(e, gbc);

		this.employees = new JComboBox<String>();
		employeesAddedBox = new JComboBox<String>();

		employees.addItem("");
		for (int i = 0; i < tempEmployees.size(); i++) {
			employees.addItem(tempEmployees.get(i).getName());
		}

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(employees, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton addEmployee = new JButton("+");
		addEmployee .addActionListener(bL);
		this.add(addEmployee, gbc);

		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JLabel message = new JLabel("Message:");
		this.add(message, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		messageText = new JTextArea(5,20);
		messageText.setWrapStyleWord(true);
		messageText.setLineWrap(true);
		JScrollPane j = new JScrollPane(messageText);
		j.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollBar bar = j.getVerticalScrollBar();
		bar.setPreferredSize(new Dimension(17, 0));
		this.add(j, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(bL);
		this.add(confirm, gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(bL);
		this.add(cancel, gbc);


	}

	public void setEmployeesToActivity() {
		if(!firstRun){
			this.remove(employeesAddedBox);
		}
		this.remove(employees);
		
		//updating the employeeList
		employees.removeAllItems();
		employees.addItem("");
		for (int i = 0; i < tempEmployees.size(); i++) {
			employees.addItem(tempEmployees.get(i).getName());
		}
		employees.setSelectedItem(0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(employees, gbc);
		
		//Creating added EmployeeList
		if(addedEmployees.size()>0){
		employeesAddedBox.removeAllItems();

		employeesAddedBox.addItem("Added Employees");
		for (int i = 0; i < addedEmployees.size(); i++) {
			employeesAddedBox.addItem(addedEmployees.get(i).getName());
		}

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(employeesAddedBox, gbc);

		
		//Label for added employees
		if(firstRun){
			gbc.gridx = 2;
			gbc.gridy = 5;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			removeEmp = new JButton("-");
			removeEmp.addActionListener(bL);
			this.add(removeEmp, gbc);
			firstRun = false;
		}
		} else{
			firstRun = true;
			this.remove(removeEmp);
			this.remove(employeesAddedBox);
		}
	}
	
	public void addEmployee(Employee e1) {
		addedEmployees.add(e1);
		tempEmployees.remove(e1);
	}
	
	public ArrayList<Employee> getAddedEmployee(){
		return addedEmployees;
	}

	public void removeAddEmployee(Employee e1) {
		if(addedEmployees.size() > 0 ){
			tempEmployees.add(e1);
			addedEmployees.remove(e1);
		} else{
			System.out.println("Create ActivityPanel");
		}

	}
	
	public String getMessageText(){
		return messageText.getText();
	}
	
	
}
