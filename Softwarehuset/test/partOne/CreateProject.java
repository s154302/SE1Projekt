package partOne;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

//import junit.framework.Assert;


// USER STORY 1:
//Softwarehuset har faet en opgave fra DTU, som skal være færdig om d.
//10. Marts 2018. Hertil skal der oprettes et projekt ved navn, 'DTU - campusNet',
//og det skal starte omkring et ar fra afleveringsdatoen.
public class CreateProject extends SampleDataSetup{

	@Test
	public void testCreateProject() {
		
		assertEquals(20, model.projectList.size());
		Employee e1 = new Employee("Hans");
		
		model.createProject("DTU - CampusNet", e1);
		
		assertEquals(21, model.projectList.size());
		
		
	}

}
