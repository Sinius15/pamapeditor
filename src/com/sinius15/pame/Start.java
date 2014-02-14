package com.sinius15.pame;

import java.io.File;

public class Start {
	
	public static void main(String[] args) {
		Lib.initFileStructure();
		startFileChooser();
	}
	
	public static void startFileChooser(){
		new FrameFileSelector(Util.getAllPrisonsOnDisk());
	}
	
	public static void startEditor(File prison){
		new FramePrisonEditor();
	}
}
