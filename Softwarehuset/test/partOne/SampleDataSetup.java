package partOne;

//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
//import org.junit.Test;

public class SampleDataSetup {
	Model model = new Model();


	@Before
	public void setUp() throws Exception {
		List<Employee> employeeList = new ArrayList<Employee>();
		List<Project> projectList = new ArrayList<Project>();
		List<NonProjectActivity> nonProjectActivityList = new ArrayList<NonProjectActivity>();
		
		for (int i = 1; i <= 50; i++) {
			employeeList.add(new Employee("Employee" + i));
		}
		
		for (int i = 1; i <= 20; i++) {
			projectList.add(new Project("Project" + i));
		}
		
//		int a=0;
//		for (Project p : projectList) {
//			for (int i = 1; i <= 5; i++) {
//				p.createActivity("Activity" + i, i*3, employeeList.get(i+a));
//			}
//			a+=2;
//		}
		
		for (int i = 1; i <= 5; i++) {
			projectList.get(1).createActivity("Activity" + i, i*3, employeeList.get(i));
		}
		
		nonProjectActivityList.add(new NonProjectActivity());
		
		model.add(employeeList, nonProjectActivityList, projectList);
		
	}

}
