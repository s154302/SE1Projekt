package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonProjectActivity {

	private String name;
	private TimeManager timeManager;

	private List<Employee> employeeList;
	
	public NonProjectActivity(String name) {
		employeeList = new ArrayList<Employee>();
		this.name = name;
		timeManager = new TimeManager(this);
	}

	// Adds an employee to the activity's employee list and sorts it.
	public void addEmployee(List<Employee> employees) {
		
		for(Employee employee: employees){
			employeeList.add(employee);
		}
		System.out.println(employees.size());
		timeManager.addEmployees(employees);
		Collections.sort(this.employeeList);
		
	}
	
	// Removes an employee from the activity's employee list and sorts it
	public void removeEmployee (Employee employee){
		employeeList.remove(employee);
		Collections.sort(employeeList);
	}
	
	public String getName (){
		return name;
	}
	
	public TimeManager getTimeManager(){
		return timeManager;
	}
	
	public List<Employee> getEmployeeList(){
		return employeeList;
	}
}
