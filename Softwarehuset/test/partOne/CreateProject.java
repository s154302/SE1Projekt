package partOne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class CreateProject {

	@Test
	public void testCreateProject() {
		// list of employees
		Employee e1 = new Employee(); 
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		
		ArrayList<NonProjectActivity> nonProjectActivityList = new ArrayList<NonProjectActivity>();
		
		ArrayList<Project> projectList = new ArrayList<Project>();
		
		Model model = new Model(employeeList, nonProjectActivityList, projectList);
		
		
	}

}
