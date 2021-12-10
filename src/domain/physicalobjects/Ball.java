package domain.physicalobjects;
import domain.physicalobjects.boundingbox.SphereBoundingBox;
import domain.physicalobjects.behaviors.collision.BallCollisionBehavior;
import domain.physicalobjects.behaviors.movement.BallMovementBehavior;

import javax.swing.*;

public class Ball extends PhysicalObject{

    public Ball(Vector location, ImageIcon image, double width, double height ){
        super(location, image, width, height,
				new SphereBoundingBox(location.add(new Vector(width/2, width/2)), width/2 )
				, new BallMovementBehavior(), new BallCollisionBehavior(), null);
    }

	public Vector getSpeed() {
		return  ((BallMovementBehavior) getMovementBehavior()).getSpeed();
	}
	public void setSpeed(Vector speed) {
		 ((BallMovementBehavior) getMovementBehavior()).setSpeed(speed);
	}
}
