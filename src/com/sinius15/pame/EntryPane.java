package com.sinius15.pame;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField valueField, nameField;
	
	public EntryPane(String name, String value) {
		setLayout(null);
		
		nameField = new JTextField(name);
		nameField.setBounds(10, 0, 101, 20);
		add(nameField);
		
		valueField = new JTextField(value);
		valueField.setBounds(111, 0, 246, 20);
		add(valueField);
		valueField.setColumns(30);
	}

}
