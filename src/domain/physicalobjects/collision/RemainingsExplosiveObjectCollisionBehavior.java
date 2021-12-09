package domain.physicalobjects.collision;

import domain.physicalobjects.RemainingsExplosiveObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.Wall;
public class RemainingsExplosiveObjectCollisionBehavior implements CollisionBehavior {
    @Override
    public void collide(Object o1, Object o2, Collision collision) {
    	RemainingsExplosiveObject paddle = (RemainingsExplosiveObject) o1;
    	
    	//if it hits the paddle do nothing, remove remaining
        if(o2 instanceof Paddle){
        }
        //if hits the wall then decrease health and remove remaining
        //TODO: Update Lives
        if(o2 instanceof Wall) {

        }
    }
}

/* */
