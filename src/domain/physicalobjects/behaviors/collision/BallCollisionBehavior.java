package domain.physicalobjects.behaviors.collision;

import domain.physicalobjects.*;

import domain.physicalobjects.obstacles.Obstacle;

public class BallCollisionBehavior extends CollisionBehavior {
    private boolean isColliding = false;
	@Override
	public void collide(Object o1, Object o2,  Collision collision) {

		Ball ball = (Ball) o1;
		Vector ballSpeed = ball.getSpeed();
		Vector normal = collision.getNormal();
		System.out.println("=========");
		System.out.println("Location: " + ball.getLocation() +
		"\nSpeed: " + ball.getSpeed() +
				"\nBoundingBox Ball :" +ball.getBoundingBox().getFragmentation());
		System.out.println("BoundingBox Wall:"+ ((PhysicalObject)o2).getBoundingBox().getFragmentation());


		if(		o2 instanceof Wall ||
				o2 instanceof Obstacle ||
				o2 instanceof Paddle){

			Vector newSpeed = ballSpeed.subtract(normal.scale(normal.dot(ballSpeed)*2));
			ball.setSpeed(newSpeed);
		}
	}
}


