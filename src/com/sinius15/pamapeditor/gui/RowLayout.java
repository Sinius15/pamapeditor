package com.sinius15.pamapeditor.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/**
 * @source http://taubler.com/articles/article_Create_a_Custom_Swing_AWT_Layout_Manager_in_Java?id=3
 */
public class RowLayout implements LayoutManager {

	private int prefWidth;
	private int prefHeight;
	private int minWidth;
	private int minHeight;
	private int rowGap = 0;
	private boolean stretch;

	public RowLayout() {
		
	}

	public RowLayout(boolean stretchComponents) {
		this.stretch = stretchComponents;
	}

	public RowLayout(int gapSize) {
		setRowGap(gapSize);
	}

	public RowLayout(int gapSize, boolean stretchComponents) {
		this.stretch = stretchComponents;
		setRowGap(gapSize);
	}

	public void setRowGap(int gapSize) {
		rowGap = gapSize;
	}

	public void setStretch(boolean stretchComponents) {
		this.stretch = stretchComponents;
	}

	 // required but unused
	public void addLayoutComponent(String name, Component comp) {
	}

	 // required but unused
	public void removeLayoutComponent(Component comp) {
	}

	public void layoutContainer(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int x = insets.left;
		int y = insets.top;
		int x2 = insets.right;
		int wDiff = x + x2;

		int ncomponents = parent.getComponentCount();
		for (int i = 0; i < ncomponents; ++i) {
			java.awt.Component comp = parent.getComponent(i);
			java.awt.Dimension d = comp.getPreferredSize();
			if (d == null)
				d = comp.getMinimumSize();
			int w = 0;
			int h = 0;
			if (d != null) {
				w = d.width;
				h = d.height;
			}
			if (stretch) {
				w = prefWidth;
			}
			if (prefWidth - wDiff < w) {
				w = prefWidth - wDiff;
			}
			comp.setBounds(x, y, w, h);
			y += (h + rowGap);
		}
	}

	public Dimension minimumLayoutSize(Container parent) {
		setSizes(parent);
		Dimension dim = new Dimension(minWidth, minHeight);
		return dim;
	}

	public Dimension preferredLayoutSize(Container parent) {
		setSizes(parent);
		Dimension dim = new Dimension(prefWidth, prefHeight);
		return dim;
	}

	private void setSizes(Container parent) {
		int nComps = parent.getComponentCount();
		Dimension d = null;

		// reset widths and heights
		prefWidth = 0;
		prefHeight = 0;
		minWidth = 0;
		minHeight = 0;

		Insets insets = parent.getInsets();
		int x = insets.left;
		int x2 = insets.right;
		int wDiff = x2 + x;

		int parentWidth = parent.getWidth();

		prefWidth += wDiff;

		for (int i = 0; i < nComps; i++) {
			Component c = parent.getComponent(i);
			if (c.isVisible()) {
				d = c.getPreferredSize();
				if (d == null)
					d = c.getMinimumSize();
				int thisWidth = d.width;
				if (thisWidth > prefWidth) {
					prefWidth = thisWidth + wDiff;
				}
				prefHeight += d.height;
				prefHeight += rowGap;
			}
		} // end for

		// below, parentWidth == 0 when the frame first launches
		if (parentWidth != 0 && prefWidth > parentWidth) {
			prefWidth = parentWidth;
		}

        prefHeight += insets.top + insets.bottom;
		minHeight = prefHeight;
		minWidth = prefWidth;
	}

}
