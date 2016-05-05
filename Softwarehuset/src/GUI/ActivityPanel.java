package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Model;
import code.Project;

public class ActivityPanel extends JPanel {
	private Object[][] data;
	private String[] columnNames = {"Activities", "Expected Workload"};
	private JTable table;
	private JScrollPane tableContainer;
	private boolean firstRun = true;
	private Frame f;
	private Model model;
	
	public ActivityPanel(Frame f, Model model, Project project){ 
		this.f = f;
		this.model = model;
		
		//filling columns-array for table
		updateActivityList(project);
		
		
	}
	
	public void updateActivityList(Project project){
		if(!firstRun )
			this.remove(tableContainer);
		
		
		data = new Object[project.activityList.size()][2];
		
		for(int i = 0;i<project.activityList.size();i++){
			data[i][0] = project.activityList.get(i).getName();
			data[i][1] = project.activityList.get(i).getExpectedWorkload();
		 }
		
		table = new JTable(data, columnNames);
		tableContainer = new JScrollPane(table);
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		this.add(tableContainer, BorderLayout.CENTER);

		firstRun = false;
		f.updateActivityPanel(this);
	}
}

