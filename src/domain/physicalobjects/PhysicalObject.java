package domain.physicalobjects;

import domain.physicalobjects.boundingbox.BoundingBox;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;
import domain.physicalobjects.movement.StationaryMovementBehavior;

import javax.swing.*;
import java.util.Objects;

public class PhysicalObject {
    private Vector location;
    private ImageIcon image;

    private BoundingBox boundingBox;
    private double width;
    private double height;
    private MovementBehavior movementBehavior;
    private CollisionBehavior collisionBehavior;

    public PhysicalObject(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior){
        this(location, image, width, height, new PolygonBoundingBox(location, location.add(new Vector(width, 0)), location.add(new Vector(width, height)), location.add(new Vector(0, height))),
                movementBehavior, collisionBehavior);
    }

    public PhysicalObject(Vector location, ImageIcon image, double width, double height, BoundingBox boundingBox, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior){
        this.location = location;
        this.image = image;
        this.width = width;
        this.height = height;

        this.boundingBox = boundingBox;
        this.movementBehavior = movementBehavior;
        this.collisionBehavior = collisionBehavior;
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public BoundingBox getBoundingBox(){
        return boundingBox;
    }
    public void setBoundingBox(BoundingBox boundingBox){
        this.boundingBox = boundingBox;
    }
    public MovementBehavior getMovementBehavior(){ return this.movementBehavior;}
    public void setMovementBehavior(MovementBehavior movementBehavior){ this.movementBehavior = movementBehavior;}
    public CollisionBehavior getCollisionBehavior() {return collisionBehavior;}
    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {this.collisionBehavior = collisionBehavior;}

}
