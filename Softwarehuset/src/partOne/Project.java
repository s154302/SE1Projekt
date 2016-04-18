package partOne;

import java.util.Collections;
import java.util.List;

public class Project {

	private final String name;
	private  int serialNumber;
	private final Employee projectManager;
	private final int startDate;

	public List<Employee> employeeList;
	public List<Activity> activityList;

	 Project(ProjectBuilder builder) {
//	        if (builder.name == null) throw new NullPointerException("name");
//	        if (builder.projectManager == null) throw new NullPointerException("projectManager");
		createSerialNumber();
		this.name = builder.name;
		this.projectManager = builder.projectManager;
		this.startDate = builder.startDate;
	}

	// Automatically generates the projects serial. 
	private void createSerialNumber() {
		this.serialNumber = 0;
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
	public String getName(){
		return name;
	}
	public Employee getProjectManager(){
		return projectManager;
	}

	public Employee getProjectManger() {
		return this.projectManager;
	}

}
