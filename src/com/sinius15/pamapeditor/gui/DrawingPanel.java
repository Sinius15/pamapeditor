package com.sinius15.pamapeditor.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class DrawingPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Line2D> lines = new ArrayList<>();
	
	public DrawingPanel(){
		setBackground(new Color(0, 0, 0, 0));
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(UIManager.getColor("Panel.background" ));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		for(Line2D l : lines){
			g.drawLine((int)l.getX1(), (int)l.getY1(), (int)l.getX2(), (int)l.getY2());
		}
		super.paint(g);
	}
	
	public void addLine(Line2D l){
		lines.add(l);
	}

}
