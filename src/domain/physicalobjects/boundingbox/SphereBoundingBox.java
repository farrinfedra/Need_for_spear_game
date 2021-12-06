package domain.physicalobjects.boundingbox;

import domain.physicalobjects.Vector;

import java.util.ArrayList;
import java.util.List;

public class SphereBoundingBox extends BoundingBox{

    private Vector center;
    private double radius;
    private final int fragmentation = 10;

    public SphereBoundingBox(Vector center, double radius){
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

        return false;
    }

    @Override
    public BoundingBox shift(Vector v) {
        center = center.add(v);
        return this;
    }

    @Override
    public SphereBoundingBox deepCopy(){
        return new SphereBoundingBox(this.center, radius);
    }

    @Override
    public List<Vector> getFragmentation() {
        ArrayList<Vector> fragmentationList = new ArrayList<>();

        for(int j=0; j<fragmentation; j++){
            fragmentationList.add(center.add(new Vector(radius, 0).rotate(Math.PI*2/fragmentation*j)));
        }
        return fragmentationList;
    }
}
