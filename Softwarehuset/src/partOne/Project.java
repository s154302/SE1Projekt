package partOne;

import java.util.*;

public class Project {

	private String name;
	private int serialNumber;
	private Employee projectManager;
	private Calendar startDate;

	public List<Employee> employeeList;
	public List<Activity> activityList;

	public Project(String name, Employee projectManager) {
		createSerialNumber();
		this.activityList = new ArrayList<Activity>();
		this.startDate = Calendar.getInstance();

		if (name != null) {
			this.name = name;
		}

		if (!projectManager.equals(null)) {
			this.projectManager = projectManager;
		}
	}

	// Automatically generates the projects serial.
	private void createSerialNumber() {
		this.serialNumber = 0;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	// public void setStartDate (){
	// this.startDate = 0;
	// }

	public Calendar getStartDate() {
		return startDate;
	}

	// Creates an activity and adds it to the activity list.
	public void createActivity(String name, int expectedWorkload, Employee projectManager)
			throws OperationNotAllowedException {
		if (this.projectManager == projectManager) {
			Activity activity = new Activity(name, expectedWorkload, projectManager);
			this.activityList.add(activity);
			Collections.sort(this.activityList);
		} else {
			throw new OperationNotAllowedException("Create activity operation not allowed if not project manager.");
		}
	}

	public boolean notStarted() {
		// Specifies whether the project has started?
		return false;
	}

	public String getName() {
		return name;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public Employee getProjectManger() {
		return this.projectManager;
	}

}
