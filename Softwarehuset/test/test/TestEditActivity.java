package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Activity;
import code.Employee;
import code.OperationNotAllowedException;
import code.Project;

public class TestEditActivity{

	@Test
	public void testEditActivity() throws OperationNotAllowedException {
		Employee e = new Employee("Alexander");

		String pName = "Coding";
		Project p = new Project(pName,e, 2017, 12, 12, 2017, 12, 13);

		String aName = "Refactoring";
		int expectedWorkload = 5;

		assertEquals(e, p.getProjectManager());

		p.createActivity(aName, expectedWorkload, e);
		int testInt = 10;
		String testName = "testName";
		p.activityList.get(0).setExpectedWorkload(testInt);
		p.activityList.get(0).setName(testName);
		assertEquals(testInt, p.activityList.get(0).getExpectedWorkload());
		assertEquals(testName, p.activityList.get(0).getName());
		p.activityList.get(0).setMessage("Testmessage");
		assertEquals("Testmessage", p.activityList.get(0).getMessageText());
	}
	
	@Test
	public void removeEmployeeWithTime() throws Exception{
		Employee e1 = new Employee("Alexander");
		Employee e2 = new Employee("Simon");
		Activity a = new Activity("test", 3, e1);
		
		a.getTimeManager().addTime(e2, 3);
		
		try {
			a.removeEmployee(e2);
			fail("An Exception should have been thrown.");
		} catch (OperationNotAllowedException e) {
			assertEquals("Cannot remove an employee with completed hours.", e.getMessage());
		}
	}

}