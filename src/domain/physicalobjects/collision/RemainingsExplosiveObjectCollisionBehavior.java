package domain.physicalobjects.collision;

import domain.physicalobjects.RemainingsExplosiveObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.Wall;
public class RemainingsExplosiveObjectCollisionBehavior implements CollisionBehavior {
    @Override
    public Boolean collide(Object o1, Object o2) {
    	RemainingsExplosiveObject paddle = (RemainingsExplosiveObject) o1;
    	
    	//if it hits the paddle do nothing, remove remaining
        if(o2 instanceof Paddle){
            return true;
    }
        //if hits the wall then decrease health and remove remaining
        //TODO: Update Lives
        if(o2 instanceof Wall) {
        	
        	return true;
        }
        return false;
}
}

/* */