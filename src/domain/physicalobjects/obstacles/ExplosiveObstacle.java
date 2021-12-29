package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ExplosiveObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.physicalobjects.boundingbox.SphereBoundingBox;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class ExplosiveObstacle extends Obstacle{

    public ExplosiveObstacle(Vector location, List<Service> services) {
        super(location,40, 40,
                new StationaryMovementBehavior(),
                new ExplosiveObstacleCollisionBehavior(), 1, services,
                new SphereBoundingBox(location.add(new Vector(20,20)),20));

    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "ExplosiveObstacle";
    }
}
