package partOne;

import java.util.List;

public class Activity {

	private String name;
	private int expectedWorkload;
	private TimeManager timeManager;
	
	public List<Employee> employeeList;

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
