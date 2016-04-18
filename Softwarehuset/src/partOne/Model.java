package partOne;

import java.util.ArrayList;

public class Model {
	public ArrayList<Employee> employeeList;
	public ArrayList<NonProjectActivity> nonProjectActivityList;
	public ArrayList<Project> projectList;

	public Model() {
		this.employeeList = new ArrayList<Employee>();
		this.nonProjectActivityList = new ArrayList<NonProjectActivity>();
		this.projectList = new ArrayList<Project>();
	}

	// Creates a new employee and adds it to the employee list.
	public void createEmployee(String name) {
		this.employeeList.add(new Employee(name));
	}

	// Creates a new project and adds it to the project list.

	public void createProject(String name, Employee projectManager) {
		this.projectList.add(new Project(name, projectManager));
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
}
