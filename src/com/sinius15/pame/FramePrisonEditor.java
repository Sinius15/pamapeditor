package com.sinius15.pame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;

public class FramePrisonEditor extends JFrame {

	private static final long serialVersionUID = 7539789100657354803L;
	private JPanel contentPane;
	private JTextField textField;

	public FramePrisonEditor(Prison prison) {
		setTitle("A Prison Editor!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 884);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("General Data", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Entrys", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(8, 100, 563, 386);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane entryScroller = new JScrollPane();
		panel_1.add(entryScroller, BorderLayout.CENTER);
		entryScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel entryHolder = new JPanel();
		entryScroller.setViewportView(entryHolder);
		entryHolder.setLayout(new GridLayout(0,1));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setBounds(8, 58, 209, 32);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrisonName = new JLabel("Prison Name");
		panel_3.add(lblPrisonName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBounds(8, 12, 458, 38);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSavePrison = new JButton("Save Prison");
		panel_2.add(btnSavePrison);
		
		JButton btnSavePrisonAs = new JButton("Save Prison As...");
		panel_2.add(btnSavePrisonAs);
		
		JButton btnIgnoreChangesAnd = new JButton("Ignore Changes and Refresh");
		panel_2.add(btnIgnoreChangesAnd);
		
		for(Entry e : prison.entrys){
			entryHolder.add(new EntryPane(e.name, e.value));
			int height = (int) entryHolder.getPreferredSize().getHeight();
            Rectangle rect = new Rectangle(0,height,10,10);
            entryHolder.scrollRectToVisible(rect);
		}
		
		setVisible(true);
	}
}
