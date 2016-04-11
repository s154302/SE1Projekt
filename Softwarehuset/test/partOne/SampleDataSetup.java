package partOne;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SampleDataSetup {

	@Before
	public void setUp() throws Exception {
		List<Employee> employeeList = new ArrayList<Employee>();
		List<Project> projectList = new ArrayList<Project>();
		List<Activity> activityList = new ArrayList<Activity>();
		
		for (int i = 1; i <= 50; i++) {
			employeeList.add(new Employee("Employee" + i));
		}
		
		for (int i = 1; i <= 20; i++) {
			projectList.add(new Project("Project" + i));
		}
		
		for (Project p : projectList) {
			for (int i = 1; i <= 10; i++) {
				p.addActivity(new Activity("Activity" + i));
			}
		}
		
	}

}
