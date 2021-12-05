package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;

import javax.swing.*;

public class ObstacleFactory {
    public ObstacleFactory instance;

    private ObstacleFactory() {
    }

    public ObstacleFactory getInstance() {
        if (instance == null) {
            instance = new ObstacleFactory();
        }
        return instance;
    }

    public Obstacle create(ObstacleType type, Vector location, ImageIcon image, int width, int height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        switch (type) {
            case SimpleObstacle:
                return new SimpleObstacle(location, image, width, height, movementBehavior, collisionBehavior);
            case FirmObstacle:
                return new FirmObstacle(location, image, width, height, movementBehavior, collisionBehavior);
            case GiftObstacle:
                return new GiftObstacle(location, image, width, height, movementBehavior, collisionBehavior);
            case ExplosiveObstacle:
                return new ExplosiveObstacle(location, image, width, height, movementBehavior, collisionBehavior);
            default:
                return new SimpleObstacle(location, image, width, height, movementBehavior, collisionBehavior);
        }
    }
}
