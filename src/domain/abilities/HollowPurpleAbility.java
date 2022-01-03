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
			location = new Vector(rand.nextInt((int) size.getX()), rand.nextInt((int)size.getY()));
			obstacle.getService(1).perform(obstacle);
		}

	}

	@Override
	public void revert() {

	}
}
