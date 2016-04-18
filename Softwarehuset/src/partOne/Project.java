package partOne;

import java.util.List;

public class Project {
	
	private String name;
	private int serialNumber;
	private Employee projectManager;
	
	public List<Employee> employeeList;
	public List<Activity> activityList;
	
	public Project() {
		createSerialNumber();
	}

	private void createSerialNumber() {
		// Create an automatically generated serial number.
		
	}

	public void addActivity(Activity activity) {
		// Add an Activity to the list.
	}

	
}
