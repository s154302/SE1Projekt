package GUI;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import code.Model;
import code.Project;

public class TableListener implements ListSelectionListener{
	private Model model;
	private Frame f;
	private JTable table;


	public TableListener(Model model, Frame f, JTable table){
		this.model = model;
		this.f = f;
		this.table = table;
	}
	
	public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() < model.projectList().size() && table.getSelectedRow()>-1) {
            // print first column value from selected row
            System.out.println(table.getValueAt(table.getSelectedRow(), 1).toString());
            //activityPanel = new ActivityPanel(f, model, table.getValueAt(table.getSelectedRow(), 0);
            //activityPanel = new ActivityPanel(f, model, model.projectList.get(table.getRowCount()-1));
            f.updateActivityPanel(f.getProjectPanel().setActivityPanel(table.getValueAt(table.getSelectedRow(), 0).toString()));
            
        }

}
}
