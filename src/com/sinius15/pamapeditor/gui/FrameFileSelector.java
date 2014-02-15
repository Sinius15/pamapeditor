package com.sinius15.pamapeditor.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sinius15.pamapeditor.Start;
import com.sinius15.pamapeditor.Util;

public class FrameFileSelector extends JFrame {

	private static final long serialVersionUID = 3812832175834881584L;
	private JPanel contentPane;
	private JTextField fileField;
	private JList<String> list;
	private JButton editButton;
	private JButton selectButton;

	public FrameFileSelector(final String[] files) {
		
		setTitle("Select a prison");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		fileField = new JTextField();
		panel_1.add(fileField);
		fileField.setColumns(15);
		
		selectButton = new JButton("select file");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				filechooser.setAcceptAllFileFilterUsed(false);
				filechooser.setDialogType(JFileChooser.OPEN_DIALOG);
				int returnErrorNR = filechooser.showSaveDialog(null);
				if(returnErrorNR != 0)
					return;
				String path = filechooser.getSelectedFile().getAbsolutePath();
				getFileField().setText(path);
			}
		});
		selectButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(selectButton);
		
		editButton = new JButton("Edit Prison");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start.startEditor(Util.getPrisonFile(getList().getSelectedValue()));
				dispose();
			}
		});
		editButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(editButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<String>();
		list.setFont(new Font("Dialog", Font.PLAIN, 12));
		list.setListData(files);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
					getFileField().setText(Util.getPrisonFile(getList().getSelectedValue()).getAbsolutePath());
			}
		});
		scrollPane.setViewportView(list);
		setVisible(true);
	}

	public JList<String> getList() {
		return list;
	}
	public JButton getEditButton() {
		return editButton;
	}
	public JButton getSelectButton() {
		return selectButton;
	}
	public JTextField getFileField() {
		return fileField;
	}
}
