<<<<<<< HEAD
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Model;

public class ProjectPanel extends JPanel {
	private ActivityPanel activityPanel;
	
	public ProjectPanel(Frame f, Model model){ 
		System.out.println("project");
//		this.setBackground(Color.BLUE);
//		GridBagConstraints gbc = new GridBagConstraints();
//		this.setLayout(new GridBagLayout());
//		gbc.weighty = 1;
//
//        gbc.gridx = 0; 
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;

		//Making activity panel:
		activityPanel = new ActivityPanel(f, model, model.projectList().get(0));

        
		//making titles for a columns-array
		String[] columnNames = {"Projects", "Name", "Project Manager"};
		
		//filling columns-array for table
		Object[][] data = new Object[model.projectList().size()][3];
		for(int i = 0;i<model.projectList().size();i++){
			data[i][1] = model.projectList().get(i).getName();
			data[i][0] = model.projectList().get(i).getSerialNumber();
			data[i][2] = model.projectList().get(i).getProjectManager().getName();

		 }
		
		//adding table to panel
		JTable table = new JTable();
		table.setModel(new TableModel(data, columnNames));
		
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (table.getSelectedRow() > -1) {
		            // print first column value from selected row
		            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
		        }
		    }
		});
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		
		
		//adding back to menu button
//		ButtonListener buttonList = new ButtonListener(frame);
//		JButton backButton = new JButton("Back to menu");
//		this.add(backButton, BorderLayout.SOUTH);
//		
		

	}
	
	public ActivityPanel getActivityPanel(){
		return activityPanel;
	}

}
=======
package GUI;

import java.awt.BorderLayout;

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
	private Model model;
	
	public ProjectPanel(Frame f, Model model){ 
		System.out.println("project");
		this.model=model;

		//Making activity panel:
		activityPanel = new ActivityPanel(f, model, model.projectList().get(0));

        
		//making titles for a columns-array
		String[] columnNames = {"Projects", "Name", "Project Manager"};
		
		//filling columns-array for table
		Object[][] data = new Object[model.projectList().size()][3];
		for(int i = 0;i<model.projectList().size();i++){
			data[i][1] = model.projectList().get(i).getName();
			data[i][0] = model.projectList().get(i).getSerialNumber();
			data[i][2] = model.projectList().get(i).getProjectManager().getName();

		 }
		
		//adding table to panel
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		//selecting project
		table.getSelectionModel().addListSelectionListener(new TableListener(model, f, table));
		activityPanel = new ActivityPanel(f, model, model.projectList().get(0));
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		
		
		//adding back to menu button
		ButtonListener buttonList = new ButtonListener(model);
		JButton backButton = new JButton("something");
		this.add(backButton, BorderLayout.SOUTH);	
		

	}
	
	public ActivityPanel getActivityPanel(){
		return activityPanel;
	}

	public ActivityPanel setActivityPanel(String string) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<model.projectList().size();i++){
			if(model.projectList().get(i).getSerialNumber().equals(string)){
				activityPanel.updateActivityList(model.projectList().get(i));
				return activityPanel;
			}
		}
	return null;
	}
	
	public String geta(){
		return model.projectList().get(0).getSerialNumber();
	}
}
>>>>>>> Emilie
