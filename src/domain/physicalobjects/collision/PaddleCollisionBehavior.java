package domain.physicalobjects.collision;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Wall;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

public class PaddleCollisionBehavior implements CollisionBehavior{

    @Override
    public void collide(Object o1, Object o2) {
        Paddle paddle = (Paddle) o1;

        if(o2 instanceof Wall){
            Wall wall = (Wall) o2;

            //If paddle is still trying to move pass the wall, stop it
            //Else, it can move

            if(paddle.getBoundingBox()
                    .deepCopy()
                    .shift(new Vector(paddle.getSpeed(), 0))
                    .isCollidingWith(wall.getBoundingBox()))
                   paddle.setSpeed(0);
        }

    }
}
