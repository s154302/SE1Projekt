package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.JButton;
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
	private ButtonListener bL;
	
	public ActivityPanel(Frame f, Model model, Project project, ButtonListener bL){ 
		this.f = f;
		this.model = model;
		this.bL = bL;
		this.setLayout(new BorderLayout());
		
		JButton createActivity = new JButton("Create Activity");
		createActivity.addActionListener(bL);
		this.add(createActivity, "North");
		
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
		table.setModel(new TableModel(data, columnNames));
		tableContainer = new JScrollPane(table);
		
		table.getSelectionModel().addListSelectionListener(new TableListener(model, f, table));
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		this.add(tableContainer, BorderLayout.CENTER);

		firstRun = false;
		f.update();
	}

	public void editActivity() {
		// TODO Auto-generated method stub
		ActivityFrame activityFrame = new ActivityFrame(model, bL);
		
	}
}

