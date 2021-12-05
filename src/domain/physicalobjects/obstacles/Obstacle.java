package domain.physicalobjects.obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public abstract class Obstacle extends PhysicalObject {
    int health;
    abstract void specialAttribute();


    public Obstacle(Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
    }

    //Returns true if broken.
    public Boolean decreaseHealth(int damage){
        if (this.health <= damage){
            this.specialAttribute();
            return true;
        } else {
            this.health -= damage;
            return false;
        }
    }

    public abstract int getHealth();
    public abstract int getX();
    public abstract int getY();
}
