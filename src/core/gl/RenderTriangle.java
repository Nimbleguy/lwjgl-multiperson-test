package core.gl;

import static org.lwjgl.opengl.GL30.*;

import java.nio.ByteBuffer;

public class RenderTriangle implements IRenderTask{

	private final int prior;
	//private final ByteBuffer image;
	private int vao = -1;

	public RenderTriangle(int p, String path){
		prior = p;
	}

	public int priority(){
		return prior;
	}

	public boolean remove(){
		return false;
	}

	public void init(){
		vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
	}

	public void run(long window){
		
	}

	public void destroy(){
		
	}
}
