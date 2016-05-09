package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;
import code.Project;

public class TestCreateActivity {
	//Model model = new Model();
	
	// Tests the createActivity method while using a project manager account.
	@Test
	public void testCreateActivity() throws OperationNotAllowedException {
		
		Employee e = new Employee("Alexander");
		Employee e2 = new Employee ("Simon");
		Employee e3 = new Employee("Mathias");
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e2);
		eList.add(e3);
		String pName = "Coding"; 
		Project p = new Project(pName,e, 2017, 12, 12, 2017, 12, 13);

		String aName = "Refactoring";
		int expectedWorkload = 5;

		assertEquals(e, p.getProjectManager());

		p.createActivity(aName, expectedWorkload, e);
		
		p.activityList.get(0).addEmployee(eList);
		assertEquals(1, p.activityList.size());
		assertEquals(aName, p.activityList.get(0).getName());
		assertEquals(expectedWorkload, p.activityList.get(0).getExpectedWorkload());
		assertTrue(p.activityList.get(0).isProjectManager(e));
		assertFalse(p.activityList.get(0).isProjectManager(e2));
		assertEquals(2, p.activityList.get(0).employeeList.size());
		//Employee e4 = p.activityList.get(0).employeeList.get(0);
		p.activityList.get(0).removeEmployee(p.activityList.get(0).employeeList.get(0));
		assertEquals(1, p.activityList.get(0).employeeList.size());
		assertEquals(1, p.activityList.get(0).employeeList.get(0).activityList.size());
		//assertEquals(0, e4.activityList);
		
	}

	// Testing the createActivity method while not a project manager.
	@Test
	public void testCreateActivityNotManager() throws OperationNotAllowedException {
		String eName1 = "Alexander";
		Employee e1 = new Employee(eName1);
		String eName2 = "Emilie";
		Employee e2 = new Employee(eName2);

		String pName = "Coding";
		Project p = new Project(pName, e1, 2017, 12, 12, 2017, 12, 13);

		assertEquals(p.getProjectManager(), e1);

		String aName = "Refactoring";
		int expectedWorkload = 5;
		
		try {
			p.createActivity(aName, expectedWorkload, e2);
			fail("An OperationNotAllowedException should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Create activity operation not allowed if not project manager.", e.getMessage());
			assertEquals("Create activity", e.getOperation());
		}

	}
	
	@Test
	public void testTooManyActivities() throws OperationNotAllowedException{
		Employee e1 = new Employee("Alexander");
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		String pName = "Coding";
		Project p = new Project(pName, e1, 2017, 12, 12, 2017, 12, 13);

		for(int i = 0; i<21; i++){
			p.createActivity("Refactoring" +i, 5, e1);
		}
		for(int i = 0;i<p.activityList.size(); i++){
			p.activityList.get(i).addEmployee(eList);
		}
	}
	@Test
	public void expectedWorkloadZero() throws OperationNotAllowedException{
		Employee e1 = new Employee("Alexander");
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		Project p = new Project("testProject", e1, 2017, 12, 12, 2017, 12, 13);
		try{
			p.createActivity("testActivity", 0, e1);
			fail("An OperationNotAllowedException should have been thrown.");
		}
		catch (OperationNotAllowedException e){
			assertEquals("You must enter an expected workload.", e.getMessage());
		}
		
		
	}
	@Test
	public void noActivityName() throws OperationNotAllowedException{
		Employee e1 = new Employee("Alexander");
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		Project p = new Project("testProject", e1, 2017, 12, 12, 2017, 12, 13);
		try{
			p.createActivity("", 1, e1);
			fail("An OperationNotAllowedException should have been thrown.");
		}
		catch (OperationNotAllowedException e){
			assertEquals("You must enter a name.", e.getMessage());
			assertEquals(null, e.getOperation());
		}
		
		
	}

}
