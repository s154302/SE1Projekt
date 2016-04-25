package partOne;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// USER STORY 1:
//Softwarehuset har faet en opgave fra DTU, som skal være færdig om d.
//10. Marts 2018. Hertil skal der oprettes et projekt ved navn, 'DTU - campusNet',
//og det skal starte omkring et ar fra afleveringsdatoen.
public class TestCreateProject {
	
	Model model = new Model();
	
	@Test
	//Test without parameters
	public void testCreateProjectEmpty(){
		model.createProject(null, null, 0);
		
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
//		assertEquals(0, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//Project with name parameter
	public void testCreateProjectName(){
		String name = "softwareProject";
		
		model.createProject(name, null, 0);
		
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
//		assertEquals(0, model.projectList.get(0).getStartDate());
		
	}
	
	@Test
	//Test with project manager parameter
	public void testCreateProjectManager(){
		Employee e1 = new Employee("Hans"); 
		
		model.createProject(null, e1, 0);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
//		assertEquals(0, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//Test with startDate
	public void testCreateProjectStartDate(){
		int date = 42;
		
		model.createProject(null, null, date);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
//		assertEquals(date, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//Test with name and project manager parameter
	public void testCreateProjectNameManager(){
		Employee e1 = new Employee("Hans"); 
		String name = "softwareProject";
		
		model.createProject(name, e1, 0);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
//		assertEquals(null, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//test with name and startDate
	public void testCreateProjectNameStartDate(){
		String name = "Softwarehuset";
		int date = 42;
		
		model.createProject(name, null, 0);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
//		assertEquals(date, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//test with project manager and startDate
	public void testCreateProjectManagerStartDate(){
		Employee e1 = new Employee("Hans");
		int date = 42;
		
		model.createProject(null, e1, date);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
//		assertEquals(date, model.projectList.get(0).getStartDate());
	}
	
	@Test
	//Test with name, project manager and startDate	
	public void testCreateProjectNameManagerStartDate(){
		String name = "Softwarehuset";
		Employee e1 = new Employee("Hans");
		int date = 42;
		
		model.createProject(null, e1, date);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
//		assertEquals(date, model.projectList.get(0).getStartDate());
	}
}