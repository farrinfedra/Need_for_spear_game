package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.ExplosiveFragment;
import domain.physicalobjects.obstacles.ExplosiveObstacle;
import domain.physicalobjects.obstacles.ObstacleFactory;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.services.GameBoardService;
import domain.services.Service;

import java.util.ArrayList;
import java.util.List;

public class ExplosiveObstacleCollisionBehavior extends CollisionBehavior {

    public ExplosiveObstacleCollisionBehavior(List<Service> services) {
        super(services);
    }

    @Override
    public void collide(Object o1, Object o2, Collision collision) {
        new ObstacleCollisionBehavior().collide(o1, o2, collision);

        ExplosiveObstacle obstacle = (ExplosiveObstacle) o1;

        if(obstacle.isDestroyed()) {
            getService(0).perform(new ExplosiveFragment(collision.getLocation()));
        }
    }
}
