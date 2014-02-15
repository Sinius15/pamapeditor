package com.sinius15.pamapeditor;

import java.io.File;

import javax.swing.JOptionPane;

import com.sinius15.lib.YAMLFile;

public class Lib {

	public static final String VERSION = "0.1";
	public static final File DATA_FOLDER = new File(System.getenv("APPDATA") + "\\Sinius\\pamapeditor");
	public static final File CONFIG_FILE = new File(System.getenv("APPDATA") + "\\Sinius\\pamapeditor\\config.yml");
	
	public static void initFileStructure(){
		if(!DATA_FOLDER.exists())
			DATA_FOLDER.mkdirs();
		if(CONFIG_FILE.exists()){
			YAMLFile file = new YAMLFile(true);
			//TODO: make some things configurable  XD
			
			try {
				file.Save(CONFIG_FILE);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something went wrong while saving the config file." + System.lineSeparator() + 
						"Error: " + e.getMessage() , "fatal error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
			
	}
	public static File getPrionArchitectRootDir(){
		return new File(new File(System.getenv("APPDATA")).getParent() + "\\Local\\Introversion\\Prison Architect\\");
	}
	
}
