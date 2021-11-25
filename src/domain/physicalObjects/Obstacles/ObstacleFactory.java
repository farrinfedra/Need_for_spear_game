package domain.physicalObjects.Obstacles;

import domain.physicalObjects.Vector;

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

    public Obstacle create(ObstacleType type, Vector location, ImageIcon image, int width, int height) {
        switch (type) {
            case SimpleObstacle:
                return new SimpleObstacle(location, image, width, height);
            case FirmObstacle:
                return new FirmObstacle(location, image, width, height);
            case GiftObstacle:
                return new GiftObstacle(location, image, width, height);
            case ExplosiveObstacle:
                return new ExplosiveObstacle(location, image, width, height);
            default:
                return new SimpleObstacle(location, image, width, height);
        }
    }
}
