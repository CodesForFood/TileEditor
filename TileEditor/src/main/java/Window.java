package main.java;

import javax.swing.*;


public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	static Components comps;
	EventHandler events;	
	
	public Window() {
		
		comps = new Components();			
		setUpWindow();		
		comps.addToWindow(this);
		comps.setUpImageViewer(this);
		
		events = new EventHandler();				
	}
	
	public void renderWindow() {
		
		setVisible(true);
	}
	
	
	private void setUpWindow() {
		setTitle("Tile Editor");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setLayout(null);
		
	}		
	
	public static Components getComps() {
		return comps;
	}
	
}
