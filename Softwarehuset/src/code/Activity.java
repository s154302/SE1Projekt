package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity implements Comparable<Activity> {

	// setting fields
	private String name, message;
	private int expectedWorkload;
	private TimeManager timeManager;
	private Employee projectManager;
	public List<Employee> employeeList;

	//Constructor
	public Activity(String name, int expectedWorkload, Employee projectManager) throws OperationNotAllowedException {
		
		//setting message
		message = "";
		
		//making sure the activity has a name
		if (name.equals("")) {
			throw new OperationNotAllowedException("You must enter a name.");
		} else {
			this.name = name;
		}
		
		//making sure an expected workload has been given
		if (expectedWorkload == 0) {
			throw new OperationNotAllowedException("You must enter an expected workload.");
		} else {
			this.expectedWorkload = expectedWorkload;
		}
		
		//setting the project manager, employee list and making a time manager
		this.projectManager = projectManager;
		this.employeeList = new ArrayList<Employee>();
		this.timeManager = new TimeManager(this);
	}

	// Add an employee to the activity and sort the employeeList. Also assigns
	// the employee to the time manager.
	public void addEmployee(List<Employee> employees) {
		
		//adding an employee if it is available
		for (Employee e : employees) {
			if (e.isAvailable()) {
				this.employeeList.add(e);
				e.addToActivityList(this);
			}
		}
		this.timeManager.addEmployees(employees);
		Collections.sort(this.employeeList);

	}

	//Removes an employee if it has not registered any time
	public void removeEmployee(Employee employee) throws Exception {
		if (this.timeManager.getTime(employee) == 0) {
			employee.removeFromActivityList(this);
			employeeList.remove(employeeList.indexOf(employee));
		} else {
			throw new OperationNotAllowedException("Cannot remove an employee with completed hours.");
		}

	}

	// Check whether the employee is the project manager.
	// returns true if there is no current projectManager
	public boolean isProjectManager(Employee employee) {
		if (this.projectManager == employee || this.projectManager == null) {
			return true;
		}
		return false;
	}

	// Implements comparable to sort using the activity name.
	public int compareTo(Activity activity) {
		return this.name.compareTo(activity.getName());
	}

	//Getters and Setters
	public String getName() {
		return this.name;
	}

	public int getExpectedWorkload() {
		return this.expectedWorkload;
	}

	public TimeManager getTimeManager() {
		return timeManager;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String string) {
		this.message = string;
	}

	public void setExpectedWorkload(int expectedWorkload) {
		this.expectedWorkload = expectedWorkload;
	}

	public String getMessageText() {
		return message;
	}

}
