package partOne;

import java.util.ArrayList;

public class Activity {

	private String name;
	public ArrayList<Employee> employeeList;
	private int expectedWorkload;

	public Activity(String name, int expectedWorkload) {
		this.name = name;
		this.expectedWorkload = expectedWorkload;
	}

	public void addEmployee(Employee employee) {
		if (employee.isAvailable()) {
			this.employeeList.add(employee);
		}
	}

}
