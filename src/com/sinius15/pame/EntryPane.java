package com.sinius15.pame;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField valueField, nameField;
	
	public EntryPane(String name, String value) {
		setLayout(null);
		
		nameField = new JTextField(name);
		nameField.setBounds(3, 3, 150, 20);
		add(nameField);
		
		valueField = new JTextField(value);
		valueField.setBounds(165, 3, 110, 20);
		add(valueField);
		
		setPreferredSize(new Dimension(270, 23));
	}

}
