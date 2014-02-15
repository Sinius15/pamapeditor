package com.sinius15.pamapeditor.helpers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.sinius15.pamapapi.DataBlock;
import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;
import com.sinius15.pamapeditor.gui.JLine;

public class GuiHandler {

	private JPanel levelPane, entryPane;
	private Prison prison;
	private ArrayList<Component> comps = new ArrayList<>();
	
	public GuiHandler(JPanel levelHolder, JPanel entryHolder, Prison prison){
		this.levelPane = levelHolder;
		this.entryPane = entryHolder;
		this.prison = prison;
		
		JToggleButton button = new JToggleButton(prison.name);
		button.setBounds(5, 5, prison.name.length()*10+20, 25);
		comps.add(button);
		comps.add(new JLine(new Point(0, 0), new Point(200, 20)));
		int x = 0;
		for(DataBlock block : this.prison.dataBlocks){
			button = new JToggleButton(block.name);
			button.setBounds(x*120+5, 50, 100, 20);
			comps.add(button);
			x++;
		}
		
		
		
		levelPane.setPreferredSize(new Dimension(x*120+200, 100));
		for(Component b : comps){
			levelPane.add(b);
		}
		
		updateEntrys(prison);
	}
	
	public void updateEntrys(DataBlock b){
		entryPane.removeAll();
		for(Entry e : b.entrys)
			entryPane.add(new EntryPane(e));
		int height = (int) entryPane.getPreferredSize().getHeight();
		Rectangle rect = new Rectangle(0,height,10,10);
		entryPane.scrollRectToVisible(rect);
	}
	
}
