package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;

public class ButtonListener implements ActionListener, ItemListener {

	private Model model;
	private CreateProjectFrame cPF;
=======

import code.Model;

public class ButtonListener implements ActionListener {

	Model model;
>>>>>>> Emilie

	public ButtonListener(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD

		String actionCommand = e.getActionCommand();

		switch (actionCommand) {
		case "Create Project":
			this.cPF = new CreateProjectFrame(model, this);
			break;

		case "Confirm":
			int sD = (Integer) this.cPF.getCreateProjectPanel().startDay.getSelectedIndex();
			int sM = (Integer) this.cPF.getCreateProjectPanel().startMonth.getSelectedItem();
			int sY = (Integer) this.cPF.getCreateProjectPanel().startYear.getSelectedItem();
			
			int eD = (Integer) this.cPF.getCreateProjectPanel().endDay.getSelectedItem();
			int eM = (Integer) this.cPF.getCreateProjectPanel().endMonth.getSelectedItem();
			int eY = (Integer) this.cPF.getCreateProjectPanel().endYear.getSelectedItem();
			
			String pM = (String) this.cPF.getCreateProjectPanel().employees.getSelectedItem();
			Employee projectManager = null;
			
			for (Employee employee : model.employeeList) {
				if(pM.equals(employee.getName())) {
					projectManager = employee;
					break;
				}
			}
			
			String name = this.cPF.getCreateProjectPanel().name.getText();
			
			try {
				model.createProject(name, projectManager, sY, sM, sD, eY, eM, eD);
			} catch (OperationNotAllowedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Cancel":
			this.cPF.setVisible(false);
			this.cPF.dispose();
			break;

=======
		String actionCommand = e.getActionCommand();
		
		switch (actionCommand) {
		case "Create Project":
			CreateProjectFrame pF = new CreateProjectFrame(model);
			break;
			
		case "Confirm":

			break;

		case "Cancel":
			
			break;
			
>>>>>>> Emilie
		}

	}

<<<<<<< HEAD
	@Override
	public void itemStateChanged(ItemEvent e) {

	}

=======
>>>>>>> Emilie
}
