package GUI;

import javax.swing.JFrame;

public class CreateProjectFrame extends JFrame{
	
	public CreateProjectFrame(){
		this.setSize(800,675);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Project");	
		
		
	}
	
	
	
	public void showIt(){
		this.setVisible(true);
	}

}
