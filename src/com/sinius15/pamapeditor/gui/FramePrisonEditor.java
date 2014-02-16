package com.sinius15.pamapeditor.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.sinius15.pamapapi.Prison;

public class FramePrisonEditor extends JFrame {

	private static final long serialVersionUID = 7539789100657354803L;
	private JPanel contentPane;
	private JTextField prisonNameField;
	private JScrollPane entryScroller;
	private JPanel buttonContainer;
	private JPanel propetyContainer;
	private JButton btnSavePrison;
	private JPanel entryHolder;
	private JButton btnIgnoreChanges;
	private JButton btnSavePrisonAs;
	private JPanel bottomContainer;
	private JLabel lbl1;
	private JSplitPane splitPane;
	private JScrollPane levelScroller;
	private DrawingPanel levelHolder;

	public FramePrisonEditor(Prison prison) {
		setTitle("A Prison Editor!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		entryScroller = new JScrollPane();
		splitPane.setRightComponent(entryScroller);
		entryScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		entryHolder = new JPanel();
		entryScroller.setViewportView(entryHolder);
		entryHolder.setLayout(new RowLayout(2, false));
		
		levelScroller = new JScrollPane();
		levelScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setLeftComponent(levelScroller);
		
		levelHolder = new DrawingPanel();
		levelScroller.setViewportView(levelHolder);
		levelHolder.setLayout(null);
		
		bottomContainer = new JPanel();
		contentPane.add(bottomContainer, BorderLayout.SOUTH);
		bottomContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		propetyContainer = new JPanel();
		bottomContainer.add(propetyContainer);
		propetyContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbl1 = new JLabel("Prison Name");
		propetyContainer.add(lbl1);
		
		prisonNameField = new JTextField();
		propetyContainer.add(prisonNameField);
		prisonNameField.setColumns(10);
		
		buttonContainer = new JPanel();
		bottomContainer.add(buttonContainer);
		buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSavePrison = new JButton("Save Prison");
		buttonContainer.add(btnSavePrison);
		
		btnSavePrisonAs = new JButton("Save Prison As...");
		buttonContainer.add(btnSavePrisonAs);
		
		btnIgnoreChanges = new JButton("Ignore Changes and Refresh");
		buttonContainer.add(btnIgnoreChanges);
		
		new GuiHandler(levelHolder, entryHolder, prison);
		
		revalidate();
		setVisible(true);
		
		splitPane.setDividerLocation(0.5);
	}
	
	public JScrollPane getEntryScroller() {
		return entryScroller;
	}
	public JPanel getButtonContainer() {
		return buttonContainer;
	}
	public JPanel getPropetyContainer() {
		return propetyContainer;
	}
	public JButton getBtnSavePrison() {
		return btnSavePrison;
	}
	public JPanel getEntryHolder() {
		return entryHolder;
	}
	public JButton getBtnIgnoreChanges() {
		return btnIgnoreChanges;
	}
	public JTextField getPrisonNameField() {
		return prisonNameField;
	}
	public JButton getBtnSavePrisonAs() {
		return btnSavePrisonAs;
	}
	public JPanel getBottomContainer() {
		return bottomContainer;
	}
	public JLabel getLbl1() {
		return lbl1;
	}
	public JPanel getLevelHolder() {
		return levelHolder;
	}
}
