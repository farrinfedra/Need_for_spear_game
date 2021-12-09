package domain.physicalobjects.collision;

import domain.physicalobjects.Vector;

public class Collision {
    private Vector normal;
    private Vector location;

    public Collision(Vector location, Vector normal){
        this.location = location;
        this.normal = normal;
    }

    public Vector getNormal() {
        return normal;
    }
    public Vector getLocation() {
        return location;
    }
    public Collision reverseNormal(){return new Collision(location, normal.reverse());}
}
