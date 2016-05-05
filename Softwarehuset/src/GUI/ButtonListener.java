package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;

import code.Employee;
import code.Model;
import code.OperationNotAllowedException;

public class ButtonListener implements ActionListener, ItemListener {

	private Model model;
	private CreateProjectFrame cPF;
	private Frame frame;

	public ButtonListener(Model model, Frame f) {
		this.model = model;
		this.frame = f;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();

		switch (actionCommand) {
		case "Create Project":
			this.cPF = new CreateProjectFrame(model, this);
			System.out.println(cPF.getTitle());
			break;

		case "Confirm":
			
			int sD = Integer.parseInt(this.cPF.getCreateProjectPanel().startDay.getSelectedItem().toString());
			int sM = Integer.parseInt(this.cPF.getCreateProjectPanel().startMonth.getSelectedItem().toString());
			int sY = Integer.parseInt(this.cPF.getCreateProjectPanel().startYear.getSelectedItem().toString());
			
			int eD = Integer.parseInt(this.cPF.getCreateProjectPanel().endDay.getSelectedItem().toString());
			int eM = Integer.parseInt(this.cPF.getCreateProjectPanel().endMonth.getSelectedItem().toString());
			int eY = Integer.parseInt(this.cPF.getCreateProjectPanel().endYear.getSelectedItem().toString());
			
			String pM = this.cPF.getCreateProjectPanel().employees.getSelectedItem().toString();
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
				frame.getProjectPanel().updateList();
				frame.update();
				
			} catch (OperationNotAllowedException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
			this.cPF.setVisible(false);
			this.cPF.dispose();
			break;

		case "Cancel":
			
			this.cPF.setVisible(false);
			this.cPF.dispose();
			break;
			
		case "Edit Activity":
			
			break;
			
		case "Get Repport":
			
			break;

		case "Add Time":
			break;
			
		case "Absence":
			break;
			
		case "Create Activity":
			break;
		
		case "Login":
			frame.loggedInPanels();
			//save the employee.
			break;
			
		case "Employee List":
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

}