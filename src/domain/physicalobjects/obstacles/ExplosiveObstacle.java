package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class ExplosiveObstacle extends Obstacle{


    public ExplosiveObstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = 1;
    }
}
