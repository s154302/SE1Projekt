
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import code.Employee;
import code.Model;
import code.NonProjectActivity;
import code.OperationNotAllowedException;
import code.Project;

public class Frame extends JFrame{
	
	private ProjectPanel projectPanel;
	private ActivityPanel activityPanel;
	private ButtonPanel buttonPanel;
	private boolean firstRun = true;
	private GridBagConstraints gbc;
	private Model model;

	public Frame() throws FileNotFoundException, UnsupportedEncodingException{

		//constructing frame
		this.setSize(1000,700);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Software Huset");
		
		// setting up the layout
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.anchor = gbc.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		
		//initializing the model
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
					p.createActivity(a+"Activity" + i, i * (a*a)%30, model.employeeList.get(a));
				} catch (OperationNotAllowedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			a++;
		}

		model.nonProjectActivityList.add(new NonProjectActivity());	
		
		
		//making the panels to the frame
		this.projectPanel = new ProjectPanel(this, model);
		this.activityPanel = projectPanel.getActivityPanel();
		this.buttonPanel = new ButtonPanel(this, model);




		update(projectPanel, activityPanel, buttonPanel);

		
	}
	
	
	public void showIt(){
		this.setVisible(true);
	}


	public ProjectPanel getProjectPanel() {
		// TODO Auto-generated method stub
		return projectPanel;
	}
	
	public void update(ProjectPanel projectPanel, ActivityPanel activityPanel, ButtonPanel buttonPanel){
		if(firstRun){
			firstRun = false;
		} else{
			System.out.println(firstRun);
			this.remove(this.projectPanel);
			this.remove(this.activityPanel);
			this.remove(this.buttonPanel);
			this.projectPanel = projectPanel;
			this.activityPanel = activityPanel;
			this.buttonPanel = buttonPanel;
		}

		projectPanel.geta();
		
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
	}
	
//	public ButtonPanel getButtonPanel(){
//		return buttonPanel;
//	}


	public void updateActivityPanel(ActivityPanel activityPanel) {
		// TODO Auto-generated method stub

		this.activityPanel = activityPanel;

		this.revalidate();
	}

}
