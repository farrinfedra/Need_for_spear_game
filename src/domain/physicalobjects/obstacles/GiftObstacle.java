package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class GiftObstacle extends Obstacle{
    public GiftObstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior, 1);
    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "GiftObstacle";
    }
}
