package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;

public class SphereBoundingBox extends BoundingBox{

    private Vector center;
    private int radius;
    private final int fragmentation = 10;

    public SphereBoundingBox(Vector center, int radius){
        this.center = center;
        this.radius = radius;
    }
    @Override
    public boolean isInside(Vector v) {
        return center.distance(v) <= radius;
    }

    @Override
    public boolean isCollidingWith(BoundingBox b) {

        for(int j=0; j<fragmentation; j++){
            if(b.isInside(center.add(new Vector(radius, 0).rotate(Math.PI*2/fragmentation*j))))
                return true;
        }

        return b.isCollidingWith(this);
    }

    @Override
    public void shift(Vector v) {
        center = center.add(v);
    }

}
