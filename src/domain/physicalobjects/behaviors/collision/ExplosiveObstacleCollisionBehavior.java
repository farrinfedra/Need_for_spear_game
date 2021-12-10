package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.ExplosiveFragment;
import domain.physicalobjects.obstacles.ExplosiveObstacle;


public class ExplosiveObstacleCollisionBehavior extends ObstacleCollisionBehavior {

    @Override
    public void collide(Object o1, Object o2, Collision collision) {
        super.collide(o1, o2, collision);

        ExplosiveObstacle obstacle = (ExplosiveObstacle) o1;

        if(obstacle.getHealth() == 0) {
            obstacle.getService(1).perform(new ExplosiveFragment(collision.getLocation(), ((ExplosiveObstacle) o1).getServices()));
        }
    }
}
