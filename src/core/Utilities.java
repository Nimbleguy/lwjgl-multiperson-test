package core;

import java.io.File;

public class Utilities{
	public static getAsset(String name){
		String n = name.replaceAll("/", File.seperator);
		return System.getProperty("user.dir") + File.seperator + "assets" + File.seperator + n;
	}
}
