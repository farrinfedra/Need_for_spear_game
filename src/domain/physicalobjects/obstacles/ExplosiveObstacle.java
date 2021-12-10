package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.services.GameBoardService;

import javax.swing.*;
import java.util.List;

public class ExplosiveObstacle extends Obstacle{

    public ExplosiveObstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior, List<GameBoardService> gameBoardServices) {
        super(location, image, width, height, movementBehavior, collisionBehavior, 1, gameBoardServices);
    }

    @Override
    void specialAttribute() {

    }

    @Override
    public String toString(){
        return "ExplosiveObstacle";
    }
}
