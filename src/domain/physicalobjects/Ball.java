package domain.physicalobjects;
import domain.physicalobjects.boundingbox.SphereBoundingBox;
import domain.physicalobjects.collision.BallCollisionBehavior;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.movement.BallMovementBehavior;
import domain.physicalobjects.movement.PaddleMovementBehavior;

import javax.swing.*;

public class Ball extends PhysicalObject{

    public Ball(Vector location, ImageIcon image, int width, int height ){
        super(location, image, width, height, new SphereBoundingBox(location.add(new Vector(width/2, width/2)), width/2 ), new BallMovementBehavior(), new BallCollisionBehavior());
    }

	public Vector getSpeed() {
		return  ((BallMovementBehavior) getMovementBehavior()).getSpeed();
	}
	public void setSpeed(Vector speed) {
		 ((BallMovementBehavior) getMovementBehavior()).setSpeed(speed);
	}
}
