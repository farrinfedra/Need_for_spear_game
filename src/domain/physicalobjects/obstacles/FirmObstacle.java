package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.boundingbox.BoundingBox;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class FirmObstacle extends Obstacle{


    @Override
    void specialAttribute() {

    }

    public FirmObstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = 3;
    }
    @Override
    public String toString(){
        return "FirmObstacle";
    }
}
