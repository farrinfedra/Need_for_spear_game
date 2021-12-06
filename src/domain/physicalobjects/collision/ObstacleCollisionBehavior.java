package domain.physicalobjects.collision;

import domain.physicalobjects.Ball;
import domain.physicalobjects.obstacles.Obstacle;

public class ObstacleCollisionBehavior implements CollisionBehavior{

    @Override
    public void collide(Object o1, Object o2) {
        if (o2 instanceof Ball){
             ((Obstacle) o1).decreaseHealth(1);
        }
    }
}
