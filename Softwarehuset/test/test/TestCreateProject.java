package test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

import code.Employee;
import code.Model;

// USER STORY 1:
//Softwarehuset har faet en opgave fra DTU, som skal være færdig om d.
//10. Marts 2018. Hertil skal der oprettes et projekt ved navn, 'DTU - campusNet',
//og det skal starte omkring et ar fra afleveringsdatoen.
public class TestCreateProject {
	
	Model model = new Model();
	
	@Test
	//Test without parameters
	public void testCreateProjectEmpty(){
		model.createProject(null, null, 1994, 01, 27, 1994, 01, 27);
		
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(0, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Project with name parameter
	public void testCreateProjectName(){
		String name = "softwareProject";
		
		model.createProject(name, null, 1994, 01, 27, 1994, 01, 27);
		
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(0, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Test with project manager parameter
	public void testCreateProjectManager(){
		Employee e1 = new Employee("Hans"); 
		
		model.createProject(null, e1, 1994, 01, 27, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
		assertEquals(0, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Test with startDate
	public void testCreateProjectStartDate(){
		int startYear = 2016;
		int startMonth = 04;
		int startDay = 25;
		LocalDate testDate = LocalDate.of(startYear, startMonth, startDay);
		
		
		model.createProject(null, null, startYear, startMonth, startDay, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(testDate, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Test with endDate
	public void testCreateProjectEndDate(){
		int endYear = 2016;
		int endMonth = 04;
		int endDay = 25;
		LocalDate testDate = LocalDate.of(endYear, endMonth, endDay);
		
		
		model.createProject(null, null, 0, 0, 0, endYear, endMonth, endDay);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(testDate, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Test with name and project manager parameter
	public void testCreateProjectNameManager(){
		Employee e1 = new Employee("Hans"); 
		String name = "softwareProject";
		
		model.createProject(name, e1, 1994, 01, 27, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
		assertEquals(null, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//test with name and startDate
	public void testCreateProjectNameStartDate(){
		String name = "Softwarehuset";
		int startYear = 2016;
		int startMonth = 04;
		int startDay = 25;
		LocalDate testDate = LocalDate.of(startYear, startMonth, startDay);
		
		
		model.createProject(name, null, startYear, startMonth, startDay, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(null, model.projectList.get(0).getProjectManager());
		assertEquals(testDate, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//test with project manager and startDate
	public void testCreateProjectManagerStartDate(){
		Employee e1 = new Employee("Hans");
		int startYear = 2016;
		int startMonth = 04;
		int startDay = 25;
		LocalDate testDate = LocalDate.of(startYear, startMonth, startDay);
		
		
		model.createProject(null, e1, startYear, startMonth, startDay, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(null,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
		assertEquals(testDate, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
	
	@Test
	//Test with name, project manager and startDate	
	public void testCreateProjectNameManagerStartDate(){
		String name = "Softwarehuset";
		Employee e1 = new Employee("Hans");
		int startYear = 2016;
		int startMonth = 04;
		int startDay = 25;
		LocalDate testDate = LocalDate.of(startYear, startMonth, startDay);
		
		
		
		model.createProject(null, e1, startYear, startMonth, startDay, 1994, 01, 27);
		assertEquals(1,model.projectList.size());
		//assertEquals(0,model.projectList.get(0).getSerialNumber());
		assertEquals(name,model.projectList.get(0).getName());
		assertEquals(e1, model.projectList.get(0).getProjectManager());
		assertEquals(testDate, model.projectList.get(0).getStartDate());
		assertEquals(0, model.projectList.get(0).getEndDate());
	}
}