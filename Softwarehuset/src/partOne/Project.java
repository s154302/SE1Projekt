package partOne;

import java.util.Collections;
import java.util.List;

public class Project {

	private String name;
	private int serialNumber;
	private Employee projectManager;
	private int startDate;

	public List<Employee> employeeList;
	public List<Activity> activityList;

	public Project(String name, Employee projectManager) {
		createSerialNumber();
		this.name = name;
		this.projectManager = projectManager;
	}

	// Automatically generates the projects serial. 
	private void createSerialNumber() {
		this.serialNumber = 0;
	}
	
	public int  getSerialNumber(){
		return serialNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public Employee getProjectManager(){
		return projectManager;
	}
	
	public void setStartDate (){
		this.startDate = 0;
	}
	
	public int getStartDate (){
		return startDate;
	}
	// Creates an activity and adds it to the activity list.
	public void createActivity(String name, int expectedWorkload, Employee projectManager) {
		Activity activity = new Activity(name, expectedWorkload, projectManager);
		this.activityList.add(activity);
		Collections.sort(this.activityList);
	}

	public boolean notStarted() {
		// Specifies whether the project has started?
		return false;
	}

}
