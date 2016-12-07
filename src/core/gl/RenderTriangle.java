package core.gl;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;

public class RenderTriangle implements IRenderTask{

	private final double[] indicies = new double[] {-1d, -1d, 0d, 1d, -1d, 0d, 0d, 1d, 0d};

	private final int prior;
	//private final ByteBuffer image;
	private int vao = -1;
	private int vboI = -1;

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
		vboI = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboI);
		glBufferData(GL_ARRAY_BUFFER, indicies, GL_STATIC_DRAW);
		glVertexAttribPointer(0, 4, GL_DOUBLE, false, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	public void run(long window){
		glBindVertexArray(vao);
		glEnableVertexAttribArray(0);
		glDrawArrays(GL_TRIANGLES, 0, indicies.length);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
	}

	public void destroy(){
		glDisableVertexAttribArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vboI);
		glBindVertexArray(0);
		glDeleteVertexArrays(vao);
	}
}
