package com.sinius15.pame;

import java.io.File;
import java.util.ArrayList;

public class Start {
	
	public static void main(String[] args) {
		new FrameFileSelector(getAllPrisons());
	}
	
	public static String[] getAllPrisons(){
		File[] f = new File(new File(System.getenv("APPDATA")).getParent() + "\\Local\\Introversion\\Prison Architect\\saves\\").listFiles();
		ArrayList<String> out = new ArrayList<>();
		for(File g : f){
			if(g.isFile() && g.getName().endsWith(".prison"))
				out.add(g.getName());
		}
		return out.toArray(new String[out.size()]);
	}
	
	public static File getPrisonFile(String prisonName){
		return null;
	}
	
}
