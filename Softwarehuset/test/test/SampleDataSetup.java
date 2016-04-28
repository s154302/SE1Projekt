package test;

//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
//import org.junit.Test;

import code.Employee;
import code.Model;
import code.NonProjectActivity;
import code.Project;

public class SampleDataSetup {
	Model model;


	@Before
	public void setUp() throws Exception {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		ArrayList<Project> projectList = new ArrayList<Project>();
		ArrayList<NonProjectActivity> nonProjectActivityList = new ArrayList<NonProjectActivity>();
		
		for (int i = 1; i <= 50; i++) {
			employeeList.add(new Employee("Employee" + i));
		}
		
		for (int i = 1; i <= 20; i++) {
			projectList.add(new Project("Project" + i, employeeList.get(i), 1 ,1 ,1, 1, 1, i));
		}
		
		int a=0;
		for (Project p : projectList) {
			for (int i = 1; i <= 5; i++) {
				p.createActivity("Activity" + i, i*3, employeeList.get(i+a));
			}
			a+=2;
		}
		
		for (int i = 1; i <= 5; i++) {
			projectList.get(1).createActivity("Activity" + i, i*3, employeeList.get(i));
		}
		
		nonProjectActivityList.add(new NonProjectActivity());
		
		model = new Model(employeeList, nonProjectActivityList, projectList);
		
	}

}