package domain.abilities;

import java.util.ArrayList;
import java.util.Random;

import domain.Constants;
import domain.Game;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.ObstacleFactory;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.services.GameBoardServiceFactory;

public class HollowPurpleAbility extends Ability {

	public HollowPurpleAbility(ArrayList<PhysicalObject> physicalObjectsList) {
		super(physicalObjectsList);
	}

	@Override
	public void perform() {
		Vector location = new Vector(30, 50);
		for (int i = 0; i< Constants.HOLLOW_OBSTACLE_NUMBER; i++){
			Obstacle obstacle = Game.getInstance().getGameBoard().addObstacle(ObstacleType.HollowObstacle, location);

			Random rand = new Random();
			Vector size = Game.getInstance().getGameBoard().getSize();
			double X = size.getX();
	    	double Y = size.getY();
	    	int MAX_X =(int) (50*(int)(X/50)- (int)(50/2));
	    	int MAX_Y = /*(int) (50*(int)(Y/50)- (int)(Y/5));*/(int) Y-100;
			location = new Vector(MAX_X, MAX_Y);
			obstacle.getService(1).perform(obstacle);
		}

	}

	@Override
	public void revert() {

	}
}
