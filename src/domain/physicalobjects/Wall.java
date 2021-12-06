package domain.physicalobjects;

import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.StationaryMovementBehavior;

import javax.swing.*;

public class Wall extends PhysicalObject{

    private Vector normal;

    public Wall(Vector location, double width, double height, Vector normal) {
        super(location, null, width, height, new StationaryMovementBehavior(), new NoCollisionBehavior());
        this.normal = normal;
    }

    public Vector getNormal() {
        return normal;
    }
}
