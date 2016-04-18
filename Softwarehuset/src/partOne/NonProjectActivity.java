package partOne;

import java.util.ArrayList;
import java.util.List;

public class NonProjectActivity {
	
	private String name;
	private int expectedWorkload;
	private TimeManager timeManager;
	
	public List<Employee> employeeList;
	
	public NonProjectActivity() {
		
	}
	
	public void addEmployees(List<Employee> employees) {
		this.employeeList.addAll(employees);
	}
}
