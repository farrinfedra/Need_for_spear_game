package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Wall;

public class ExplosiveFragmentCollisionBehavior extends CollisionBehavior {
    @Override
    public void collide(Collision collision) {
    	//RemainingsExplosiveObject paddle = (RemainingsExplosiveObject) o1;
        if(collision.getO2() instanceof Wall)
            collision.getO1().getService(0).perform(collision.getO1());
    }
}

/* */
