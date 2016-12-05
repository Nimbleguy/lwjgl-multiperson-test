package objects.entity;

public class Driver {
	int health;
	int maxHealth;
	double x;
	double y;
	double dir;//in degrees because radians are bad
	double momentum;//basically the current speed. Speed is the cart's max speed
	
	final double maxTurnPerUpdate = -1;//TODO (set as a value). Basically the maximum degrees which can be turned per update. Entered as a posative, will work as a +- though
	
	public int getHealth(){
		return health;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public double getDir(){
		return dir;
	}
}
