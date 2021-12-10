package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ExplosiveObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.GameBoardService;
import domain.services.GameBoardServiceFactory;
import domain.services.GameBoardServiceType;
import domain.services.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

    public Obstacle create(ObstacleType type, Vector location, GameBoardServiceFactory gameBoardServiceFactory) {
        List<GameBoardService> gameBoardServices = new ArrayList<>();
        gameBoardServices.add(gameBoardServiceFactory.create(GameBoardServiceType.DESTROY));

        switch (type) {
            case FirmObstacle:
                return new FirmObstacle(location, gameBoardServices);
            case GiftObstacle:
                return new GiftObstacle(location, gameBoardServices);
            case ExplosiveObstacle:
                gameBoardServices.add(gameBoardServiceFactory.create(GameBoardServiceType.SUMMON));
                return new ExplosiveObstacle(location, gameBoardServices);
            default:
                return new SimpleObstacle(location, gameBoardServices);
        }
    }
}
