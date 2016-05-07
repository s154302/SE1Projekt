package GUI;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Employee;
import code.Model;
import code.Project;

public class ProjectPanel extends JPanel {
	private ActivityPanel activityPanel;
	private Frame f;
	private Model model;
	private ButtonListener bL;
	private boolean firstRun = true;

	private TableListener tableListener;
	private JScrollPane tableContainer;
	private JTable table;
	
	public ProjectPanel(Frame f, Model model, TableListener tableListener){ 
		this.f = f;
		System.out.println("project");
		this.model=model;
		this.setLayout(new BorderLayout());
		this.bL = f.getButtonListener();
		this.tableListener = tableListener;
		
		//Making activity panel:
		updateList();
		
		activityPanel = new ActivityPanel(f, model, this, bL);

		//adding back to menu button
		JButton newProject = new JButton("Create Project");
		newProject.addActionListener(bL);
		this.add(newProject, BorderLayout.SOUTH);	
		

	}
	
	public ActivityPanel getActivityPanel(){
		return activityPanel;
	}

	public void setActivityPanel(Project p) {
		// TODO Auto-generated method stub
		if(p!=null)
			activityPanel.updateActivityList(p);

	}

	public void updateList() {
		if(!firstRun){
			this.remove(tableContainer);
		}
		
		//making titles for a columns-array
		String[] columnNames = {"Projects", "Name", "Project Manager"};
		
		//filling columns-array for table
		Object[][] data = new Object[model.projectList().size()][3];
		for(int i = 0;i<model.projectList().size();i++){
			data[i][1] = model.projectList().get(i).getName();
			data[i][0] = model.projectList().get(i).getSerialNumber();
			if( model.projectList().get(i).getProjectManager() != null){
				data[i][2] = model.projectList().get(i).getProjectManager().getName();
			}

		 }
		
		//adding table to panel
		table = new JTable(data, columnNames);
		table.setModel(new TableModel(data, columnNames));
		tableContainer = new JScrollPane(table);
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);

		//selecting project
		tableListener.setProjectTable(table);
		table.getSelectionModel().addListSelectionListener(tableListener);
		this.add(tableContainer, BorderLayout.CENTER);
		
		firstRun = false;
	}
	
	public TableListener getTableListener(){
		return tableListener;
	}
}

