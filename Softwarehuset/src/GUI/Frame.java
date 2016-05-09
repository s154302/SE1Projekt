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
		for (int i = 1; i <= 50; i++) {
			model.createEmployee("Employee" + i);
		}

		for (int i = 1; i <= 30; i++) {
			try {
				model.createProject("Project" + i, model.employeeList.get(1), 2017, 12, 12, 2017, 12, 13);
			} catch (OperationNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int a = 1;
		for (Project p : model.projectList) {
			for (int i = 1; i <= 6; i++) {
				try {
					p.setProjectManager(model.employeeList.get(a));
					p.createActivity(a+"Activity" + i, 10, model.employeeList.get(a));
				} catch (OperationNotAllowedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			a++;
		}

		model.nonProjectActivityList.add(new NonProjectActivity("Ferie"));	
		model.nonProjectActivityList.add(new NonProjectActivity("Sygdom"));
		model.nonProjectActivityList.add(new NonProjectActivity("Kursus"));
		model.nonProjectActivityList.add(new NonProjectActivity("Barsel"));
		model.nonProjectActivityList.add(new NonProjectActivity("Afspadsering"));
		model.nonProjectActivityList.add(new NonProjectActivity("Andet"));
	}
		
	public void showIt(){
		this.setVisible(true);
	}


	public ProjectPanel getProjectPanel() {
		// TODO Auto-generated method stub
		return projectPanel;
	}
	
	public ActivityPanel getActivityPanel() {
		// TODO Auto-generated method stub
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
//	public ButtonPanel getButtonPanel(){
//		return buttonPanel;
//	}
	
	public void setActivity(Activity a) {
		this.a = a;
	}
	
	public Activity getActivity() {
		return this.a;
	}

	public void update() {
		// TODO Auto-generated method stub
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

