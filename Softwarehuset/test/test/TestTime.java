package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Activity;
import code.Employee;
import code.OperationNotAllowedException;
import code.TimeManager;

public class TestTime {

	@Test
	public void testAddandGetTime() throws Exception {
		Employee A = new Employee("A");
		Employee B = new Employee("B");
		List<Employee> e = new ArrayList<>();
		e.add(A);
		Activity a = new Activity("a", 0, B);
		a.addEmployee(e);
		
		TimeManager t = a.getTimeManager();
		assertTrue(t.containsKey(A));
		assertEquals(0.0, t.getTime(A), 0.0);
		
		t.addTime(A, 2.0);
		
		assertEquals(2.0, t.getTime(A), 0.0);
	}
	
	

}
