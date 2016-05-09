package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {
	
	private String name;
	public List<Activity> activityList;

	//Constructor
	public Employee(String name) {
		this.name = name;
		this.activityList = new ArrayList<Activity>();
	}

	// Checks whether the employee has room for more activities.
	public boolean isAvailable() {
		if (activityList.size() < 20) {
			return true;
		}
		return false;
	}

	// Adds an activity to the employee's activity list and sorts the list.
	public void addToActivityList(Activity activity) {
		this.activityList.add(activity);
		Collections.sort(this.activityList);
	}

	// removes an activity from the employee's activity list.
	public void removeFromActivityList(Activity activity) {
		this.activityList.remove(activity);
		Collections.sort(this.activityList);
	}

	// Implements comparable to sort using the employee's name.
	public int compareTo(Employee employee) {
		return this.name.compareTo(employee.getName());
	}

	//Getters
	public String getName() {
		return this.name;
	}

}
