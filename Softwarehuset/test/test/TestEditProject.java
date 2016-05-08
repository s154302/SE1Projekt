package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import code.Activity;
import code.Employee;
import code.Model;
import code.OperationNotAllowedException;
import code.Project;

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
		Employee e1 = new Employee("Mathias");
		for(int i =0; i<10; i++){
			model.createProject(null, e1, 0, 0, 0, 0, 0, 0);
		}
		model.projectList.get(5).createActivity("testActivity1", 5, e1);
		model.projectList.get(5).createActivity("testActivity2", 5, e1);
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		model.projectList.get(5).activityList.get(0).addEmployee(eList);
		model.projectList.get(5).activityList.get(1).addEmployee(eList);
		assertEquals(10, model.projectList.size());
		
		model.deleteProject(model.projectList().get(5));
		
		assertEquals(9, model.projectList.size());
	}
	
	@Test
	public void testRemoveProjectWhenStarted() throws OperationNotAllowedException{
		model.createEmployee("Simon");
		model.setCurrentEmployee(model.employeeList.get(0));
		model.createProject("testProject", model.getCurrentEmployee(), 0, 0, 0, 0, 0, 0);
		model.projectList.get(0).createActivity("testActivity1", 5, model.getCurrentEmployee());
		model.projectList.get(0).createActivity("testActivity2", 5, model.getCurrentEmployee());
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(model.getCurrentEmployee());
		model.projectList.get(0).activityList.get(0).addEmployee(eList);
		model.projectList.get(0).activityList.get(1).addEmployee(eList);
		model.projectList.get(0).activityList.get(0).getTimeManager().addTime(model.getCurrentEmployee(), 2.0);
		assertEquals(1, model.projectList.size());
		
		model.deleteProject(model.projectList().get(0));
		
		assertEquals(1, model.projectList.size());
		
		//test if u can delete the activity without time
		assertEquals(2, model.projectList.get(0).activityList.size());
		model.projectList.get(0).deleteActivity(model.projectList.get(0).activityList.get(1));
		assertEquals(1, model.projectList.get(0).activityList.size());
		
		
		//test if u can delete started activity
		assertEquals(1, model.projectList.get(0).activityList.size());
		model.projectList.get(0).deleteActivity(model.projectList.get(0).activityList.get(0));
		assertEquals(1, model.projectList.get(0).activityList.size());
		
	}
	@Test
	public void testProjectManager() throws OperationNotAllowedException{
		Employee e1 = new Employee("Simon");
		Employee e2 = new Employee("Alexss");
		Project project = new Project("Test", e1, 0, 0, 0, 0, 0, 0);
		assertTrue(project.isProjectManager(e1));
		assertFalse(project.isProjectManager(e2));
	}

}