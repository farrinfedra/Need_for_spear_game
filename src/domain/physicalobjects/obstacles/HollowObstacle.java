package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class HollowObstacle extends Obstacle{
    public HollowObstacle(Vector location, List<Service> services) {
        super(location, null,
                100, 100,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 1, services);

        setImage(new ImageIcon(super.getClass().getResource("/ui/assets/giftObstacleImage.png")));
    }

    @Override
    void specialAttribute() {

    }
}
