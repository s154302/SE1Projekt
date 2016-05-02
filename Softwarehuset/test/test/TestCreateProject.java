package test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;

public class TestCreateProject {
	
	Model model = new Model();
	
	//Test without parameters
	@Test
	public void testCreateProjectEmpty() throws OperationNotAllowedException{

		model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		
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
		
		assertEquals(1,model.projectList.size());
		assertEquals("0001-"+dString+mString+yString,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(null, model.projectList.get(0).getStartDate());
		assertEquals(null, model.projectList.get(0).getEndDate());
	}
	
	//Project with all parameters
	@Test
	public void testCreateProjectFull() throws OperationNotAllowedException{
		String name = "Softwarehuset";
		model.createEmployee("Hans");
		Employee e1 = model.employeeList.get(0);
		int startYear = 2016;
		int startMonth = 5;
		int startDay = 2;
		int endYear = 2017;
		int endMonth = 5;
		int endDay = 2;
			
		model.createProject(name, e1, startYear, startMonth, startDay, endYear, endMonth, endDay);
		
		LocalDate startTestDate = LocalDate.of(startYear, startMonth, startDay);
		LocalDate endTestDate = LocalDate.of(endYear, endMonth, endDay);
		
		
		assertEquals(1,model.projectList.size());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
		assertEquals(startTestDate, model.projectList.get(0).getStartDate());
		assertEquals(endTestDate, model.projectList.get(0).getEndDate());
	}
	
	//test for creating multiply projects
	@Test
	public void testCreateProjectMultiply() throws OperationNotAllowedException {
		
		for(int i=0; i<10000; i++){
			model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		}
		
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
		
		assertEquals(10000,model.projectList.size());
		assertEquals("0001-"+dString+mString+yString,model.projectList.get(0).getSerialNumber());
		assertEquals("0011-"+dString+mString+yString,model.projectList.get(10).getSerialNumber());
		assertEquals("0051-"+dString+mString+yString,model.projectList.get(50).getSerialNumber());
		assertEquals("9999-"+dString+mString+yString,model.projectList.get(9998).getSerialNumber());
		assertEquals("0001-"+dString+mString+yString,model.projectList.get(9999).getSerialNumber());
	}
	
	//Edge case for the start & end date
	@Test
	public void testCreateProjectDates() throws OperationNotAllowedException{
		
		//Check if start date is after end date
		try {
			model.createProject(null, null, 2016, 05, 02, 2015, 01, 01);
			fail("An OperationNotAllowedException should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Create project not allowed if start date is after end date.", e.getMessage());
			assertEquals("Create project", e.getOperation());
		}
		
		//Check if end date is before today
		try {
			model.createProject(null, null, 0, 0, 0, 2015, 01, 01);
			fail("An OperationNotAllowedException should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Create project not allowed if start date is after end date.", e.getMessage());
			assertEquals("Create project", e.getOperation());
		}
		
		//Check if start date is before today
		try {
			model.createProject(null, null, 2015, 05, 02, 0, 0, 0);
			fail("An OperationNotAllowedException should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Create project not allowed if start date is after end date.", e.getMessage());
			assertEquals("Create project", e.getOperation());
		}
		
		//Check if both start and end date is before today
		try {
			model.createProject(null, null, 2015, 05, 02, 2015, 01, 01);
			fail("An OperationNotAllowedException should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Create project not allowed if start date is after end date.", e.getMessage());
			assertEquals("Create project", e.getOperation());
		}
	}

	
	//Test for removing employee
	@Test
	public void testRemoveEmployee(){
		for(int i =0; i<10; i++){
			model.createEmployee(null);
		}
		
		assertEquals(10,model.employeeList.size());
		model.removeEmployee(model.employeeList.get(4));
		assertEquals(9,model.employeeList.size());
	}
	
}