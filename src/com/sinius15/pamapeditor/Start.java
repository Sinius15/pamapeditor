package com.sinius15.pamapeditor;

import java.io.File;
import java.io.IOException;

import com.sinius15.pamapapi.PrisonLoader;

public class Start {
	
	public static void main(String[] args) {
		Lib.initFileStructure();
		startFileChooser();
	}
	
	public static void startFileChooser(){
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
