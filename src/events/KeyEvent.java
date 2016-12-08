package events;

public class KeyEvent implements Event{//SPECIAL EVENT: CANNOT BE TRIGGERED WITH trigger()!!
	boolean isDown;
	
	public KeyEvent(boolean isPressed){
		isDown = isPressed;
	}
	
	public boolean isPressed(){
		return isDown;
	}
	
	public boolean trigger(){
		return false;
	}
}
