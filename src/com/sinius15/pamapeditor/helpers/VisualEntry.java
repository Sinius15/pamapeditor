package com.sinius15.pamapeditor.helpers;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sinius15.pamapapi.Entry;

public class VisualEntry extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField valueField, nameField;
	private Entry originalEntry;
	
	public VisualEntry(Entry e) {
		originalEntry = e;
		setLayout(null);
		
		nameField = new JTextField(e.name);
		nameField.setBounds(3, 3, 150, 20);
		add(nameField);
		
		valueField = new JTextField(e.value);
		valueField.setBounds(165, 3, 110, 20);
		add(valueField);
		
		setPreferredSize(new Dimension(270, 23));
	}
	
	public Entry getCurrentEntry(){
		String s = valueField.getText();
		if(s.contains(" "))
			s = "\"" + s + "\"";
		return new Entry(nameField.getText(), s);
	}
	
	public Entry getOriginalEntry(){
		return originalEntry;
	}

}
