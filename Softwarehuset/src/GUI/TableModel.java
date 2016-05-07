package GUI;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
	public TableModel(Object[][] data ,String[] columnNames){
		this.setDataVector(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int rows, int cols){
		return false;
		
	}
	
}

