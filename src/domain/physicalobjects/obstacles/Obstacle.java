package domain.physicalobjects.obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public abstract class Obstacle extends PhysicalObject {
    int health;


    public Obstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
    }
}
