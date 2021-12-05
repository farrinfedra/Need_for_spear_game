package domain.physicalobjects.collision;

import domain.physicalobjects.obstacles.Obstacle;

public class ObstacleCollisionBehavior implements CollisionBehavior{

    @Override
    public Boolean collide(Object o1, Object o2) {
        Boolean broken = ((Obstacle) o1).decreaseHealth(1);
        return broken;
    }
}
