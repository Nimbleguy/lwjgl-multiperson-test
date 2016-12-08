package core.gl;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import java.io.File;

import core.Utilities;

public class RenderTriangle implements IRenderTask{

	private final float[] vertex = new float[] {-0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f};

	private final int prior;
	//private final ByteBuffer image;
	private int vao = -1;
	private int vboI = -1;

	private Shader shader;

	public RenderTriangle(int p, String path){
		prior = p;
		shader = new Shader(Utilities.getAsset("glsl/generic.vert"), Utilities.getAsset("glsl/generic.frag"));
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
		FloatBuffer buf = BufferUtils.createFloatBuffer(vertex.length);
		buf.put(vertex).flip();
		glBufferData(GL_ARRAY_BUFFER, buf, GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	public void run(long window){
		glClear(GL_COLOR_BUFFER_BIT);
		glUseProgram(shader.getProgram());
		glBindVertexArray(vao);
		glEnableVertexAttribArray(0);
		glDrawArrays(GL_TRIANGLES, 0, 3);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
	}

	public void destroy(){
		glDisableVertexAttribArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vboI);
		glBindVertexArray(0);
		glDeleteVertexArrays(vao);
		shader.destroy();
	}
}
