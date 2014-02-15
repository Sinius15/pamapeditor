package com.sinius15.pamapeditor.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class JLine extends JPanel{
	private static final long serialVersionUID = 1L;
	private Point a, b;
	public JLine(Point a, Point b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(a.x, a.y, b.x, b.y);
		super.paint(g);
	}

}
