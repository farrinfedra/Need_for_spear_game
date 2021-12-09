package domain.physicalobjects.collision;

import domain.physicalobjects.*;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

public class PaddleCollisionBehavior implements CollisionBehavior{

    @Override
    public void collide(Object o1, Object o2, Collision collision) {
        Paddle paddle = (Paddle) o1;

        if(o2 instanceof Wall ||
            o2 instanceof Ball){
            PhysicalObject p2 = (PhysicalObject) o2;

            //If paddle is still trying to move pass the wall or the ball, stop it
            //Else, it can move

            if(paddle.getBoundingBox()
                    .deepCopy()
                    .shift(paddle.getSpeed())
                    .getCollisionWith(p2.getBoundingBox()) != null)
                   paddle.setSpeed(new Vector(0,0));
        }
    }
}
