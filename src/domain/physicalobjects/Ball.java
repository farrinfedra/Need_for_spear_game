package domain.physicalobjects;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.BallMovementBehavior;

import javax.swing.*;

public class Ball extends PhysicalObject{
    public Ball(Vector location, ImageIcon image){
        super(location, image, image.getIconWidth(), image.getIconHeight(), new BallMovementBehavior(), new NoCollisionBehavior());
    }
}
