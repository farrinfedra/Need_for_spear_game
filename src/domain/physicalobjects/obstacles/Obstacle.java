package domain.physicalobjects.obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;
import java.util.Objects;

public abstract class Obstacle extends PhysicalObject {
    private int health;
    abstract void specialAttribute();

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = health;
    }

    public void decreaseHealth(int damage){
        if (this.health <= damage){
            this.specialAttribute();

            this.health = 0;
            this.destroy();
        }
        else if(this.health != 0){
            this.health -= damage;
        }
    }

    public int getHealth(){
        return this.health;
    };
}
