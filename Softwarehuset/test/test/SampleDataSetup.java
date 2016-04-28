package test;

//import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
//import org.junit.Test;

import code.Employee;
import code.Model;
import code.NonProjectActivity;
import code.Project;

public class SampleDataSetup {
	Model model = new Model();

	@Before
	public void setUp() throws Exception {
		model.employeeList = new ArrayList<Employee>();
		model.projectList = new ArrayList<Project>();
		model.nonProjectActivityList = new ArrayList<NonProjectActivity>();

		for (int i = 1; i <= 50; i++) {
			model.employeeList.add(new Employee("Employee" + i));
		}

		for (int i = 1; i <= 20; i++) {
			model.projectList.add(new Project("Project" + i, model.employeeList.get(i), 1, 1, 1, 1, 1, i));
		}

		int a = 0;
		for (Project p : model.projectList) {
			for (int i = 1; i <= 5; i++) {
				p.createActivity("Activity" + i, i * 3, model.employeeList.get(i + a));
			}
			a += 2;
		}

		for (int i = 1; i <= 5; i++) {
			model.projectList.get(1).createActivity("Activity" + i, i * 3, model.employeeList.get(i));
		}

		model.nonProjectActivityList.add(new NonProjectActivity());

		model = new Model(model.employeeList, model.nonProjectActivityList, model.projectList);

	}

}