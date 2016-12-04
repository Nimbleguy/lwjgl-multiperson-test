package core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL;

import core.gl.Render;
import core.gl.RenderTaskClear;

public class Main{
	private long win;
	private static Main main;
	private Render rend;

	private Main(){
		if(!glfwInit()){ // Start.
			System.err.println("Error initializing glfw.");
			System.exit(1);
		}
		setHints();
		win = glfwCreateWindow(800, 600, "GLFW", NULL, NULL);
		if(win == NULL){
			System.err.println("Error with window init.");
			System.exit(1);
		}

		glfwMakeContextCurrent(win);
		GL.createCapabilities(true);
		glfwSwapInterval(1);
		start();

		glfwDestroyWindow(win);
		glfwTerminate(); // Exit.
	}

	private void setHints(){
		glfwWindowHint(GLFW_FLOATING, GLFW_TRUE);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
	}

	private void start(){
		rend = new Render();
		rend.add(new RenderTaskClear());
		while(!glfwWindowShouldClose(win)){
			rend.render(win);
		}
	}

	public static void main(String[] args){
		main = new Main();
	}
}
