package com.sinius15.pame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

	public FramePrisonEditor(Prison prison) {
		setTitle("A Prison Editor!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel dataContainer = new JPanel();
		contentPane.add(dataContainer);
		dataContainer.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel levelPane = new JPanel();
		dataContainer.add(levelPane);
		levelPane.setAlignmentY(Component.TOP_ALIGNMENT);
		levelPane.setPreferredSize(new Dimension(300, 386));
		levelPane.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Level", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		levelPane.setLayout(new BorderLayout(0, 0));
		
		JList<String> levelList = new JList<String>();
		levelPane.add(levelList, BorderLayout.CENTER);
		
		JPanel entryPane = new JPanel();
		dataContainer.add(entryPane);
		entryPane.setAlignmentY(Component.TOP_ALIGNMENT);
		entryPane.setAlignmentX(1.0f);
		entryPane.setBorder(new TitledBorder(null, "Entrys", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entryPane.setPreferredSize(new Dimension(315, 386));
		entryPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane entryScroller = new JScrollPane();
		entryPane.add(entryScroller, BorderLayout.CENTER);
		entryScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel entryHolder = new JPanel();
		entryScroller.setViewportView(entryHolder);
		entryHolder.setLayout(new GridLayout(0,1));
		
		JPanel bottomContainer = new JPanel();
		contentPane.add(bottomContainer, BorderLayout.SOUTH);
		bottomContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel propetyContainer = new JPanel();
		bottomContainer.add(propetyContainer);
		propetyContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl1 = new JLabel("Prison Name");
		propetyContainer.add(lbl1);
		
		prisonNameField = new JTextField();
		propetyContainer.add(prisonNameField);
		prisonNameField.setColumns(10);
		
		JPanel buttonContainer = new JPanel();
		bottomContainer.add(buttonContainer);
		buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSavePrison = new JButton("Save Prison");
		buttonContainer.add(btnSavePrison);
		
		JButton btnSavePrisonAs = new JButton("Save Prison As...");
		buttonContainer.add(btnSavePrisonAs);
		
		JButton btnIgnoreChangesAnd = new JButton("Ignore Changes and Refresh");
		buttonContainer.add(btnIgnoreChangesAnd);
		
		for(Entry e : prison.entrys){
			entryHolder.add(new EntryPane(e.name, e.value));
			int height = (int) entryHolder.getPreferredSize().getHeight();
            Rectangle rect = new Rectangle(0,height,10,10);
            entryHolder.scrollRectToVisible(rect);
		}
		
		setVisible(true);
	}
}
