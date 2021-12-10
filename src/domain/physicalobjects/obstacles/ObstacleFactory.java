package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ExplosiveObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.GameBoardService;
import domain.services.GameBoardServiceFactory;
import domain.services.GameBoardServiceType;

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
        ArrayList<GameBoardService> gameBoardServices = new ArrayList<>();

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
                gameBoardServices.add(gameBoardServiceFactory
                        .getInstance()
                        .create(GameBoardServiceType.SUMMON));

            return new ExplosiveObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/ExplosiveObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ExplosiveObstacleCollisionBehavior((List) gameBoardServices),
                        gameBoardServices
                        );
            default:
                return new SimpleObstacle(location,
                        new ImageIcon(this.getClass().getResource("/img/SimpleObstacleImage.png")),
                        40, 40,
                        new StationaryMovementBehavior(),
                        new ObstacleCollisionBehavior());        }
    }
}
