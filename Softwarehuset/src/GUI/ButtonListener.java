package GUI;

import java.awt.HeadlessException;
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
	private ActivityFrame aF;

	private AbsenceFrame abF;
	
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
			// makes sure a project is selected
			if (frame.getProjectPanel().getTableListener().getProject() == null) {
				JOptionPane.showMessageDialog(frame, "You have to select a project");
			}
			// Only the project manager can edit a project unless there is no
			// project manager.
			else if (!frame.getProjectPanel().getTableListener().getProject()
					.isProjectManager(model.getCurrentEmployee())
					&& frame.getProjectPanel().getTableListener().getProject().getProjectManager() != null) {

				JOptionPane.showMessageDialog(frame, "You have to be project manager");
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
			} else if (eAFOpen) {
				confirmedActivityClicked();
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
				frame.getActivityFrame().setVisible(false);
				frame.getActivityFrame().dispose();
				eAFOpen = false;
			}
			break;

		case "Edit Activity":
			eAFOpen = true;
			if (model.getCurrentEmployee() == null
					|| !(model.getCurrentEmployee().equals(frame.getProject().getProjectManager()))) {
				JOptionPane.showMessageDialog(frame.getActivityFrame(),
						"You must be the project manager in order to edit the activity.");
			} else {
				frame.getActivityFrame().editActivity();
			}
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
			System.out.println("absence");
			abF = new AbsenceFrame(model,this);
			break;

		case "Create Activity":
			if (frame.getProjectPanel().getTableListener().getProject() == null) {
				JOptionPane.showMessageDialog(frame, "You have to select a project");
				break;
			}

			if (model.getCurrentEmployee() == null) {
				JOptionPane.showMessageDialog(frame, "You cannot make and activity when you are a guest.");
				break;
			}

			if (frame.getProjectPanel().getTableListener().getProject().getProjectManager() == null) {
				JOptionPane.showMessageDialog(frame, "The project needs a project manager.");
				break;
			}

			if (model.getCurrentEmployee().getName()
					.equals(frame.getProjectPanel().getTableListener().getProject().getProjectManager().getName())) {
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
			if (cAFOpen) {
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
			} else {
				EditActivityPanel editFrame = frame.getActivityFrame().getEditActivityPanel();
				employee = editFrame.employees.getSelectedItem().toString();
				if (employee != "") {
					e1 = model.searchEmployee(employee);
				} else {
					JOptionPane.showMessageDialog(editFrame, "Please select an employee");
					break;
				}
				try {
					editFrame.addEmployee(e1);
					editFrame.setEmployeesToActivity();
					employee = null;
				} catch (Exception e1) {
					System.out.println("buttonlistener Error: +");
				}
			}

			break;

		case "-":
			if (cAFOpen) {
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
			} else {
				EditActivityPanel editFrame = frame.getActivityFrame().getEditActivityPanel();
				employee = editFrame.employees.getSelectedItem().toString();
				if (employee != "Added Employees") {
					e1 = model.searchEmployee(employee);
				} else {
					JOptionPane.showMessageDialog(editFrame, "Please select an employee");
					break;
				}
				try {
					editFrame.removeAddEmployee(e1);
					editFrame.setEmployeesToActivity();
					employee = null;
				} catch (Exception e1) {
					System.out.println("buttonlistener Error: -");
				}

			}
			break;

		case "Add employee":
			String addName = JOptionPane.showInputDialog(frame, "Enter name of new employee");
			if (addName != null) {
				model.createEmployee(addName);
				frame.getLoginPanel().updateEmployeeComboBox();
				JOptionPane.showMessageDialog(frame, addName + " has been added to the employee list");
			}
			break;

		case "Remove employee":
			String removeName = JOptionPane.showInputDialog(frame, "Enter the name a employee");

			Employee removeEmployee = null;

			if (removeName != null && removeName != " " && removeName == "") {
				removeEmployee = model.searchEmployee(removeName);
			}

			if (removeEmployee != null) {
				model.removeEmployee(removeEmployee);
				frame.getLoginPanel().updateEmployeeComboBox();
				JOptionPane.showMessageDialog(frame, removeName + " has been removed from the employee list");
			} else if (removeName != null) {
				JOptionPane.showMessageDialog(frame, removeName + " is not a valid employee");
			}
			break;

		case "Delete Activity":
			try {
				Activity a = frame.getActivity();
				Project p = frame.getTableListener().getProject();
				model.deleteActivity(p, a);
				frame.getActivityPanel().updateActivityList(p);
				frame.update();
				frame.getActivityFrame().dispose();
			} catch (OperationNotAllowedException e1) {
				JOptionPane.showMessageDialog(cPF, e1.getMessage().toString());
			}
			break;

		case "Delete project":
			try {
				try {
					model.deleteProject(frame.getProjectPanel().getTableListener().getProject());
					frame.getProjectPanel().updateList();
					frame.update();
					this.cPF.dispose();
				} catch (OperationNotAllowedException e1) {
					JOptionPane.showMessageDialog(cPF, e1.getMessage().toString());
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "Add Absence Time":
			abF.addTime();
			break;
			
		case "Confirm Absence":
			abF.saveTime();
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

				int expWork = 0;

				String name = cAP.name.getText();
				String expWorkString = cAP.expectedWorkTime.getText();
				Employee pM = model.getCurrentEmployee();

				if (expWorkString.equals("")) {
					expWork = 0;
				} else {
					
					try {
						expWork = Integer.parseInt(expWorkString);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(cAF, "Expected work has to be a integer.");
					} catch(NullPointerException e) {
						JOptionPane.showMessageDialog(cAF, "Expected work has to be a integer.");
				    }
					
				}

				Activity a = p.createActivity(name, expWork, pM);
				a.addEmployee(cAP.getAddedEmployee());

				frame.getActivityPanel().updateActivityList(p);
				frame.update();

				this.cAF.setVisible(false);
				this.cAF.dispose();
				this.cAFOpen = false;
			} catch (OperationNotAllowedException e1) {
				JOptionPane.showMessageDialog(cAF, e1.getMessage().toString());
				// e1.printStackTrace();
				// e1.getMessage().toString();
				this.cAFOpen = true;
			}
		} else if (eAFOpen) {
			EditActivityPanel eAF = frame.getActivityFrame().getEditActivityPanel();
			eAF.getActivity().setName(eAF.getName());
			eAF.getActivity().setExpectedWorkload((eAF.getExpectedWorkload()));
			frame.getActivityPanel().updateActivityList(frame.getProject());
			frame.update();
			frame.getActivityFrame().setVisible(false);
			frame.getActivityFrame().dispose();
		}
	}
}