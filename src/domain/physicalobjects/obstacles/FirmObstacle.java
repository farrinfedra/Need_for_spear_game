package domain.physicalobjects.obstacles;

import domain.Constants;
import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class FirmObstacle extends Obstacle{
    public FirmObstacle(Vector location, List<Service> services) {
        super(location,
                Constants.OBSTACLE_WIDTH, Constants.OBSTACLE_HEIGHT,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 3, services);

    }


    @Override
    public String toString(){
        return "FirmObstacle";
    }

}
