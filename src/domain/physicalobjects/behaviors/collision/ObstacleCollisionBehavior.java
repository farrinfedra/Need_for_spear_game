package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.Ball;
import domain.physicalobjects.obstacles.Obstacle;

public class ObstacleCollisionBehavior extends CollisionBehavior{

    @Override
    public void collide(Object o1, Object o2,  Collision collision) {
        if (o2 instanceof Ball){
             ((Obstacle) o1).decreaseHealth(1);
        }
    }
}
