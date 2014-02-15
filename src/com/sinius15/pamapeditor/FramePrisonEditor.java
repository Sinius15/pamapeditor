package com.sinius15.pamapeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;

public class FramePrisonEditor extends JFrame {

	private static final long serialVersionUID = 7539789100657354803L;
	private JPanel contentPane;
	private JTextField prisonNameField;
	private JPanel dataContainer;
	private JScrollPane entryScroller;
	private JPanel buttonContainer;
	private JPanel propetyContainer;
	private JButton btnSavePrison;
	private JPanel entryHolder;
	private JButton btnIgnoreChanges;
	private JList<String> levelList;
	private JPanel entryPane;
	private JButton btnSavePrisonAs;
	private JPanel bottomContainer;
	private JLabel lbl1;
	private JPanel levelPane;

	public FramePrisonEditor(Prison prison) {
		setTitle("A Prison Editor!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		dataContainer = new JPanel();
		contentPane.add(dataContainer);
		dataContainer.setLayout(new GridLayout(0, 2, 0, 0));
		
		levelPane = new JPanel();
		dataContainer.add(levelPane);
		levelPane.setAlignmentY(Component.TOP_ALIGNMENT);
		levelPane.setPreferredSize(new Dimension(300, 386));
		levelPane.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Level", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		levelPane.setLayout(new BorderLayout(0, 0));
		
		levelList = new JList<String>();
		levelPane.add(levelList, BorderLayout.CENTER);
		
		entryPane = new JPanel();
		dataContainer.add(entryPane);
		entryPane.setAlignmentY(Component.TOP_ALIGNMENT);
		entryPane.setAlignmentX(1.0f);
		entryPane.setBorder(new TitledBorder(null, "Entrys", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entryPane.setPreferredSize(new Dimension(315, 386));
		entryPane.setLayout(new BorderLayout(0, 0));
		
		entryScroller = new JScrollPane();
		entryPane.add(entryScroller, BorderLayout.CENTER);
		entryScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		entryHolder = new JPanel();
		entryScroller.setViewportView(entryHolder);
		entryHolder.setLayout(new GridLayout(0,1));
		
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
		
		for(Entry e : prison.entrys){
			entryHolder.add(new EntryPane(e.name, e.value));
			int height = (int) entryHolder.getPreferredSize().getHeight();
            Rectangle rect = new Rectangle(0,height,10,10);
            entryHolder.scrollRectToVisible(rect);
		}
		
		setVisible(true);
	}
	public JPanel getDataContainer() {
		return dataContainer;
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
	public JList<String> getLevelList() {
		return levelList;
	}
	public JPanel getEntryPane() {
		return entryPane;
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
	public JPanel getLevelPane() {
		return levelPane;
	}
}
