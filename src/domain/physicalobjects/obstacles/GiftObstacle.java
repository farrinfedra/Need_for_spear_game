package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class GiftObstacle extends Obstacle{
    public GiftObstacle(Vector location, List<Service> services) {
        super(location,null,
                40, 40,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 1, services);

        setImage(new ImageIcon(this.getClass().getResource("/ui/assets/GiftObstacleImage.png")));
    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "GiftObstacle";
    }
}
