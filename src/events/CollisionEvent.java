package events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import core.Main;
import entity.Entity;

public class CollisionEvent implements Event{
	
	Entity e1;
	Entity e2;
	
	boolean cancel = false;
	
	public CollisionEvent(Entity agressor, Entity defender){
		e1 = agressor;
		e2 = defender;
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Listener{
	}
	
	public boolean isCancelled(){
		return cancel;
	}
	
	@Override
	public boolean trigger(){
		for (events.Listener l : Main.getListeners()){
			try{
				if (l.getClass().getMethod("listen", Event.class).isAnnotationPresent(Listener.class)){
					l.listen(this);
				}
			}catch (NoSuchMethodException e){
				e.printStackTrace();
			}catch (SecurityException e){
				e.printStackTrace();
			}
		}
		return !isCancelled();
	}
}
