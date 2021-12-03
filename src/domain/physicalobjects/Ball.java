package domain.physicalobjects;
import domain.physicalobjects.boundingbox.SphereBoundingBox;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.BallMovementBehavior;
import domain.physicalobjects.movement.PaddleMovementBehavior;

import javax.swing.*;

public class Ball extends PhysicalObject{

    public Ball(Vector location, ImageIcon image){
        super(location, image, image.getIconWidth(), image.getIconHeight(), new SphereBoundingBox(location, image.getIconWidth() ), new BallMovementBehavior(), new NoCollisionBehavior());
    }
	public Vector getSpeed() {
		return  ((BallMovementBehavior) getMovementBehavior()).getSpeed();
	}
	public void setSpeed(Vector speed) {
		 ((BallMovementBehavior) getMovementBehavior()).setSpeed(speed);
	}
    
    
    
}
