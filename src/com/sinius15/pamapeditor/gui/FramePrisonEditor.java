package com.sinius15.pamapeditor.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sinius15.pamapapi.DataBlock;
import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;
import com.sinius15.pamapeditor.helpers.VisualEntry;

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
	private JPanel levelHolder;
	private JToggleButton tglbtnNewToggleButton;
	private JToggleButton tglbtnNewToggleButton_1;
	private JToggleButton tglbtnNewToggleButton_2;
	private JToggleButton tglbtnNewToggleButton_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public FramePrisonEditor(Prison prison) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
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
		entryHolder.setLayout(new GridLayout(0,1,0,0));
		
		levelScroller = new JScrollPane();
		levelScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setLeftComponent(levelScroller);
		
		levelHolder = new JPanel();
		levelScroller.setViewportView(levelHolder);
		levelHolder.setLayout(null);
		
		tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(0, 1, 121, 110);
		buttonGroup.add(tglbtnNewToggleButton);
		levelHolder.add(tglbtnNewToggleButton);
		
		tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_1.setBounds(0, 111, 121, 110);
		buttonGroup.add(tglbtnNewToggleButton_1);
		levelHolder.add(tglbtnNewToggleButton_1);
		
		tglbtnNewToggleButton_2 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_2.setBounds(0, 221, 121, 110);
		buttonGroup.add(tglbtnNewToggleButton_2);
		levelHolder.add(tglbtnNewToggleButton_2);
		
		tglbtnNewToggleButton_3 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_3.setBounds(0, 331, 121, 110);
		buttonGroup.add(tglbtnNewToggleButton_3);
		levelHolder.add(tglbtnNewToggleButton_3);
		
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
			entryHolder.add(new VisualEntry(e));
			int height = (int) entryHolder.getPreferredSize().getHeight();
            Rectangle rect = new Rectangle(0,height,10,10);
            entryHolder.scrollRectToVisible(rect);
		}
		for(DataBlock b : prison.dataBlocks){
			
		}
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
