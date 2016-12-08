package core;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.glfw.GLFWKeyCallback;

import events.KeyEvent;
import events.Listener;
import static org.lwjgl.glfw.GLFW.*;

public class KeyboardHandler extends GLFWKeyCallback{

	public static boolean[] keys = new boolean[65536];
	private static HashMap<Integer,ArrayList<Listener>> listeners = new HashMap<Integer,ArrayList<Listener>>();

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		if (listeners.containsKey(key) && keys[key] != (action!=GLFW_RELEASE)){
			for (Listener l : listeners.get(key)){
				l.listen(new KeyEvent(action != GLFW_RELEASE));
			}
		}
		keys[key] = action != GLFW_RELEASE;
	}

	public static boolean isKeyDown(int keycode) {
		return keys[keycode];
	}

	public static void registerKeyListener(int keyNum, Listener l){
		ArrayList<Listener> list = new ArrayList<Listener>();
		if (listeners.containsKey(keyNum)){
			list = listeners.get(keyNum);
		}
		list.add(l);
		listeners.put(keyNum, list);
	}

	public static HashMap<Integer,ArrayList<Listener>> getKeyListeners(){
		return listeners;
	}
}
