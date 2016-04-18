package partOne;
import java.util.ArrayList;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;
import static partOne.ProjectBuilder.project;

public class Model {
	public ArrayList<Employee> employeeList;
	public ArrayList<NonProjectActivity> nonProjectActivityList;
	public ArrayList<Project> projectList;
	
	public Model(){
		
	}
	
	public Model(ArrayList<Employee> employeeList, ArrayList<NonProjectActivity> nonProjectActivityList, ArrayList<Project> projectList){
		this.employeeList = employeeList;
		this.nonProjectActivityList = nonProjectActivityList;
		this.projectList = projectList;
	}
	
	// Creates a new employee and adds it to the employee list.
	public void createEmployee(String name) {
		this.employeeList.add(new Employee(name));
	}
	
	// Creates a new project and adds it to the project list.
<<<<<<< HEAD
	public void createProject(String name, Employee projectManager, int startDate) {
		this.projectList.add(new Project(name, projectManager));
=======
	public void createProject(String name, Employee projectManager) {
//		this.projectList.add(
		Project project = new ProjectBuilder().withName("hej")		
		
>>>>>>> origin/Emilie
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
