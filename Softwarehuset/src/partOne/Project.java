package partOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {

	private String name;
	private int serialNumber;
	private Employee projectManager;

	public List<Employee> employeeList;
	public List<Activity> activityList;

	public Project(String name, Employee projectManager) {
		createSerialNumber();
		this.name = name;
		this.projectManager = projectManager;
		this.activityList = new ArrayList<Activity>();
	}

	// Automatically generates the projects serial.
	private void createSerialNumber() {
		this.serialNumber = 0;
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

	public Employee getProjectManger() {
		return this.projectManager;
	}

}
