package objects.entity;

public class Driver {
	int health;
	int maxHealth;
	ICar car;
	double x;
	double y;
	double dir;//in degrees because radians are bad
	double momentum;//basically the current speed. Speed is the cart's max speed
	
	static final double MAX_SPEED = -1;
	static final double MAX_TURN_PER_UPDATE = -1;//TODO (set as a value). Basically the maximum degrees which can be turned per update. Entered as a positive, will work as a +- though

	public Driver(ICar cart, double startX, double startY){
		x = startX;
		y = startY;
		car = cart;
		momentum = car.getStartSpeed();
	}
	
	public void update(){
		if ("button".equals("w")){//TODO if w is pressed
			momentum+=car.getAccellerationSpeed();
			if (momentum>MAX_SPEED){
				momentum=MAX_SPEED;
			}
			if (momentum<car.getStartSpeed()){
				momentum=car.getStartSpeed();
			}
		}else{
			momentum-=car.getTraction();
			if (momentum<0){
				momentum=0;
			}
		}
	}
	
	public int getHealth(){
		return health;
	}

	public int getMaxHealth(){
		return maxHealth;
	}

	public double getDir(){
		dir%=360;
		if (dir<0){
			dir+=360;
		}
		return dir;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public int getRenderX(){
		return (int)Math.round(x);
	}

	public int getRenderY(){
		return (int)Math.round(y);
	}

	public void setX(int newX){
		x = newX;
	}

	public void setY(int newY){
		y = newY;
	}

}
