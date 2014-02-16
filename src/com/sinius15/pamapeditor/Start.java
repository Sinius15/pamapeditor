package com.sinius15.pamapeditor;

import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sinius15.pamapapi.PrisonLoader;
import com.sinius15.pamapeditor.gui.FrameFileSelector;
import com.sinius15.pamapeditor.gui.FramePrisonEditor;

public class Start {
	
	public static void main(String[] args) {
		Lib.initFileStructure();
		startFileChooser();
	}
	
	public static void startFileChooser(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		new FrameFileSelector(Util.getAllPrisonsOnDisk());
	}
	
	public static void startEditor(File prisonFile){
		try {
			new FramePrisonEditor(PrisonLoader.loadPrison(prisonFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
