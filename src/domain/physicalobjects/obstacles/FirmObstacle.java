package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.services.GameBoardService;

import javax.swing.*;
import java.util.List;

public class FirmObstacle extends Obstacle{
    public FirmObstacle(Vector location, ImageIcon image, double width, double height, MovementBehavior movementBehavior, CollisionBehavior collisionBehavior) {
        super(location, image, width, height, movementBehavior, collisionBehavior, 3);
    }

    @Override
    void specialAttribute() {

    }
    @Override
    public String toString(){
        return "FirmObstacle";
    }

}
