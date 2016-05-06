package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

import code.Activity;
import code.Employee;
import code.Model;
import code.OperationNotAllowedException;
import code.Project;

public class ButtonListener implements ActionListener, ItemListener {
	private boolean cPFOpen, cAFOpen, ePFOpen, eAFOpen;

	private Model model;
	private CreateProjectFrame cPF;
	private Frame frame;
	private CreateActivityFrame cAF;
	private Employee e1;

	private String employee;

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
			cPFOpen = true;
			break;

		case "Edit Project":
			if (frame.getProjectPanel().getTableListener().getProject() == null) {
				JOptionPane.showMessageDialog(frame, "You have to select a project");
			} else {
				ePFOpen = true;
				this.cPF = new CreateProjectFrame(model, this);
				cPF.setTitle("Edit Project");
				CreateProjectPanel cPP = this.cPF.getCreateProjectPanel();
				cPP.editProject(frame.getProjectPanel().getTableListener().getProject());

			}
			break;

		case "Confirm":

			if (cPFOpen) {
				confirmedClicked();

			} else if (ePFOpen) {
				confirmedClicked();
			} else if (cAFOpen) {
				confirmedActivityClicked();
				cAFOpen = false;
			} else if (eAFOpen) {
				eAFOpen = false;
			}
			break;

		case "Cancel":
			if (cPFOpen) {
				this.cPF.setVisible(false);
				this.cPF.dispose();
				cPFOpen = false;
			} else if (cAFOpen) {
				cAF.setVisible(false);
				cAF.dispose();
				cAFOpen = false;
			} else if (ePFOpen) {
				this.cPF.setVisible(false);
				this.cPF.dispose();
				ePFOpen = false;
			} else if (eAFOpen) {
				eAFOpen = false;
			}
			break;

		case "Edit Activity":
			eAFOpen = true;

			break;

		case "Get Project Report":
			try {
				if (frame.getProjectPanel().getTableListener().getProject() == null) {
					JOptionPane.showMessageDialog(frame, "You have to select a project");
				} else {
					model.reportProject(frame.getProjectPanel().getTableListener().getProject());
					JOptionPane.showMessageDialog(this.frame, "You report is created for project: "
							+ frame.getProjectPanel().getTableListener().getProject().getName());
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			break;

		case "Add Time":
			break;

		case "Absence":
			break;

		case "Create Activity":
			if (frame.getProjectPanel().getTableListener().getProject() == null) {
				JOptionPane.showMessageDialog(frame, "You have to select a project");
				break;
			}
			
			if (model.getCurrentEmployee() == null ) {
				JOptionPane.showMessageDialog(frame, "You cannot make and activity when you are a guest.");
				break;
			}
			
			if (frame.getProjectPanel().getTableListener().getProject().getProjectManager() == null) {
				JOptionPane.showMessageDialog(frame, "The project needs a project manager.");
				break;
			}

			if (model.getCurrentEmployee().getName().equals(
						frame.getProjectPanel().getTableListener().getProject().getProjectManager().getName())) {
				cAF = new CreateActivityFrame(model, this, frame);
				cAFOpen = true;
			} else {
				JOptionPane.showMessageDialog(frame, "You have to be project manager to create an activity.");
			}
			
			break;

		case "Login":

			model.setCurrentEmployee(
					model.searchEmployee(frame.getLoginPanel().employees.getSelectedItem().toString()));
			frame.loggedInPanels();
			break;

		case "Employee List":
			break;

		case "Logout":
			model.setCurrentEmployee(null);
			frame.returnToLoginPanel();
			break;

		case "+":
			employee = this.cAF.getCreateActivityPanel().employees.getSelectedItem().toString();
			if (employee != "") {
				e1 = model.searchEmployee(employee);
			} else {
				JOptionPane.showMessageDialog(cAF, "Please select an employee");
				break;
			}
			try {
				cAF.getCreateActivityPanel().addEmployee(e1);
				cAF.setSelectedEmployees();
				employee = null;
			} catch (Exception e1) {
				System.out.println("buttonlistener Error: +");
			}

			break;

		case "-":
			employee = this.cAF.getCreateActivityPanel().employeesAddedBox.getSelectedItem().toString();
			if (employee != "Added Employees") {
				e1 = model.searchEmployee(employee);
			} else {
				JOptionPane.showMessageDialog(cAF, "Please select an employee");
				break;
			}
			try {
				cAF.getCreateActivityPanel().removeAddEmployee(e1);
				cAF.setSelectedEmployees();
				employee = null;
			} catch (Exception e1) {
				System.out.println("buttonlistener Error: -");
			}
			break;

		case "Add employee":
			String addName = JOptionPane.showInputDialog(frame, "Enter name of new employee");
			if (addName != null && addName != " ") {
				model.createEmployee(addName);
				frame.getLoginPanel().updateEmployeeComboBox();
				JOptionPane.showMessageDialog(frame, addName + " has been added to the employee list");
			}
			break;

		case "Remove employee":
			String removeName = JOptionPane.showInputDialog(frame, "Enter the name a employee");
			
			Employee removeEmployee = null;
			
			if(removeName != null && removeName != " "){
				removeEmployee = model.searchEmployee(removeName);
			}
			
			if (removeEmployee != null ) {
				model.removeEmployee(removeEmployee);
				frame.getLoginPanel().updateEmployeeComboBox();
				JOptionPane.showMessageDialog(frame, removeName + " has been removed from the employee list");
			} else if(removeName != null){
					JOptionPane.showMessageDialog(frame, removeName + " is not a valid employee");
			}
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	public void confirmedClicked() {

		String sD = this.cPF.getCreateProjectPanel().startDay.getSelectedItem().toString();
		String sM = this.cPF.getCreateProjectPanel().startMonth.getSelectedItem().toString();
		String sY = this.cPF.getCreateProjectPanel().startYear.getSelectedItem().toString();

		String eD = this.cPF.getCreateProjectPanel().endDay.getSelectedItem().toString();
		String eM = this.cPF.getCreateProjectPanel().endMonth.getSelectedItem().toString();
		String eY = this.cPF.getCreateProjectPanel().endYear.getSelectedItem().toString();
		if (sD == "dd" || sM == "mm" || sY == "yyyy") {
			sD = "" + 0;
			sM = "" + 0;
			sY = "" + 0;
		}
		if ((eD == "dd" || eM == "mm" || eY == "yyyy")) {
			eD = "" + 0;
			eM = "" + 0;
			eY = "" + 0;
		}
		String pM = null;

		pM = this.cPF.getCreateProjectPanel().employees.getSelectedItem().toString();

		// String pM =
		// this.cPF.getCreateProjectPanel().employees.getSelectedItem().toString();
		Employee projectManager = null;
		if (pM != "") {
			projectManager = model.searchEmployee(pM);
		}
		String name = this.cPF.getCreateProjectPanel().name.getText();

		if (cPFOpen) {
			try {
				model.createProject(name, projectManager, Integer.parseInt(sY), Integer.parseInt(sM),
						Integer.parseInt(sD), Integer.parseInt(eY), Integer.parseInt(eM), Integer.parseInt(eD));
				frame.getProjectPanel().updateList();
				frame.update();
				this.cPF.setVisible(false);
				this.cPF.dispose();
				this.cPFOpen = false;
			} catch (OperationNotAllowedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(cPF, e1.getMessage().toString());
				// e1.printStackTrace();
				// e1.getMessage().toString();
			}
		} else if (ePFOpen) {
			try {
				Project p = frame.getProjectPanel().getTableListener().getProject();
				p.checkDate(Integer.parseInt(sY), Integer.parseInt(sM), Integer.parseInt(sD), Integer.parseInt(eY),
						Integer.parseInt(eM), Integer.parseInt(eD));
				p.setProjectManager(projectManager);
				p.setName(name);
				frame.getProjectPanel().updateList();
				frame.update();
				this.cPF.setVisible(false);
				this.cPF.dispose();
				this.ePFOpen = false;
			} catch (OperationNotAllowedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(cPF, e1.getMessage().toString());
				// e1.printStackTrace();
				// e1.getMessage().toString();

			}
		}
	}

	public void confirmedActivityClicked() {
		if (cAFOpen) {
			try {
				CreateActivityPanel cAP = cAF.getCreateActivityPanel();
				Project p = frame.getProjectPanel().getTableListener().getProject();
				Activity a = p.createActivity(cAP.name.getText(), Integer.parseInt(cAP.expectedWorkTime.getText()),
						model.getCurrentEmployee());
				a.addEmployee(cAP.getAddedEmployee());
				frame.getActivityPanel().updateActivityList(p);
				frame.update();
				this.cAF.setVisible(false);
				this.cAF.dispose();
				this.cAFOpen = false;
			} catch (OperationNotAllowedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(cAF, e1.getMessage().toString());
				// e1.printStackTrace();
				// e1.getMessage().toString();

			}
		}
		else if (eAFOpen){
			
		}
	}
}