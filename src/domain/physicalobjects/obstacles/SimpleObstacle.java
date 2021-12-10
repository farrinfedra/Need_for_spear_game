package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;

import javax.swing.*;

public class SimpleObstacle extends Obstacle {

    public SimpleObstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior, 1);
    }
    @Override
    public String toString(){
        return "SimpleObstacle";
    }

    @Override
    void specialAttribute() {
        //do nothing
    }

}
