package domain.physicalobjects.collision;

import domain.physicalobjects.Ball;
import domain.physicalobjects.obstacles.Obstacle;

public class ObstacleCollisionBehavior implements CollisionBehavior{

    @Override
    public Boolean collide(Object o1, Object o2) {
        System.out.println(o1.getClass().getName()+ " is colliding with " + o2.getClass().getName());

        Boolean broken = false;
        if (o2 instanceof Ball){
            broken = ((Obstacle) o1).decreaseHealth(1);
        }
        return broken;
    }
}
