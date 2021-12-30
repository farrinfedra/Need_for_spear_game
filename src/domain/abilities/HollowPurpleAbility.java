package domain.abilities;

import java.util.ArrayList;

import domain.Game;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.ObstacleFactory;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.services.GameBoardServiceFactory;

public class HollowPurpleAbility extends Ability {
	int HOLLOW_OBSTACLE_NUMBER_CONSTANT = 8;

	public HollowPurpleAbility(ArrayList<PhysicalObject> physicalObjectsList) {
		super(physicalObjectsList);
	}

	@Override
	public void perform() {
		Vector location = new Vector(30, 50);
		for (int i=0; i<HOLLOW_OBSTACLE_NUMBER_CONSTANT; i++){
			Obstacle obstacle = Game.getInstance().getGameBoard().addObstacle(ObstacleType.HollowObstacle, location);
			location = new Vector(40 + i*50, 100);
			obstacle.getService(1).perform(obstacle);
		}

	}

	@Override
	public void revert() {

	}
}
