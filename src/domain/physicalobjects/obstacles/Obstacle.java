package domain.physicalobjects.obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.boundingbox.BoundingBox;
import domain.services.GameBoardService;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public abstract class Obstacle extends PhysicalObject {
    private boolean invincible;
    private int health;
    abstract void specialAttribute();

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = health;
        this.invincible = false;
    }

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health, List<Service> services) {
        super(location, image, width, height, movementBehavior, collisionBehavior, services);
        this.health = health;
        this.invincible = false;
    }

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health, List<Service> services, BoundingBox boundingBox) {
        super(location, image, width, height, boundingBox, movementBehavior, collisionBehavior, services);
        this.health = health;
        this.invincible = false;
    }

    public void decreaseHealth(int damage){
        if(invincible){
            //Do nothing
        }
        else if (this.health <= damage){

            this.health = 0;
        }
        else if(this.health != 0){
            this.health -= damage;
            this.specialAttribute();
        }
    }

    public int getHealth(){
        return this.health;
    }

    public void setInvincible(boolean value){
        this.invincible = value;
    }

    public boolean isInvincible(){
        return this.invincible;
    }
}
