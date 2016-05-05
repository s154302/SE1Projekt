package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import code.Model;
import code.OperationNotAllowedException;

public class TestCreateProjectRaport {

	Model model = new Model();
	
	@Test
	public void test() throws OperationNotAllowedException, FileNotFoundException, UnsupportedEncodingException {
		model.createProject(null, null, 0, 0, 0, 0, 0, 0);
		model.reportProject(model.projectList.get(0));
		File file = new File("Report for "+model.projectList.get(0).getName());
		assertTrue(file.exists());
	}

}
