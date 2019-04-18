package main.java;

import java.awt.*;
import javax.swing.*;

import org.json.simple.JSONObject;

import main.java.models.Tile;

public class Components {
	
	
	public JButton gotoBtn;
	public JButton createAttrBtn;
	public JButton updateAttrBtn;
	public JButton updatePropBtn;
	
	public JComboBox<String> tableCB;
	public JComboBox<String> catCB;	
	
	public JList<JSONObject> mainLB;
	
	public JList<?> propLB;
	
	public JTextField gotoInput;
	public JTextField propInput;
	public JTextField attrInput;
	
	public JTextArea msgArea;
	
	public ImageViewer imageBox;
	
	public EventHandler events;
	
	public Components() {
		
		setUpButtons();
		setUpTextFields();
		setUpListBox();
		setUpComboBoxes();
		setUpTextArea();							
	}
	
	public void addToWindow(JFrame win) {
		win.add(gotoBtn);
		win.add(updatePropBtn);
		win.add(createAttrBtn);
		win.add(updateAttrBtn);
		
		win.add(gotoInput);
		win.add(propInput);
		win.add(attrInput);
		
		win.add(mainLB);
		win.add(propLB);
		
		win.add(tableCB);
		win.add(catCB);
	
		win.add(msgArea);		
	}
	
	private void setUpTextFields() {
		
		gotoInput = new JTextField();
		gotoInput.setBounds(25, 25, 170, 25);
		
		propInput = new JTextField();
		propInput.setBounds(25, 500, 200, 25);
		
		attrInput = new JTextField();
		attrInput.setBounds(400, 350, 250, 25);
		
	}	
	
	private void setUpButtons() {		
		gotoBtn = new JButton("Goto");
		gotoBtn.setBounds(200, 25, 60, 25);
		
		updatePropBtn = new JButton("Update Base Properties");
		updatePropBtn.setBounds(425, 500, 200, 25 );
		
		createAttrBtn = new JButton("Create Attributes");
		createAttrBtn.setBounds(725, 75, 150, 25);
		
		updateAttrBtn = new JButton("Update Attribute");
		updateAttrBtn.setBounds(660, 350, 130, 25);
	}
	
	private void setUpListBox() {
		mainLB = new JList<JSONObject>();		
		//mainLB.setVisibleRowCount(25);
		mainLB.setBounds(25, 75, 300, 400);
		
		propLB = new JList<Object>();
		propLB.setVisibleRowCount(10);
		propLB.setBounds(400, 75, 250, 250);				
	}
	
	private void setUpComboBoxes() {
		
		tableCB = new JComboBox<String>(Constants.CATEGORIES);
		tableCB.setBounds(300, 25, 150, 25);
		
		catCB =  new JComboBox<String>(Constants.CATEGORIES);
		catCB.setBounds(225, 500, 150, 25);				
	}
	
	private void setUpTextArea() {		
		msgArea = new JTextArea();
		msgArea.setBounds(25, 550, 300, 100);
		msgArea.setEditable(false);
		msgArea.setLineWrap(true);
		msgArea.setOpaque(false);
		msgArea.setWrapStyleWord(true);
		
		
		msgArea.setText("All error and other messages go here");		
	}
	
	public void setUpImageViewer(JFrame win) {
		imageBox = new ImageViewer();
		win.getContentPane().add(imageBox);
	}
	
	
	public void say(String msg) {
		msgArea.setText(msg);		
	}
	
	

}
