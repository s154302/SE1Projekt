package partOne;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCreateActivity {

	// Tests the createActivity method while using a project manager account.
	@Test
	public void testCreateActivity() throws OperationNotAllowedException {

		String eName = "Alexander";
		Employee e = new Employee(eName);

		String pName = "Coding";
		Project p = new Project(pName, e);

		String aName = "Refactoring";
		int expectedWorkload = 5;

		assertEquals(e, p.getProjectManger());

		p.createActivity(aName, expectedWorkload, e);

		assertEquals(1, p.activityList.size());
		assertEquals(aName, p.activityList.get(0).getName());
		assertEquals(expectedWorkload, p.activityList.get(0).getExpectedWorkload());
		assertTrue(p.activityList.get(0).isProjectManager(e));
	}

	// Testing the createActivity method while not a project manager.
	@Test
	public void testCreateActivityNotManager() {
		String eName1 = "Alexander";
		Employee e1 = new Employee(eName1);
		String eName2 = "Emilie";
		Employee e2 = new Employee(eName2);

		String pName = "Coding";
		Project p = new Project(pName, e1);

		assertEquals(p.getProjectManger(), e1);

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

}
