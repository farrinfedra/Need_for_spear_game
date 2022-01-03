package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.*;

import domain.physicalobjects.obstacles.Obstacle;

public class BallCollisionBehavior extends CollisionBehavior {

	@Override
	public void collide(Collision collision) {

		Ball ball = (Ball) collision.getO1();
		PhysicalObject o2 = collision.getO2();

		Vector ballSpeed = ball.getSpeed();
		Vector normal = collision.getNormal();

		if(		o2 instanceof Wall ||
				o2 instanceof Obstacle ||
				o2 instanceof Paddle){
			System.out.println(o2);
			Vector newSpeed = ballSpeed.subtract(normal.scale(normal.dot(ballSpeed)*2));
			ball.setSpeed(newSpeed);
		}
	}
}


