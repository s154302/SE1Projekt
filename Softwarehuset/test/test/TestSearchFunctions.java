package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import code.Activity;
import code.Employee;
import code.Model;
import code.OperationNotAllowedException;
import code.Project;

public class TestSearchFunctions {
	@Test
	public void testSearchActivities() throws OperationNotAllowedException{
		Employee e1 = new Employee("Alexss");
		Project project = new Project("Test", e1, 0, 0, 0, 0, 0, 0);
		project.createActivity("sjov", 2, e1);
		project.createActivity("sjov1", 2, e1);
		project.createActivity("sjov2", 2, e1);
		project.createActivity("sjov3", 2, e1);
		assertEquals(project.activityList.size(),4);
		Activity a1 = project.activityList.get(0);
		assertEquals(project.searchActivity("sjov"),a1);
		assertNotEquals(project.searchActivity("sjov3"),a1);
		assertEquals(project.searchActivity("sjasdv"),null);
	}
	@Test
	public void testSearchProjects() throws OperationNotAllowedException{
		Model model = new Model();
		model.createProject("test1", null, 0, 0, 0, 0, 0, 0);
		model.createProject("test2", null, 0, 0, 0, 0, 0, 0);
		Project p = model.projectList.get(0);
		Project p2 = model.projectList.get(1);
		assertEquals(model.searchProject(p.getSerialNumber()),p);
		assertNotEquals(model.searchProject(p2.getSerialNumber()),p);
		assertEquals(model.searchProject("sjasdv"),null);
	}

}
