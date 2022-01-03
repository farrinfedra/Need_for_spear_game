package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;
import domain.Constants;
import java.util.List;

public class HollowObstacle extends Obstacle{
    public HollowObstacle(Vector location, List<Service> services) {
        super(location,
                Constants.OBSTACLE_WIDTH, Constants.OBSTACLE_HEIGHT,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 1, services);
    }


}
