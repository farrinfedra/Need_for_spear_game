package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Wall;

public class ExplosiveFragmentCollisionBehavior extends CollisionBehavior {
    @Override
    public void collide(Object o1, Object o2, Collision collision) {
    	//RemainingsExplosiveObject paddle = (RemainingsExplosiveObject) o1;
        if(o2 instanceof Wall)
            ((PhysicalObject) o1).getService(0).perform(o1);
    }
}

/* */
