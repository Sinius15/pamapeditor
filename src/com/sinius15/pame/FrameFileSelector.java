package com.sinius15.pame;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

public class FrameFileSelector extends JFrame {

	private static final long serialVersionUID = 3812832175834881584L;
	private JPanel contentPane;
	private JTextField textField;

	public FrameFileSelector(final String[] files) {
		
		setTitle("Select a prison");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		JButton btnSelectFile = new JButton("select file");
		panel_1.add(btnSelectFile);
		
		JButton btnEditFile = new JButton("Edit Prison");
		panel_1.add(btnEditFile);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList<String> list = new JList<String>(files);
		list.setListData(files);
		scrollPane.setViewportView(list);
		setVisible(true);
	}

}
