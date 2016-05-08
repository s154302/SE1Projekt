package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
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

	private TableListener tableListener;
	private ProjectPanel projectPanel;
	private JLabel welcome;
	
	public ActivityPanel(Frame f, Model model,ProjectPanel projectPanel, ButtonListener bL){ 
		this.f = f;
		this.model = model;
		this.bL = bL;
		this.projectPanel = projectPanel;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		if(model.getCurrentEmployee()!= null){
			welcome = new JLabel("Welcome "+model.getCurrentEmployee().getName()+"!");
		} else {
			welcome = new JLabel("Welcome!");
		}
		this.add(welcome, gbc);
		
	}
	
	public void updateActivityList(Project project){
		if(!firstRun ) {
			this.remove(tableContainer);
		} else {
			this.remove(welcome);
			this.setLayout(new BorderLayout());
			JButton createActivity = new JButton("Create Activity");
			createActivity.addActionListener(bL);
			this.add(createActivity, "North");
		}
		
		data = new Object[project.activityList.size()][2];
		
		for(int i = 0;i<project.activityList.size();i++){
			data[i][0] = project.activityList.get(i).getName();
			data[i][1] = project.activityList.get(i).getExpectedWorkload();
		 }
		
		table = new JTable(data, columnNames);
		table.setModel(new TableModel(data, columnNames));
		
		//tableListener = projectPanel.getTableListener();
		tableListener = new TableListener(model, f);
		tableListener.setProjectTable(projectPanel.getProjectTable());
		tableListener.setActivityTable(table);
		
		table.getSelectionModel().addListSelectionListener(tableListener);
		tableContainer = new JScrollPane(table);
		
		this.add(tableContainer, BorderLayout.CENTER);

		firstRun = false;
		f.update();
	}
	
	public JTable getTable() {
		return this.table;
	}

}

