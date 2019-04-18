package main.java;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.json.simple.JSONObject;

import main.java.models.Tile;

public class EventHandler implements ActionListener, ListSelectionListener  {

	
		
	public EventHandler() {			
		setUpListeners();
	}		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();			
		
		if(src == Window.getComps().gotoBtn) {
			String input = Window.getComps().gotoInput.getText();
			try {
				int numInput = Integer.parseInt(input);				
				Window.getComps().mainLB.setListData(JsonIO.get50ById(numInput));
				Window.getComps().say("");
			}
			catch(NumberFormatException ex) {
				Window.getComps().say("Invalid input, please enter an Integer");
			}												
		}
		else if(src == Window.getComps().createAttrBtn) {}
		else if(src == Window.getComps().updateAttrBtn) {}
		else if(src == Window.getComps().updatePropBtn) {}
		else {
			Window.getComps().say("Unhandled action was heard: " + src.toString()); 			
		}						
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) {
			JList<JSONObject> src = (JList<JSONObject>)e.getSource();		
			if(src.getSelectedValue()  != null) {
				JSONObject obj = src.getSelectedValue();	
				long id = (long)obj.get("Id");		
			
				Window.getComps().imageBox.getSubImage((int)id);
			}	
		}
	}		
	
	private void setUpListeners() {
		Window.getComps().gotoBtn.addActionListener(this);
		Window.getComps().createAttrBtn.addActionListener(this);
		Window.getComps().updateAttrBtn.addActionListener(this);
		Window.getComps().updatePropBtn.addActionListener(this);
		Window.getComps().mainLB.addListSelectionListener(this);
		Window.getComps().propLB.addListSelectionListener(this);		
	}

}
