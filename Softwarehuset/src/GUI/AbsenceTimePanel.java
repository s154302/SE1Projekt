package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;

public class AbsenceTimePanel extends JPanel {

	private Model model;
	private ButtonListener bL;
	private AbsenceFrame aF;
	private JLabel name;

	public AbsenceTimePanel(Model model, ButtonListener bL, AbsenceFrame aF) {
		this.model = model;
		this.bL = bL;
		this.aF = aF;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		// Employee's name
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		if(model.getCurrentEmployee()!= null){
			name = new JLabel("Absence for "+model.getCurrentEmployee().getName());
		} else {
			JOptionPane.showMessageDialog(aF, "You cannot add absence time as a guest");
			aF.saveTime();
		}
		this.add(name, gbc);
		
		// add Course time + label
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel course = new JLabel("New Courses");
		this.add(course, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.LINE_END;
		gbc.gridheight = 1;
		JTextField courseTime = new JTextField();
		this.add(courseTime, gbc);
		
		// add sickness time + label
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel sick = new JLabel("Sickness");
		this.add(sick, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JTextField sickTime = new JTextField();
		this.add(sickTime, gbc);
		
		// add vacation time + label
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel va = new JLabel("Vacation");
		this.add(va, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JTextField vaTime = new JTextField();
		this.add(vaTime, gbc);
		
		// add other time + label
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel other = new JLabel("Other");
		this.add(other, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JTextField otherTime = new JTextField();
		this.add(otherTime, gbc);
		
		//add save button
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JButton addTime = new JButton("Confirm Absence");
		addTime.addActionListener(bL);
		this.add(addTime, gbc);

	}
	
	

}
