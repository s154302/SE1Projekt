package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;
import code.Project;

public class TestCreateProjectRaport {

	Model model = new Model();
	
	@Test
	public void test() throws OperationNotAllowedException, FileNotFoundException, UnsupportedEncodingException {
		model.createEmployee("Emilie");
		Employee employee = model.employeeList.get(0);
		model.createProject("Softwarehuset", employee, 0, 0, 0, 0, 0, 0);
		Project project = model.projectList.get(0);
		project.createActivity("Aktivity1", 10, employee);
		project.activityList.get(0).getTimeManager().addTime(employee, 6);
		File file = new File("Report for "+model.projectList.get(0).getName());
		assertTrue(file.exists());
	}

}
