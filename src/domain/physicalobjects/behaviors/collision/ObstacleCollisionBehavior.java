package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.Ball;
import domain.physicalobjects.obstacles.Obstacle;


public class ObstacleCollisionBehavior extends CollisionBehavior{

    @Override
    public void collide(Object o1, Object o2,  Collision collision) {
        if (o2 instanceof Ball){
            Obstacle obstacle = ((Obstacle) o1);
             obstacle.decreaseHealth(1);

             if(obstacle.getHealth() == 0){
                 obstacle.getService(0).perform(o1);
             }
        }
    }
}
