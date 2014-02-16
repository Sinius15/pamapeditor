package com.sinius15.pamapeditor.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.sinius15.pamapapi.DataBlock;
import com.sinius15.pamapapi.Entry;
import com.sinius15.pamapapi.Prison;

public class GuiHandler {

	private DrawingPanel levelPane;
	private JPanel entryPane;
	private ButtonGroup bGroup = new ButtonGroup();
	private Prison prison;
	private ArrayList<Component> comps = new ArrayList<>();
	private JToggleButton button;
	private int maxVerticalButtons = 1;
	private HashMap<Point, String> pointToDataBlock = new HashMap<>(65536);
	
	public GuiHandler(DrawingPanel levelHolder, JPanel entryHolder, Prison prison){
		
		this.levelPane = levelHolder;
		this.entryPane = entryHolder;
		this.prison = prison;
		
		//root button
		button = new JToggleButton(prison.name);
		int w = prison.name.length()*10+20;
		button.setBounds(5, 5, w, 25);
		pointToDataBlock.put(new Point(5, 5), "root");
		comps.add(button);
		//root to horizontal line
		levelPane.addLine(new SLine(w/2, 10, w/2, 40));
		
		int x = 0;
		for(DataBlock block : this.prison.dataBlocks){
			button = new JToggleButton(block.name);
			w = x*200+5;
			button.setBounds(w, 60, 100, 20);
			pointToDataBlock.put(new Point(w, 60), block.referencePath);
			comps.add(button);
			//btn to big horizontal line  (so it goes up)
			levelPane.addLine(new SLine(w+50, 70, w+50, 40));
			int r = addSubBlocks(block, new Point(w, 60));
			if(r>maxVerticalButtons)
				maxVerticalButtons = r;
			x++;
		}
		
		levelPane.setPreferredSize(new Dimension(x*200+5, maxVerticalButtons*30+100));
		//horizontal line
		levelPane.addLine(new SLine(5, 40, x*200-100, 40));
		//adding comps
		for(Component b : comps){
			if(b instanceof JToggleButton){
				JToggleButton but = ((JToggleButton) b);
				but.addActionListener(actionListener);
				bGroup.add(but);
			}
			levelPane.add(b);
		}
		
		levelPane.repaint();
		
		updateEntrys(prison);
	}
	
	private int addSubBlocks(DataBlock b, Point parentBtnCoord){
		int x = parentBtnCoord.x; int y = parentBtnCoord.y;
		int n = 0;
		for(DataBlock block : b.dataBlocks){
			//horizontal line to the button
			levelPane.addLine(new SLine(x+2, y+40+30*n, x+7, y+40+30*n));
			
			JToggleButton button = new JToggleButton(block.name);
			button.setBounds(x+7, y+30+30*n, 100, 20);
			pointToDataBlock.put(new Point(x+7, y+30+30*n), block.referencePath);
			comps.add(button);
			//pointToDataBlock.put(new Point(x+7, y+30+30*n), b);
			n+= addSubBlocks(block, new Point(x+7, y+30+30*n))+1;
		}
		//vertical line through all the small horizontal lines if there is a subblock
		if(n > 0)
			levelPane.addLine(new SLine(x+2, y+15, x+2, y+15+30*n));
		//returns the amount of added buttons
		return n;
	}
	
	public void updateEntrys(DataBlock b){
		synchronized (this) {
			entryPane.removeAll();
			for(Entry e : b.entrys)
				entryPane.add(new EntryPane(e));
			int height = (int) entryPane.getPreferredSize().getHeight();
			Rectangle rect = new Rectangle(0,height,10,10);
			entryPane.scrollRectToVisible(rect);
			entryPane.revalidate();
			entryPane.repaint();
		}
		
	}
	
	private ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JToggleButton){
				JToggleButton but = (JToggleButton) e.getSource();
				String s = pointToDataBlock.get(new Point(but.getX(), but.getY()));
				if(s.equals("root"))
					updateEntrys(prison);
				else
					updateEntrys(prison.getBlock(s));
			}
		}
	};
	
}
