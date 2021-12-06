package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.collision.CollisionBehavior;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.movement.MovementBehavior;
import domain.physicalobjects.movement.StationaryMovementBehavior;

import javax.swing.*;

public class ObstacleFactory {
    private static ObstacleFactory instance;

    private ObstacleFactory() {
    }

    public static ObstacleFactory getInstance() {
        if (instance == null) {
            instance = new ObstacleFactory();
        }
        return instance;
    }

    public Obstacle create(ObstacleType type, Vector location) {
        switch (type) {
            case SimpleObstacle:
                return new SimpleObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/SimpleObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());
            case FirmObstacle:
                return new FirmObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/FirmObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());
            case GiftObstacle:
                return new GiftObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/GiftObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());
            case ExplosiveObstacle:
                return new ExplosiveObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/ExplosiveObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());
            default:
                return new SimpleObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/SimpleObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());        }
    }
}
