package code;

import java.util.Collections;
import java.util.List;

public class NonProjectActivity {

	private String name;
	private int expectedWorkload;
	private TimeManager timeManager;

	public List<Employee> employeeList;

	public NonProjectActivity() {

	}

	// Adds an employee to the activity's employee list and sorts it.
	public void addEmployees(List<Employee> employees) {
		this.employeeList.addAll(employees);
		Collections.sort(this.employeeList);
	}
}
