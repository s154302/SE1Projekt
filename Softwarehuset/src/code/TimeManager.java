package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeManager {
	private HashMap<Employee, Double> employeeTimeList = new HashMap<Employee, Double>();
	private Activity a;
	private NonProjectActivity nA;
	private List<Employee> employees;

	public TimeManager(Activity a) {
		this.a = a;
		employees = new ArrayList<Employee>();
	}
	
	public TimeManager(NonProjectActivity nA) {
		this.nA = nA;
		employees = new ArrayList<Employee>();
	}

	// Adds the specified work to an employees completed workload.
	public void addTime(Employee employee, double hours) {
		if (employeeTimeList.containsKey(employee) && employee != null) {
			Double time = this.employeeTimeList.get(employee);
			this.employeeTimeList.put(employee, time + hours);
		} else if (employee != null) {
			this.employeeTimeList.put(employee, 0.0);
			employees.add(employee);
			if(a != null) {
				a.addEmployee(employees);
			} else if(nA != null) {
				nA.addEmployee(employees);
			}
			addTime(employee, hours);
		}
	}

	// Return the amount of hours an employee has worked.
	public double getTime(Employee employee) {
		return this.employeeTimeList.get(employee);
	}

	// Adds a list of employees to the TimeManager.
	public void addEmployees(List<Employee> employees) {
		for (Employee e : employees) {
			this.employeeTimeList.put(e, 0.0);
		}
	}

	public boolean containsKey(Employee e) {
		return this.employeeTimeList.containsKey(e);
	}
}
