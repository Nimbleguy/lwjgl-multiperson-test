package core.gl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Shader{
	public static HashMap<String, List<String>> progs = new HashMap<String, List<String>>();

	private final int prog;

	public Shader(String vertex, String fragment){
		if(progs.get(vertex) != null && progs.get(vertex).contains(fragment)){
			// this is a check for if we already genned prog. We should store genned progs.
		}
		prog = 0; // temp for compile
	}
}
