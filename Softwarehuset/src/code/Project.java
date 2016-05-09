package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {

	private String name;
	private String serialNumber;
	private Employee projectManager;
	private LocalDate startDate;
	private LocalDate endDate;

	public List<Employee> employeeList;
	public List<Activity> activityList;

	public Project(String name, Employee projectManager, int startYear, int startMonth, int startDayOfMonth,
			int endYear, int endMonth, int endDayOfMonth) throws OperationNotAllowedException {

		this.activityList = new ArrayList<Activity>();

		if (name != null) {
			this.name = name;
		}
		
		checkDate(startYear, startMonth, startDayOfMonth, endYear, endMonth, endDayOfMonth);

		if (projectManager != null) {
			this.projectManager = projectManager;
		}

	}


	// Creates an activity and adds it to the project's activityList.
	public Activity createActivity(String name, int expectedWorkload, Employee projectManager)
			throws OperationNotAllowedException {
		if (this.projectManager == projectManager) {
			Activity activity = new Activity(name, expectedWorkload, projectManager);
			this.activityList.add(activity);
			Collections.sort(this.activityList);
			return activity;
		} else {
			throw new OperationNotAllowedException("Create activity operation not allowed if not project manager.");
		}
	}


	
	/*Check if the given date is correct:
	 * If the startDate is before today
	 * If the endDate is before today
	 * If the endDate is before startDate
	 */
	public void checkDate(int startYear, int startMonth, int startDayOfMonth, int endYear, int endMonth,
			int endDayOfMonth) throws OperationNotAllowedException {
		if (startYear == 0 || startMonth == 0 || startDayOfMonth == 0) {
			this.startDate = null;
		} else {
			this.startDate = LocalDate.of(startYear, startMonth, startDayOfMonth);
		}
		if (endYear == 0 || endMonth == 0 || endDayOfMonth == 0) {
			this.endDate = null;
		} else {
			this.endDate = LocalDate.of(endYear, endMonth, endDayOfMonth);
		}

		if (this.startDate != null) {
			if (LocalDate.now().isAfter(this.startDate)) {
				throw new OperationNotAllowedException(
						"Create project not allowed if start date is before current date.");
			}
		}
		if (this.endDate != null) {
			if (LocalDate.now().isAfter(this.endDate)) {
				throw new OperationNotAllowedException(
						"Create project not allowed if end date is before current date.");
			}
		}
		if (this.endDate != null && this.startDate != null) {
			if (this.endDate.isBefore(this.startDate)) {
				throw new OperationNotAllowedException("Create project not allowed if start date is after end date.");
			}

		}
	}

	// Check whether the employee is the project manager.
	// returns true if there is no current projectManager
	public boolean isProjectManager(Employee employee) {
		if (this.projectManager == employee || this.projectManager==null) {
			return true;
		}
		return false;
	}

	//Searches the project's activityList for a given activity and  returns it
	//returns null if no activity is found
	public Activity searchActivity(String string) {
		for(int i =0; i<activityList.size();i++){
			if(string.equals(activityList.get(i).getName())){
				return activityList.get(i);
			}
		}
		return null;

	}
	
	//getters and setters
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public String getName() {
		return name;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setProjectManager(Employee e1) {
		projectManager = e1;
	}

	public void setStartDate(int startYear, int startMonth, int startDay) {
		startDate = LocalDate.of(startYear, startMonth, startDay);
	}

	public void setEndDate(int endYear, int endMonth, int endDay) {
		endDate = LocalDate.of(endYear, endMonth, endDay);
	}

}
