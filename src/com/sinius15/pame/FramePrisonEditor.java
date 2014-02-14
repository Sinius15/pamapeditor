package com.sinius15.pame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;

public class FramePrisonEditor extends JFrame {

	private static final long serialVersionUID = 7539789100657354803L;
	private JPanel contentPane;

	public FramePrisonEditor(Prison prison) {
		setTitle("A Prison Editor!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane entryScroller = new JScrollPane();
		tabbedPane.addTab("Basic Value's", null, entryScroller, null);
		entryScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel entryHolder = new JPanel();
		entryScroller.setViewportView(entryHolder);
		entryHolder.setLayout(new GridLayout(0,1));
		
		for(Entry e : prison.entrys){
			entryHolder.add(new EntryPane(e.name, e.value));
			int height = (int)entryHolder.getPreferredSize().getHeight();
            Rectangle rect = new Rectangle(0,height,10,10);
            entryHolder.scrollRectToVisible(rect);
		}
		
		setVisible(true);
	}
}
