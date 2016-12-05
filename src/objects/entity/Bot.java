package objects.entity;

import objects.maps.MapInterpreter;

public class Bot extends Driver{

	int[] destination = new int[2];
	boolean reachedDestination;

	MapInterpreter aiMap;

	public Bot(MapInterpreter mi){
		aiMap = mi;
	}

	public void update(){
		if (reachedDestination){
			switch(aiMap.getDir((int)Math.round(x), (int)Math.round(y))){
			case -1:
				//TODO
				break;
			case 0://N
				destination[0]=(int)Math.round(x);
				destination[1]=(int)Math.round(y)+1;
				break;
			case 1://NE
				destination[0]=(int)Math.round(x)+1;
				destination[1]=(int)Math.round(y)+1;
				break;
			case 2://E
				destination[0]=(int)Math.round(x)+1;
				destination[1]=(int)Math.round(y);
				break;
			case 3://SE
				destination[0]=(int)Math.round(x)+1;
				destination[1]=(int)Math.round(y)-1;
				break;
			case 4://S
				destination[0]=(int)Math.round(x);
				destination[1]=(int)Math.round(y)-1;
				break;
			case 5://SW
				destination[0]=(int)Math.round(x)-1;
				destination[1]=(int)Math.round(y)-1;
				break;
			case 6://W
				destination[0]=(int)Math.round(x)-1;
				destination[1]=(int)Math.round(y);
				break;
			case 7://NW
				destination[0]=(int)Math.round(x)-1;
				destination[1]=(int)Math.round(y)+1;
				break;
			}

			reachedDestination = false;
		}

		double angle = Math.toDegrees(Math.tan((destination[1]-y)/(destination[0]-x)));
		double moveAngle = Math.min(maxTurnPerUpdate, Math.abs(angle));

		if (angle<0){
			moveAngle*=-1;
		}

		x+=momentum*Math.acos(Math.toRadians(moveAngle));
		y+=momentum*Math.asin(Math.toRadians(moveAngle));

		if (destination[0] == (int)(Math.round(x)) && destination[1] == (int)(Math.round(y))){
			reachedDestination = true;
		}
	}
}
