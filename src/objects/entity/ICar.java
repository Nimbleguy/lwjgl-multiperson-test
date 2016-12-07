package objects.entity;

public interface ICar {
	double startSpeed = -1;
	double accelerationSpeed = -1;
	double traction = -1;
	public default double getStartSpeed(){
		return startSpeed;
	}
	public default double getAccellerationSpeed(){
		return accelerationSpeed;
	}
	public default double getTraction(){
		return traction;
	}
}
