package domain.physicalobjects;

import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.StationaryMovementBehavior;

import javax.swing.*;

public class Wall extends PhysicalObject{

    public Wall(Vector location, int width, int height) {
        super(location, null, width, height, new StationaryMovementBehavior(), new NoCollisionBehavior());
    }
}
