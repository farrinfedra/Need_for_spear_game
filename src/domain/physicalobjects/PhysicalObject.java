package domain.physicalobjects;

import domain.physicalobjects.boundingbox.BoundingBox;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.services.GameBoardService;
import domain.services.Service;
import domain.services.ServiceAttachable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PhysicalObject extends ServiceAttachable {

    private UUID id;

    private Vector location;
    private ImageIcon image;

    private BoundingBox boundingBox;
    private double width;
    private double height;
    private MovementBehavior movementBehavior;
    private CollisionBehavior collisionBehavior;

    private boolean isDestroyed;

    public PhysicalObject(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, List<Service> services){
        this(location, image, width, height, new PolygonBoundingBox(location, location.add(new Vector(width, 0)), location.add(new Vector(width, height)), location.add(new Vector(0, height))),
                movementBehavior, collisionBehavior, services);
    }

    public PhysicalObject(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior){
        this(location, image, width, height, new PolygonBoundingBox(location, location.add(new Vector(width, 0)), location.add(new Vector(width, height)), location.add(new Vector(0, height))),
                movementBehavior, collisionBehavior, new ArrayList<>());
    }

    public PhysicalObject(Vector location, ImageIcon image, double width, double height, BoundingBox boundingBox, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, List<Service> services){
        super(services);

        this.id = UUID.randomUUID();

        this.location = location;
        this.image = image;
        this.width = width;
        this.height = height;

        this.boundingBox = boundingBox;
        this.movementBehavior = movementBehavior;
        this.collisionBehavior = collisionBehavior;


        this.isDestroyed = false;
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

    public UUID getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return ((PhysicalObject) o).getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
