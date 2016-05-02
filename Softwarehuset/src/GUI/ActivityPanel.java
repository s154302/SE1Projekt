package GUI;

import java.awt.BorderLayout;
import java.util.EventObject;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Model;
import code.Project;

public class ActivityPanel extends JPanel {
	private Object[][] data;
	private String[] columnNames = {"Activities", "Expected Workload"};
	
	public ActivityPanel(Frame f, Model model, Project project){ 
		System.out.println("activity");
//		this.setBackground(Color.RED);
//		this.setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//		gbc.weightx = 1;
//		gbc.weighty = 3;
//		
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//		this.add(new Label("Activity"), gbc);
//		
//        gbc.gridx = 0; 
//        gbc.gridy = 1;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        this.add(new Label("Activity2"), gbc);
//        
//        gbc.gridx = 0; 
//        gbc.gridy = 2;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        this.add(new Label("Activity4"), gbc);
//		
		
		//filling columns-array for table
		data = new Object[project.activityList.size()][2];
		for(int i = 0;i<project.activityList.size();i++){
			data[i][0] = project.activityList.get(i).getName();
			data[i][1] = project.activityList.get(i).getExpectedWorkload();

		 }
		
		//adding table to panel
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		
	}

	public boolean isCellEditable(EventObject anEvent) {
	    return false;
	  }
	
	public void updateActivityList(Project project){
		data = new Object[project.activityList.size()][2];
		for(int i = 0;i<project.activityList.size();i++){
			data[i][0] = project.activityList.get(i).getName();
			data[i][1] = project.activityList.get(i).getExpectedWorkload();
		 }
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
	}
}
