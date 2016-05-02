package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

	public Frame(){

		System.out.println("frame");
		//constructing frame
		this.setSize(1000,700);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Software Huset");	
		
		//initializing the model
		Model model = new Model();
		for (int i = 1; i <= 5; i++) {
			model.createEmployee("Employee" + i);
		}

		for (int i = 1; i <= 50; i++) {
			try {
				model.createProject("Project" + i, model.employeeList.get(1), 2017, 12, 12, 2017, 12, 13);
			} catch (OperationNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int a = 1;
		for (Project p : model.projectList) {
			for (int i = 1; i <= 5; i++) {
				try {
					p.createActivity(a+"Activity" + i, i * 2, model.employeeList.get(1));
				} catch (OperationNotAllowedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			a++;
		}

		for (int i = 1; i <= 5; i++) {
			try {
				model.projectList.get(1).createActivity("Activity" + i, i * 3, model.employeeList.get(1));
			} catch (OperationNotAllowedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.nonProjectActivityList.add(new NonProjectActivity());	
		
		
		//making the panels to the frame
		projectPanel = new ProjectPanel(this, model);
		activityPanel = projectPanel.getActivityPanel();
		buttonPanel = new ButtonPanel(this, model);


		// setting up the layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
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
	
	
	public void showIt(){
		this.setVisible(true);
	}


	public ProjectPanel getProjectPanel() {
		// TODO Auto-generated method stub
		return projectPanel;
	}

}
