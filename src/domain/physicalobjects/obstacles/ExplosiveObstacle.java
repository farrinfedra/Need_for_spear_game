package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.collision.ExplosiveObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.GameBoardService;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class ExplosiveObstacle extends Obstacle{

    public ExplosiveObstacle(Vector location, List<Service> services) {
        super(location, null,40, 40,
                new StationaryMovementBehavior(),
                new ExplosiveObstacleCollisionBehavior(), 1, services);

        setImage(new ImageIcon(this.getClass().getResource("/img/ExplosiveObstacleImage.png")));
    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "ExplosiveObstacle";
    }
}
