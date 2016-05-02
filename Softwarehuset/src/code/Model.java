package code;

import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
	public ArrayList<Employee> employeeList;
	public ArrayList<NonProjectActivity> nonProjectActivityList;
	public ArrayList<Project> projectList;
	
	private int counter = 0;

	public Model() {
		projectList = new ArrayList<Project>();

	}

	public Model(ArrayList<Employee> employeeList, ArrayList<NonProjectActivity> nonProjectActivityList,
			ArrayList<Project> projectList) {
		this.employeeList = employeeList;
		this.nonProjectActivityList = nonProjectActivityList;
		this.projectList = projectList;
	}

	// Creates a new employee and adds it to the employee list.
	public void createEmployee(String name) {
		this.employeeList.add(new Employee(name));
	}

	// Creates a new project and adds it to the project list.

	public void createProject(String name, Employee projectManager, int startYear, int startMonth, int startDayOfMonth,
			int endYear, int endMonth, int endDayOfMonth) {
		Project p = new Project(name, projectManager, startYear, startMonth, startDayOfMonth, endYear,
				endMonth, endDayOfMonth);
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

		yString = String.valueOf(y).substring(1, 3);

		return counter() + "-" + dString + mString + yString;
	}
	
	public String counter() {
		this.counter++;
		String counterString;
		if(this.counter > 1000) {
			counterString = String.valueOf(this.counter);
		} else if(this.counter > 100) {
			counterString = "0" + this.counter;
		} else if(this.counter > 10) {
			counterString = "00" + this.counter;
		} else {
			counterString = "000" + this.counter;
		}
		return counterString;
	}

	// Creates a new Non-project activity and adds it to its list.
	public void createNonProjectActivity() {
		// Create a NonProjectActivity.
	}

	// Deletes a project.
	public void removeProject(Project project) {
		this.projectList.remove(project);
	}

	// Deletes an employee.
	public void removeEmployee(Employee employee) {
		this.employeeList.remove(employee);
	}

	public ArrayList<Project> projectList() {
		return projectList;
	}
}
