//<<<<<<< HEAD
//package GUI;
//
//import javax.swing.JTable;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import code.Activity;
//import code.Model;
//import code.Project;
//
//public class TableListener implements ListSelectionListener{
//	private Model model;
//	private Project p;
//	private Frame f;
//	private JTable table;
//	private Project project;
//
//
//	public TableListener(Model model, Frame f, JTable table){
//		this.model = model;
//		this.f = f;
//		this.table = table;
//	}
//	
//	public void valueChanged(ListSelectionEvent event) {
//        if (table.getSelectedRow() < model.projectList().size() && table.getSelectedRow()>-1 
//        		&& table.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {
//
//            f.getProjectPanel().setActivityPanel(table.getValueAt(table.getSelectedRow(), 0).toString());
//            f.update();
//            
//        } else if( table.getSelectedRow()>-1) {
//        	ActivityFrame activityFrame = new ActivityFrame(model, f);
//        	
//        
//        } else{
//        	System.out.println("nej");
//        }
//        	
//        }
//    public Project getProject(){
//   	 if (table.getSelectedRow() < model.projectList().size() && table.getSelectedRow()>-1 && table.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {
//         project =   model.searchProject(table.getValueAt(table.getSelectedRow(), 0).toString());
//   		 return project;
//            }
//   	 return null;
//   	 }
//    
//    public Activity getActivity(){
//      	 if (table.getSelectedRow()>-1 && !table.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {
//               return project.searchActivity(table.getValueAt(table.getSelectedRow(), 0).toString());
//               }
//      	 System.out.println("TableListener error");
//      	 return null;
//      	 }
//
//}
//=======
package GUI;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Activity;
import code.Model;
import code.Project;

public class TableListener implements ListSelectionListener{
	private Model model;
	private Project p;
	private Frame f;
	private JTable tableProject,tableActivity;
	private Project project;
	private Activity activity;
	private ActivityFrame activityFrame;


	public TableListener(Model model, Frame f, JTable table){
		this.model = model;
		this.f = f;
		this.tableProject = table;
		this.tableActivity = null;
	}
	
	public void valueChanged(ListSelectionEvent event) {
    	if(tableActivity != null) {
    		if(tableActivity.getSelectedRow()>-1){
    			
    	activity = project.searchActivity(tableActivity.getValueAt(tableActivity.getSelectedRow(), 0).toString());
    	activityFrame = new ActivityFrame(model, f, activity);
    		}
            
        } else if (tableProject.getSelectedRow() < model.projectList().size() && tableProject.getSelectedRow()>-1 
        		&& tableProject.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {
        	activity = null;
        	project =   model.searchProject(tableProject.getValueAt(tableProject.getSelectedRow(), 0).toString());
         f.getProjectPanel().setActivityPanel(project);
            f.update();

        } else{
        	System.out.println("tableListener");
        }
        	
        }
	
    public Project getProject(){
   	 if (tableProject.getSelectedRow() < model.projectList().size() && tableProject.getSelectedRow()>-1 && tableProject.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {
         project =   model.searchProject(tableProject.getValueAt(tableProject.getSelectedRow(), 0).toString());
   		 return project;
            }
   	 return null;
   	 }
    
    public Activity getActivity(){
      	 if (tableActivity != null) {
      		 return activity;
         }
      	 return null;
    }
    
    public void setTable(JTable table){
    	this.tableActivity=table;
    }
    
    public ActivityFrame getActivityFrame(){
    	return activityFrame;
    	
    }

}
