package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.Wall;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.obstacles.Obstacle;

public class MovingObstacleCollisionBehavior extends CollisionBehavior{
    @Override
    public void collide(Collision collision) {
        if(collision.getO2() instanceof Obstacle ||
        collision.getO2() instanceof Wall) {
            MovementBehavior mb = collision.getO1().getMovementBehavior();
            mb.setSpeed(mb.getSpeed().scale(-1));
        }
    }
}
