package core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL;

public class Main{
	private static long window;
	private static Main main;

	int HEIGHT = 200;
	int WIDTH = 200;
	String title = "a most tedious game";

	private Main(){
		if (!glfwInit()){
			glfwTerminate();
			System.err.println("Error initializing GLFW");
			System.exit(1);
		}

		window = glfwCreateWindow(WIDTH, HEIGHT, title, NULL, NULL);

		if (window == NULL){
			glfwTerminate();
			System.err.println("Error creating window");
			System.exit(1);
		}

		glfwWindowHint(GLFW_SAMPLES, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		glfwSwapInterval(1);
	}

	private void init(){
		System.out.println("Window initialized");
	}

	private void dispose(){
		System.out.println("Window terminated");
		glfwDestroyWindow(window);
		glfwTerminate();
		System.exit(0);
	}

	private void start(){
		@SuppressWarnings("unused")
		float now,
		last,
		delta;

		last = 0;

		init();

		while (glfwWindowShouldClose(window) == false){
			now = (float) glfwGetTime();
			delta = now - last;
			last = now;

			glfwPollEvents();
			glfwSwapBuffers(window);
		}

		dispose();
	}

	public static void main(String[] args){
		main = new Main();
		main.start();
		new Thread(()->{
			try{
				Thread.sleep(10000L);
				new Main().dispose();
			}catch (Exception e){
				e.printStackTrace();
			}
		},"t1");
	}
}
