package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.Collision;

import java.util.List;

public abstract class BoundingBox {
    public abstract Collision getPointCollision(Vector v);
    public abstract Collision getCollisionWith(BoundingBox b);
    public abstract BoundingBox shift(Vector v);
    public abstract BoundingBox deepCopy();
    public abstract List<Vector> getFragmentation();
}
