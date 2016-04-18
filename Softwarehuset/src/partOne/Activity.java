package partOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity implements Comparable<Activity> {

	private String name;
	private int expectedWorkload;
	private TimeManager timeManager;
	private Employee projectManager;

	public List<Employee> employeeList;

	public Activity(String name, int expectedWorkload, Employee projectManager) {
		this.name = name;
		this.expectedWorkload = expectedWorkload;
		this.projectManager = projectManager;
		this.employeeList = new ArrayList<Employee>();
	}

	// Add an employee to the activity and sort the employeeList.
	public void addEmployee(List<Employee> employees) {
		for (Employee e : employees) {
			if (e.isAvailable()) {
				this.employeeList.add(e);
				e.addToActivityList(this);
			}
		}
		Collections.sort(this.employeeList);
	}

	// Check whether the employee is the project manager.
	public boolean isProjectManager(Employee employee) {
		if (this.projectManager == employee) {
			return true;
		}
		return false;
	}

	// Implements comparable to sort using the activity name.
	public int compareTo(Activity activity) {
		return this.name.compareTo(activity.getName());
	}

	public String getName() {
		return this.name;
	}

	public int getExpectedWorkload() {
		return this.expectedWorkload;
	}

}
