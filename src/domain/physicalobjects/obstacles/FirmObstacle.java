package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.GameBoardService;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class FirmObstacle extends Obstacle{
    public FirmObstacle(Vector location, List<Service> services) {
        super(location, null,
                40, 40,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 3, services);

        setImage(new ImageIcon(super.getClass().getResource("/img/FirmObstacleImage.png")));
    }

    @Override
    void specialAttribute() {

    }
    @Override
    public String toString(){
        return "FirmObstacle";
    }

}
