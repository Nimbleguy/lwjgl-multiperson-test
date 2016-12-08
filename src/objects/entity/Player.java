package objects.entity;

public class Player extends Driver{
	public Player(ICar cart, double startX, double startY) {
		super(cart, startX, startY);
	}
	public void turnLeft(double turnInDeg){
		dir-=turnInDeg;
	}
	public void rightLeft(double turnInDeg){
		dir+=turnInDeg;
	}
}
