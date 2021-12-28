package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class SimpleObstacle extends Obstacle {

    public SimpleObstacle(Vector location, List<Service> services) {
        super(location, null,
                40, 40,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(),1, services);

        setImage(new ImageIcon(this.getClass().getResource("/img/SimpleObstacleImage.png")));
    }
    @Override
    public String toString(){
        return "SimpleObstacle";
    }

    @Override
    void specialAttribute() {
        //do nothing
    }

}
