package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Model {
	//Fields
	public ArrayList<Employee> employeeList;
	public ArrayList<NonProjectActivity> nonProjectActivityList;
	public ArrayList<Project> projectList;
	// the employee logged in to the system
	private Employee currentEmployee;
	private int counter = 0;

	//Constructor
	public Model() {
		this.projectList = new ArrayList<Project>();
		this.nonProjectActivityList = new ArrayList<NonProjectActivity>();
		this.employeeList = new ArrayList<Employee>();

		//creating the absence activities
		this.nonProjectActivityList.add(new NonProjectActivity("Courses"));
		this.nonProjectActivityList.add(new NonProjectActivity("Sick"));
		this.nonProjectActivityList.add(new NonProjectActivity("Vacation"));
		this.nonProjectActivityList.add(new NonProjectActivity("Other"));
		
	}

	// Creates a new employee and adds it to the employee list.
	public void createEmployee(String name) {
		this.employeeList.add(new Employee(name));
		Collections.sort(this.employeeList);
	}

	// Creates a new project and adds it to the project list.
	public void createProject(String name, Employee projectManager, int startYear, int startMonth, int startDayOfMonth,
			int endYear, int endMonth, int endDayOfMonth) throws OperationNotAllowedException {
		Project p = new Project(name, projectManager, startYear, startMonth, startDayOfMonth, endYear, endMonth,
				endDayOfMonth);
		p.setSerialNumber(createSerialNumber());
		this.projectList.add(p);

	}

	// Automatically generates the projects serial.
	private String createSerialNumber() {
		LocalDate currentDate = LocalDate.now();
		int d = currentDate.getDayOfMonth();
		int m = currentDate.getMonthValue();
		int y = currentDate.getYear();

		String dString;
		String mString;
		String yString;

		if (d < 10) {
			dString = "0" + d;
		} else {
			dString = String.valueOf(d);
		}

		if (m < 10) {
			mString = "0" + m;
		} else {
			mString = String.valueOf(m);
		}

		yString = String.valueOf(y).substring(2, 4);

		return counter() + "-" + dString + mString + yString;
	}
	
	//Counter is used for creating serial number
	public String counter() {
		this.counter++;
		String counterString;
		if (this.counter > 9999) {
			counter = 1;
		}
		if (this.counter > 999) {
			counterString = String.valueOf(this.counter);
		} else if (this.counter > 99) {
			counterString = "0" + this.counter;
		} else if (this.counter > 9) {
			counterString = "00" + this.counter;
		} else {
			counterString = "000" + this.counter;
		}
		return counterString;
	}

	// Deletes an employee from the employeeList
	public void removeEmployee(Employee employee) {
		this.employeeList.remove(employee);
	}

	//getting the projectlist
	public ArrayList<Project> projectList() {
		return projectList;
	}

	//setting the current employee
	public void setCurrentEmployee(Employee employee) {
		currentEmployee = employee;
	}
	
	//Search the employeeList for a given employee and returns the employee. 
	//If not found return null
	public Employee searchEmployee(String name) {

		for (Employee employee : employeeList) {
			if (name.equals(employee.getName())) {

				return employee;
			}
		}

		return null;
	}

	public Employee getCurrentEmployee() {
		return currentEmployee;
	}

	// Creates a .txt file which contains info about a given project
	public void reportProject(Project project) throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter write = new PrintWriter(
				"Report for " + project.getName() + " " + project.getSerialNumber().toString(), "UTF-8");
		write.println(project.getSerialNumber() + " " + project.getName() + "- Data extracted " + LocalTime.now());
		double totalProjectWorkload = 0;
		double completedProjectWorkload = 0;
		double remainingProjectWorkload = 0;
		for (Activity activity : project.activityList) {
			totalProjectWorkload = totalProjectWorkload + activity.getExpectedWorkload();

			for (Employee employee : activity.employeeList) {
				completedProjectWorkload = completedProjectWorkload + activity.getTimeManager().getTime(employee);
			}
		}
		remainingProjectWorkload = totalProjectWorkload - completedProjectWorkload;
		write.println("Total Expected workload: " + totalProjectWorkload + ", Completed workload: "
				+ completedProjectWorkload + ", Remaining workload: " + remainingProjectWorkload);
		write.println();
		write.println("Activities");

		for (Activity activity : project.activityList) {
			double activityExpectedWorkload = activity.getExpectedWorkload();
			double activityCompletedWorkload = 0;
			double activityRemainingWorkload = 0;

			for (Employee employee : activity.employeeList) {
				activityCompletedWorkload = activityCompletedWorkload + activity.getTimeManager().getTime(employee);
			}
			activityRemainingWorkload = activityExpectedWorkload - activityCompletedWorkload;
			write.println(
					activity.getName() + " Expected workload: " + activityExpectedWorkload + ", Completed workload: "
							+ activityCompletedWorkload + ", Remaining workload: " + activityRemainingWorkload);
		}
		write.close();
	}
	
	//Deletes  an activity from the activityList if the currentEmployee is the projectManager
	public void deleteActivity(Project p, Activity a) throws OperationNotAllowedException {
		if (p.isProjectManager(currentEmployee)) {
			double completedWork = 0;
			for (Employee employee : a.employeeList) {
				completedWork = completedWork + a.getTimeManager().getTime(employee);
			}
			if (completedWork == 0) {

				for (Employee employee : a.employeeList) {
					employee.activityList.remove(a);
				}
				p.activityList.remove(a);
			}
		} else {
			throw new OperationNotAllowedException("Activities can only be deleted by the project manager.");
		}

	}
	
	
	//Deletes a project from the projectList if the currentEmployee is the projectManager
	//or if the project does not have a projectManager
	public void deleteProject(Project p) throws OperationNotAllowedException {
		if (p.isProjectManager(currentEmployee)) {
			double completedWork = 0;
			for (Activity activity : p.activityList) {

				for (Employee employee : activity.employeeList) {
					completedWork = completedWork + activity.getTimeManager().getTime(employee);
				}

			}
			if (completedWork == 0.0) {

				for (Activity activity : p.activityList) {

					for (Employee employee : activity.employeeList) {
						employee.activityList.remove(activity);
					}

					// p.activityList.remove(activity);
				}

				projectList.remove(p);
			}
		} else {
			throw new OperationNotAllowedException("Only the manager for this project can delete it");
		}

	}
	
	//Searches the projectList for a given serialnumber and return the project
	//if not found it returns null
	public Project searchProject(String string) {
		for (int i = 0; i < projectList.size(); i++) {
			if (string.equals(projectList.get(i).getSerialNumber())) {
				return projectList.get(i);
			}
		}
		return null;
	}

}
