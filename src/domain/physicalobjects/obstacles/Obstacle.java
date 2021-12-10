package domain.physicalobjects.obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.services.GameBoardService;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public abstract class Obstacle extends PhysicalObject {
    private int health;
    abstract void specialAttribute();

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health) {
        super(location, image, width, height, movementBehavior, collisionBehavior);
        this.health = health;
    }

    public Obstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, int health, List<GameBoardService> services) {
        super(location, image, width, height, movementBehavior, collisionBehavior, services);
        this.health = health;
    }

    public void decreaseHealth(int damage){
        if (this.health <= damage){
            this.specialAttribute();

            this.health = 0;
        }
        else if(this.health != 0){
            this.health -= damage;
        }
    }

    public int getHealth(){
        return this.health;
    };
}
