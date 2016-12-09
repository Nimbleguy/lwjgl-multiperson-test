package events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import core.PriorityValue;

public class MouseEvent implements Event{

	long window;
	double x;
	double y;

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Priority{
		PriorityValue value() default PriorityValue.MEDIUM;
	}

	public MouseEvent(long window, double x, double y){
		this.window = window;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean trigger(){
		return false;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public long getWindow(){
		return window;
	}
}
