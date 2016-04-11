package partOne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
//Softwarehuset har faet en opgave fra DTU, som skal være færdig om d.
//10. Marts 2018. Hertil skal der oprettes et projekt ved navn, 'DTU - campusNet',
//og det skal starte omkring et ar fra afleveringsdatoen.
public class CreateProject {

	@Test
	public void testCreateProject() {
		// list of employees
		Employee e1 = new Employee(); 
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		
		//list of nonprojects
		ArrayList<NonProjectActivity> nonProjectActivityList = new ArrayList<NonProjectActivity>();
		
		//Time
		TimeManager time = new TimeManager();
		
		//list of projects
		ArrayList<Project> projectList = new ArrayList<Project>();
		
		Model model = new Model(employeeList, nonProjectActivityList, projectList);
		
		assertEquals(model.projectList, null);

		
		model.createProject("DTU - campusNet", dateStart, dateFinish);
		
		Assert.assertNotNull(model.projectList);
		
	}

}
