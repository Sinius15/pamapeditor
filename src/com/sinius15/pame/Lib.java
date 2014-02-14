package com.sinius15.pame;

import java.io.File;

public class Lib {

	public static File getPrionArchitectRootDir(){
		return new File(new File(System.getenv("APPDATA")).getParent() + "\\Local\\Introversion\\Prison Architect\\");
	}
	
}
