package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
//		assertEquals(expectedWorkload, p.activityList.get(0).getExpectedWorkload());
//		assertTrue(p.activityList.get(0).isProjectManager(e));
	}

}