<<<<<<< HEAD

package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;

public class TestEditProject {

	Model model = new Model();
	
	//Test for all the setters in project
	@Test
	public void testSetProject() throws OperationNotAllowedException {
		model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		Employee e1 = new Employee("Hans");
		int startYear = 2016;
		int startMonth = 5;
		int startDay = 2;
		int endYear = 2017;
		int endMonth = 6;
		int endDay = 3;
		
		model.projectList.get(0).setName("Softwarehuset");
		model.projectList.get(0).setProjectManager(e1);
		model.projectList.get(0).setStartDate(startYear, startMonth, startDay);
		model.projectList.get(0).setEndDate(endYear, endMonth, endDay);
		
		assertEquals("Softwarehuset",model.projectList.get(0).getName());
		assertEquals(e1,model.projectList.get(0).getProjectManager());
		assertEquals(LocalDate.of(startYear, startMonth, startDay),model.projectList.get(0).getStartDate());
		assertEquals(LocalDate.of(endYear, endMonth, endDay),model.projectList.get(0).getEndDate());	
	}
	
	//Test for removing project
	@Test
	public void testRemoveProject() throws OperationNotAllowedException {
		for(int i =0; i<10; i++){
			model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		}
		assertEquals(10, model.projectList.size());
		
		model.removeProject(model.projectList().get(5));
		
		assertEquals(9, model.projectList.size());
	}
}
=======

package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;

public class TestEditProject {

	Model model = new Model();
	
	//Test for all the setters in project
	@Test
	public void testSetProject() throws OperationNotAllowedException {
		model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		Employee e1 = new Employee("Hans");
		int startYear = 2016;
		int startMonth = 5;
		int startDay = 2;
		int endYear = 2017;
		int endMonth = 6;
		int endDay = 3;
		
		model.projectList.get(0).setName("Softwarehuset");
		model.projectList.get(0).setProjectManager(e1);
		model.projectList.get(0).setStartDate(startYear, startMonth, startDay);
		model.projectList.get(0).setEndDate(endYear, endMonth, endDay);
		
		assertEquals("Softwarehuset",model.projectList.get(0).getName());
		assertEquals(e1,model.projectList.get(0).getProjectManager());
		assertEquals(LocalDate.of(startYear, startMonth, startDay),model.projectList.get(0).getStartDate());
		assertEquals(LocalDate.of(endYear, endMonth, endDay),model.projectList.get(0).getEndDate());	
	}
	
	//Test for removing project
	@Test
	public void testRemoveProject() throws OperationNotAllowedException {
		for(int i =0; i<10; i++){
			model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		}
		assertEquals(10, model.projectList.size());
		
		model.removeProject(model.projectList().get(5));
		
		assertEquals(9, model.projectList.size());
	}
}
>>>>>>> Emilie
