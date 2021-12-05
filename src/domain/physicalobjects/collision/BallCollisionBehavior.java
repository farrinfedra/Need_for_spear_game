package domain.physicalobjects.collision;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Wall;
import domain.physicalobjects.Ball;

public class BallCollisionBehavior implements CollisionBehavior {

	@Override
	public Boolean collide(Object o1, Object o2) {
		// TODO Auto-generated method stub

		Ball ball = (Ball) o1;
		Vector ballSpeed = ball.getSpeed();

		double dx = ballSpeed.getX();
		double dy = ballSpeed.getY();
		double angle = Math.toDegrees( Math.atan(dy / dx));
		Vector speed_updated;
		double dx_updated;
		double dy_updated;

		if(o2 instanceof Wall){
            Wall wall = (Wall) o2;
           	Vector wallNormal = wall.getNormal();

			Vector newSpeed;
			if(wallNormal.getX() != 0)
				newSpeed = new Vector(-ballSpeed.getX(), ballSpeed.getY());
			else
				newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());

			ball.getBoundingBox().shift(newSpeed);
			ball.setSpeed(newSpeed);
		}
		else if(o2 instanceof Paddle) {
			 Paddle paddle = (Paddle) o2;
			 int dx_paddle = paddle.getSpeed();

			 //MAY NEED FEW MODIFICATIONS WHEN PADDLE ROTATES

			 //if ball comes to paddle w right angle
			 if (angle == 90.0) {
				 dx_updated = dy / 2 * (paddle.getSpeed() > 0 ? 1 : -1);
				 dy_updated = dy / 2;
				 speed_updated = new Vector((int) dx_updated,(int) dy_updated);
				 ball.setSpeed(speed_updated);
			 }else{
				 Vector newSpeed;

				 newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());

				 ball.getBoundingBox().shift(newSpeed);
				 ball.setSpeed(newSpeed);
			 }


//
//			 //TO-DO: corner case
		}
		return false;
	}

}
