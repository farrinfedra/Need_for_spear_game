package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.Ball;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.obstacles.Obstacle;


public class ObstacleCollisionBehavior extends CollisionBehavior{

    @Override
    public void collide(Collision collision) {
        PhysicalObject o1 = collision.getO1();
        PhysicalObject o2 = collision.getO2();

        if (o2 instanceof Ball){
            Obstacle obstacle = ((Obstacle) o1);
             obstacle.decreaseHealth(1);

             if(obstacle.getHealth() == 0){
                 obstacle.getService(0).perform(o1);
             }
        }
    }
}
