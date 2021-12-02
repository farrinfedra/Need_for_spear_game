package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;

public abstract class BoundingBox {
    public abstract boolean isInside(Vector v);
    public abstract boolean isCollidingWith(BoundingBox b);
    public abstract BoundingBox shift(Vector v);
    public abstract BoundingBox deepCopy();
}
