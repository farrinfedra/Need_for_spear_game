package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class SimpleObstacle extends Obstacle {


    @Override
    void specialAttribute() {
        //do nothing
    }

    public SimpleObstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = 1;

    }
    @Override
    public String toString(){
        return "SimpleObstacle";
    }

    public int getHealth(){
        return health;
    }
    public int getX(){
        return getLocation().getX();
    }
    public int getY(){
        return getLocation().getY();
    }
}
