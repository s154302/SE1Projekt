package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Model {
	public ArrayList<Employee> employeeList;
	public ArrayList<NonProjectActivity> nonProjectActivityList;
	public ArrayList<Project> projectList;
	private Employee currentEmployee;
	
	private int counter = 0;

	public Model() {
		this.projectList = new ArrayList<Project>();
		this.nonProjectActivityList = new ArrayList<NonProjectActivity>();
		this.employeeList = new ArrayList<Employee>();
	}

	// Creates a new employee and adds it to the employee list.
	public void createEmployee(String name) {
		this.employeeList.add(new Employee(name));
		Collections.sort(this.employeeList);
	}

	// Creates a new project and adds it to the project list.

	public void createProject(String name, Employee projectManager, int startYear, int startMonth, int startDayOfMonth,
			int endYear, int endMonth, int endDayOfMonth) throws OperationNotAllowedException {
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

		yString = String.valueOf(y).substring(2, 4);

		return counter() + "-" + dString + mString + yString;
	}
	
	public String counter() {
		this.counter++;
		String counterString;
		if(this.counter>9999 ){
			counter = 1;
		}
		if(this.counter > 999) {
			counterString = String.valueOf(this.counter);
		} else if(this.counter > 99) {
			counterString = "0" + this.counter;
		} else if(this.counter > 9) {
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
	
	public void setCurrentEmployee(Employee employee){
		currentEmployee = employee;
	}
	
	public Employee searchEmployee(String name){
		
		for (Employee employee : employeeList){
			if (name.equals(employee.getName())){
				return employee;
			}
		}
		
		return null;
	}
	
	public Employee getCurrentEmployee (){
		return currentEmployee;
	}
	
	//Creates a .txt file which contains info about a given project
	public void reportProject(Project project) throws FileNotFoundException, UnsupportedEncodingException {
		double totalProjectWorkload =0;
		double completedProjectWorkload = 0;
		double remainingProjectWorkload = 0;
		//System.out.println(project.getName());
		PrintWriter write = new PrintWriter("Report for " + project.getName(),"UTF-8");
		write.println(project.getSerialNumber()+" "+project.getName() + "- Data extracted " + LocalTime.now());
		
		for (Activity activity : project.activityList){
			totalProjectWorkload = totalProjectWorkload + activity.getExpectedWorkload();
			
			for(Employee employee : activity.employeeList){
				completedProjectWorkload = completedProjectWorkload + activity.getTimeManager().getTime(employee);
			}
		}
		remainingProjectWorkload = totalProjectWorkload - completedProjectWorkload;
		write.println("Total Expected workload: " + totalProjectWorkload + ", Completed workload: " 
				+ completedProjectWorkload + ", Remaining workload: " + remainingProjectWorkload);
		write.println();
		write.println("Activities");
		
		for (Activity activity : project.activityList){
			double activityExpectedWorkload = activity.getExpectedWorkload();
			double activityCompletedWorkload = 0;
			double activityRemainingWorkload = 0;
			
			for (Employee employee : activity.employeeList){
				activityCompletedWorkload = activityCompletedWorkload + activity.getTimeManager().getTime(employee);
			}
			activityRemainingWorkload = activityExpectedWorkload - activityCompletedWorkload;
			write.println(activity.getName() + " Expected workload: " + activityExpectedWorkload 
					+ ", Completed workload: " + activityCompletedWorkload + ", Remaining workload: " + activityRemainingWorkload);
		}
		write.close();
	}

	public Project searchProject(String string) {
		// TODO Auto-generated method stub
		for(int i =0; i<projectList.size();i++){
			if(string.equals(projectList.get(i).getSerialNumber())){
				return projectList.get(i);
			}
		}
		System.out.println("ingen project");
		return null;
	}
	
}
