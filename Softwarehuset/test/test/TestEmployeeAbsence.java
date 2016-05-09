package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Employee;
import code.Model;
import code.NonProjectActivity;

public class TestEmployeeAbsence {
	
	Model model = new Model();

	@Test
	public void test() {

		
		assertEquals(4, model.nonProjectActivityList.size());
		
		NonProjectActivity nonProjectActivity = model.nonProjectActivityList.get(0);
		assertEquals("Courses",nonProjectActivity.getName());
		
		model.createEmployee("Alexander");
		Employee employee = model.employeeList.get(0);
		List<Employee> elist = new ArrayList<Employee>();
		elist.add(employee);
		
		
		nonProjectActivity.addEmployee(elist);
		assertEquals(1, nonProjectActivity.getEmployeeList().size());
		
		nonProjectActivity.getTimeManager().addTime(employee, 5);
		assertEquals(5.0, nonProjectActivity.getTimeManager().getTime(employee), 0.1);
		
		nonProjectActivity.removeEmployee(employee);
		assertEquals(0, nonProjectActivity.getEmployeeList().size());
	}

}
