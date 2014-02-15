package com.sinius15.pamapeditor.helpers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SLine extends Line2D{

	private int x1, x2, y1, y2;
	
	public SLine(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return new Rectangle(x1, y2, Math.abs(x1-x2), Math.abs(y1-y2));
	}

	@Override
	public double getX1() {
		return x1;
	}

	@Override
	public double getY1() {
		return y1;
	}

	@Override
	public Point2D getP1() {
		return new Point(x1, y1);
	}

	@Override
	public double getX2() {
		return x2;
	}

	@Override
	public double getY2() {
		return y2;
	}

	@Override
	public Point2D getP2() {
		return new Point(x2, y2);
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		throw new NullPointerException("Not implemented yet");
	}

}
