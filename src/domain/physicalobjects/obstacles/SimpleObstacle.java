package domain.physicalobjects.obstacles;

import domain.Constants;
import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import java.util.List;

public class SimpleObstacle extends Obstacle {

    public SimpleObstacle(Vector location, List<Service> services) {
        super(location,
                Constants.OBSTACLE_WIDTH, Constants.OBSTACLE_HEIGHT,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(),1, services);

    }
    @Override
    public String toString(){
        return "SimpleObstacle";
    }

}
