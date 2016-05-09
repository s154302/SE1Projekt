package GUI;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;

import code.Activity;
import code.Model;
import code.NonProjectActivity;
import code.OperationNotAllowedException;
import code.Project;

public class Frame extends JFrame{
	
	private ProjectPanel projectPanel;
	private ActivityPanel activityPanel;
	private ButtonPanel buttonPanel;
	private GridBagConstraints gbc;
	private Model model;
	private ButtonListener bL;
	private LoginPanel loginPanel;
	private TableListener tableListener;
	private Activity a;
	private Project p;
	private ActivityFrame aF;

	//constructing the main frame
	public Frame() throws FileNotFoundException, UnsupportedEncodingException{

		//constructing frame
		this.setSize(250,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Software Huset");
		
		// setting up the layout
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.anchor = gbc.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		//initializing the model
		initializingModel();
		
		//making ButtonListener
		bL = new ButtonListener(model, this);
		tableListener = null;

		loginPanel = new LoginPanel(model,bL);
		
		// adding Login Panel
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
		this.add(loginPanel, gbc);
		
	}
	
	public void returnToLoginPanel(){
		this.remove(projectPanel);
		this.remove(activityPanel);
		this.remove(buttonPanel);
		this.setSize(250,300);
		this.setLocationRelativeTo(null);
		
		loginPanel = new LoginPanel(model,bL);
		
		
		gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
		this.add(loginPanel, gbc);
		
		update();
	}

	public void loggedInPanels() {
		//removing Login panel
		this.remove(loginPanel);
		
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		
		//making the panels to the frame
		tableListener = new TableListener(model, this);
		this.projectPanel = new ProjectPanel(this, model, tableListener);
		this.activityPanel = projectPanel.getActivityPanel();
		this.buttonPanel = new ButtonPanel(this, model);
		
		// adding project Panel
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
		this.add(projectPanel, gbc);
		
		// adding activity panel
        gbc.gridx = 2; 
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 5;
		this.add(activityPanel, gbc);
		
		// adding button panel
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
		this.add(buttonPanel, gbc);
		
		update();
	}

	public void initializingModel() {
		model = new Model();
//		for (int i = 1; i <= 50; i++) {
//			model.createEmployee("Employee" + i);
//		}
		model.createEmployee("MaEA");
		model.createEmployee("SiHe");
		model.createEmployee("AlKA");
		model.createEmployee("EmID");
			try {
				model.createProject("SoftwareProjekt" , model.employeeList.get(0), 2017, 12, 12, 2018, 12, 13);
			} catch (OperationNotAllowedException e) {
				
				e.printStackTrace();
			}
				try {
					model.projectList.get(0).setProjectManager(model.employeeList.get(1));
					model.projectList.get(0).createActivity("GUI" , 10, model.employeeList.get(1));
					model.projectList.get(0).createActivity("Rapport" , 10, model.employeeList.get(1));
					model.projectList.get(0).createActivity("Aflevering" , 10, model.employeeList.get(1));
				} catch (OperationNotAllowedException e) {
					
					e.printStackTrace();
				}
		
		for(NonProjectActivity npa : model.nonProjectActivityList ){
			npa.addEmployee(model.employeeList);
		}
		
	}
		
	public void showIt(){
		this.setVisible(true);
	}


	public ProjectPanel getProjectPanel() {
		return projectPanel;
	}
	
	public ActivityPanel getActivityPanel() {
		return activityPanel;
	}
	
	public ButtonListener getButtonListener(){
		return bL;
	}
	public LoginPanel getLoginPanel(){
		return loginPanel;
	}
	
	public TableListener getTableListener(){
		return tableListener;
	}
	
	public void setActivity(Activity a) {
		this.a = a;
	}
	
	public Activity getActivity() {
		return this.a;
	}

	public void update() {
		this.revalidate();
	}

	public ActivityFrame getActivityFrame() {
		return aF;
	}

	public void setActivityFrame(ActivityFrame aF) {
		this.aF = aF;
	}
	
	public void setProject(Project p) {
		this.p = p;
	}
	
	public Project getProject() {
		return p;
	}

}

