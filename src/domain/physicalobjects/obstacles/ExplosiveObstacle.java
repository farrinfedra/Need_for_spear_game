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
        super(location, null,100, 100,
                new StationaryMovementBehavior(),
                new ExplosiveObstacleCollisionBehavior(), 1, services,
                new SphereBoundingBox(location.add(new Vector(50,50)),50));

        setImage(new ImageIcon(this.getClass().getResource("/ui/assets/ExplosiveObstacleImage.png")));
    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "ExplosiveObstacle";
    }
}
