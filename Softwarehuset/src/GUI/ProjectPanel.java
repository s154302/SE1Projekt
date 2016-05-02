package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import code.Model;

public class ProjectPanel extends JPanel {
	
	public ProjectPanel(Frame f, Model model){ 
		System.out.println("project");
		this.setBackground(Color.BLUE);
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		gbc.weighty = 1;

        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;


        
		//making titles for a columns-array
		String[] columnNames = {"Projects"};
		
		//filling columns-array for table
		Object[][] data = new Object[model.projectList().size()][1];
		for(int i = 0;i<model.projectList().size();i++){
			data[i][0] = model.projectList().get(i);

		 }
		
		//adding table to panel
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, gbc);
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		
		
		//adding back to menu button
//		ButtonListener buttonList = new ButtonListener(frame);
//		JButton backButton = new JButton("Back to menu");
//		this.add(backButton, BorderLayout.SOUTH);
//		
		

	}

}
