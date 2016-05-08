
package GUI;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Activity;
import code.Model;
import code.Project;

public class TableListener implements ListSelectionListener {
	private Model model;
	private Frame f;
	private JTable tableProject, tableActivity;
	private Project project;
	private Activity activity;
	private ActivityFrame activityFrame;

	public TableListener(Model model, Frame f) {
		this.model = model;
		this.f = f;
		this.tableProject = null;
		this.tableActivity = null;
		project = null;
		activity = null;

	}

	public void valueChanged(ListSelectionEvent event) {

		if (tableProjectSelected()) {
			project = model.searchProject(tableProject.getValueAt(tableProject.getSelectedRow(), 0).toString());
			f.getProjectPanel().setActivityPanel(project);
		}
		if (tableActivitySelected()) {
			activity = project.searchActivity(tableActivity.getValueAt(tableActivity.getSelectedRow(), 0).toString());
			activityFrame = new ActivityFrame(model, f, activity);
			f.update();
			System.out.println("A-tableListener");
		}

	}

	private boolean tableProjectSelected() {
		return tableProject.getSelectedRow() < model.projectList().size() && tableProject.getSelectedRow() > -1
				&& tableProject.getValueAt(0, 0).equals(model.projectList.get(0).getSerialNumber());
	}

	public boolean tableActivitySelected() {
		if (this.tableActivity != null) {
			System.out.println("must be over -1: " + tableActivity.getSelectedRow());
			if (project.activityList.get(0).getName().equals(tableActivity.getValueAt(0, 0).toString())
					&& tableActivity.getSelectedRow() > -1) {
				return true;
			}
		}
		return false;
	}

	public Project getProject() {
		if (tableProjectSelected()) {
			return project;
		}
		return null;
	}

	public Activity getActivity() {
		if (tableActivity != null) {
			return activity;
		}
		return null;
	}

	public ActivityFrame getActivityFrame() {
		return activityFrame;
	}

	public void setActivityTable(JTable table) {
		this.tableActivity = table;
	}

	public void setProjectTable(JTable table) {
		this.tableProject = table;
	}

}
