package com.sinius15.pamapeditor;

import java.io.File;
import java.util.ArrayList;

public class Util {

	public static String[] getAllPrisonsOnDisk(){
		File[] f = new File(Lib.getPrionArchitectRootDir().getAbsolutePath() + "\\saves\\").listFiles();
		ArrayList<String> out = new ArrayList<>();
		for(File g : f){
			if(g.isFile() && g.getName().endsWith(".prison"))
				out.add(g.getName().replaceAll("\\.prison", ""));
		}
		return out.toArray(new String[out.size()]);
	}
	
	public static File getPrisonFile(String prisonName){
		return new File(Lib.getPrionArchitectRootDir().getAbsolutePath() + "\\saves\\" + prisonName + ".prison");
	}
	
}
