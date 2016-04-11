package partOne;
import java.util.ArrayList;

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
}
