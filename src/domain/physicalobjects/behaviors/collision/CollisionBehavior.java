package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.behaviors.Behavior;
import domain.services.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class CollisionBehavior extends Behavior {

    public CollisionBehavior(){
        this(new ArrayList<>());
    }

    public CollisionBehavior(List<Service> services) {
        super(services);
    }

    /*
            Collision Algorithm for o1 when o2 hits it.
         */
    public abstract void collide(Object o1, Object o2, Collision collision);
}
