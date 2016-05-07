package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
<<<<<<< HEAD
=======
import javax.swing.JLabel;
>>>>>>> Emilie
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
<<<<<<< HEAD
	
	public ActivityPanel(Frame f, Model model, Project project, ButtonListener bL){ 
		this.f = f;
		this.model = model;
		this.bL = bL;
		this.setLayout(new BorderLayout());
		
		JButton createActivity = new JButton("Create Activity");
		createActivity.addActionListener(bL);
		this.add(createActivity, "North");
		
=======
	private TableListener tableListener;
	private ProjectPanel projectPanel;
	private JLabel welcome;
	
	public ActivityPanel(Frame f, Model model,ProjectPanel projectPanel, ButtonListener bL){ 
		this.f = f;
		this.model = model;
		this.bL = bL;
		this.projectPanel = projectPanel;
		Project project = model.projectList().get(0);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
>>>>>>> Emilie
		//filling columns-array for table
		//updateActivityList(project);
		
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
		tableContainer = new JScrollPane(table);
		
<<<<<<< HEAD
		table.getSelectionModel().addListSelectionListener(new TableListener(model, f, table));
=======
		tableListener = projectPanel.getTableListener();
		tableListener.setTable(table);
		table.getSelectionModel().addListSelectionListener(tableListener);
>>>>>>> Emilie
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		this.add(tableContainer, BorderLayout.CENTER);

		firstRun = false;
		f.update();
<<<<<<< HEAD
	}

	public void editActivity() {
		// TODO Auto-generated method stub
		
		
=======
>>>>>>> Emilie
	}

	public void editActivity() {
		// TODO Auto-generated method stub
		
		
	}

}

