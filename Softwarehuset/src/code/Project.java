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
		if (startYear == 0 || startMonth == 0 || startDayOfMonth == 0) {
			this.startDate=null;
		} else {
			this.startDate = LocalDate.of(startYear, startMonth, startDayOfMonth);
		}
		if (endYear == 0 || endMonth == 0 || endDayOfMonth == 0) {
			this.endDate=null;
		} else {
			this.endDate = LocalDate.of(endYear, endMonth, endDayOfMonth);
		}

		if (name != null) {
			this.name = name;
		}

		if (projectManager != null) {
			this.projectManager = projectManager;
		}
		if(this.startDate != null){
			if( LocalDate.now().isAfter(this.startDate) )
			{
				throw new OperationNotAllowedException("Create project not allowed if start date is before current date.");
			}
		}
		if(this.endDate != null){
			if( LocalDate.now().isAfter(this.endDate) )
			{
				throw new OperationNotAllowedException("Create project not allowed if end date is before current date.");
			}
		}
		if(this.endDate!=null && this.startDate !=null){
			if(this.endDate.isBefore(this.startDate))
			{
				throw new OperationNotAllowedException("Create project not allowed if start date is after end date.");
			}
			
		}

	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public LocalDate getStartDate() {
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

	public String getName() {
		return name;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setName(String newName){
		name = newName;
	}
	
	public void setProjectManager(Employee e1){
		projectManager = e1;
	}
	
	public void setStartDate(int startYear, int startMonth, int startDay){
		startDate = LocalDate.of(startYear, startMonth, startDay);
	}
	
	public void setEndDate(int endYear, int endMonth, int endDay){
		endDate = LocalDate.of(endYear, endMonth, endDay);
	}
}
