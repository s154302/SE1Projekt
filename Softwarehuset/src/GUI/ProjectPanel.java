package GUI;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	
	public ProjectPanel(Frame f, Model model){ 
		this.f = f;
		System.out.println("project");
		this.model=model;
		this.setLayout(new BorderLayout());
		this.bL = f.getButtonListener();
		
		//Making activity panel:
		updateList();
		activityPanel = new ActivityPanel(f, model, bL);


		
		
		//adding back to menu button
//		ButtonListener buttonList = new ButtonListener(model,f);
		JButton newProject = new JButton("Create Project");
		newProject.addActionListener(bL);
		this.add(newProject, BorderLayout.SOUTH);	
		

	}
	
	public ActivityPanel getActivityPanel(){
		return activityPanel;
	}

	public void setActivityPanel(String string) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<model.projectList().size();i++){
			if(model.projectList().get(i).getSerialNumber().equals(string)){
				activityPanel.updateActivityList(model.projectList().get(i));
			}
		}
	}
	
	public String geta(){
		return model.projectList().get(0).getSerialNumber();
	}

	public void updateList() {
		if(!firstRun){
			this.remove(tableContainer);
			//firstRun = false;
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
		JTable table = new JTable(data, columnNames);
		table.setModel(new TableModel(data, columnNames));
		tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		//selecting project
		tableListener = new TableListener(model, f, table);
		table.getSelectionModel().addListSelectionListener(tableListener);

		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		firstRun = false;
	}
	
	public TableListener getTableListener(){
		return tableListener;
	}
}

