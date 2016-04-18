package partOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {

	private String name;
	private int serialNumber;
	private Employee projectManager;

	public List<Employee> employeeList;
	public List<Activity> activityList = new ArrayList<Activity>();

	//Constructor
	public Project(String name, Employee projectManager) {
		createSerialNumber();
		this.name = name;
		this.projectManager = projectManager;
	}
	
	//Contructor
	public Project(String name) {
		createSerialNumber();
		this.name = name;
	}

	// Automatically generates the projects serial. 
	private void createSerialNumber() {
		this.serialNumber = 0;
	}

	// Creates an activity and adds it to the activity list.
	public void createActivity(String name, int expectedWorkload, Employee projectManager) {
		Activity activity = new Activity(name, expectedWorkload, projectManager);
		activityList.add(activity);
		Collections.sort(this.activityList);
	}

	public boolean notStarted() {
		// Specifies whether the project has started?
		return false;
	}


}
