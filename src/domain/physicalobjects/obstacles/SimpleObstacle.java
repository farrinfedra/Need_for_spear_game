package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class SimpleObstacle extends Obstacle {


    public SimpleObstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = 1;

    }
}
