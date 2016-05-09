package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Activity;
import code.Employee;
import code.NonProjectActivity;
import code.OperationNotAllowedException;
import code.TimeManager;

public class TestTime {

	@Test
	public void testAddandGetTime() throws Exception {
		Employee A = new Employee("A");
		Employee B = new Employee("B");
		Employee C = new Employee("C");
		
		//adding employee A to the employee list.
		List<Employee> e = new ArrayList<Employee>();
		e.add(A);
		
		//creating the activity
		Activity a = new Activity("a", 1, B);
		a.addEmployee(e);
		
		//making sure A has not added any time
		TimeManager t = a.getTimeManager();
		assertTrue(t.containsKey(A));
		assertEquals(0.0, t.getTime(A), 0.0);
		
		//adding time
		t.addTime(A, 2.0);
		assertEquals(2.0, t.getTime(A), 0.0);
		
		//an employee add time even if he is not added to the activity
		assertFalse(a.employeeList.contains(C));
		t.addTime(C, 5.5);
		assertEquals(5.5, t.getTime(C), 0.0);
		assertTrue(a.employeeList.contains(C));	
	}
	
	@Test
	public void addTimeNonProjectActivity() throws Exception {
		Employee A = new Employee("A");
		
		NonProjectActivity a = new NonProjectActivity("a");

		a.getTimeManager().addTime(A, 10);
		assertEquals(a.getTimeManager().getTime(A), 10, 0.0);
		
	}
	
	@Test
	public void testGuestAddTime() throws Exception {
		Employee e = null;
		Activity a = new Activity("a", 1, new Employee("C"));
		assertFalse(a.employeeList.contains(e));
		
		try{
			a.getTimeManager().addTime(e, 2.0);
			fail("Should have thrown an OperationNotAllowedException");
		} catch(OperationNotAllowedException e1) {
			assertEquals("Guests can't add time to an activity.",e1.getMessage());
		}
	}
	
	

}
