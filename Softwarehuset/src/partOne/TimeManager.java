package partOne;

import java.util.HashMap;
import java.util.List;

public class TimeManager {
	private HashMap<Employee, Double> employeeTimeList = new HashMap<Employee, Double>();;

	public TimeManager(List<Employee> employees) {

		for (Employee e : employees) {
			this.employeeTimeList.put(e, 0.0);
		}
	}

	// Adds the specified work to an employees completed workload.
	public void addTime(Employee employee, double hours) {
		Double time = this.employeeTimeList.get(employee);
		this.employeeTimeList.put(employee, time + hours);
	}

	// Return the amount of hours an employee has worked.
	public double getTime(Employee employee) {
		return this.employeeTimeList.get(employee);
	}

}
