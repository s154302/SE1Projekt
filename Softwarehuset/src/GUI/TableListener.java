package GUI;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Model;
import code.Project;

public class TableListener implements ListSelectionListener{
	private Model model;
	private Project p;
	private Frame f;
	private JTable table;


	public TableListener(Model model, Frame f, JTable table){
		this.model = model;
		this.f = f;
		this.table = table;
	}
	
	public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() < model.projectList().size() && table.getSelectedRow()>-1 && table.getValueAt(0,0).equals(model.projectList.get(0).getSerialNumber())) {

            f.getProjectPanel().setActivityPanel(table.getValueAt(table.getSelectedRow(), 0).toString());
            f.update();
            
        } else if( table.getSelectedRow()>-1) {
        	f.getProjectPanel().getActivityPanel().editActivity();
        
        }

}
}
