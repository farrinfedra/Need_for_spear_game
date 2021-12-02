package domain.physicalobjects.collision;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Wall;
import domain.physicalobjects.Ball;

public class BallCollisionBehavior implements CollisionBehavior {

	@Override
	public void collide(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Ball ball = (Ball) o1;
		Vector prior_speed =ball.getSpeed();
		double dx = prior_speed.getX();
		double dy = prior_speed.getY();
		double angle = Math.toDegrees( Math.atan(dy / dx));
		Vector speed_updated;
		double dx_updated;
		double dy_updated;
		if(o2 instanceof Wall){
            Wall wall = (Wall) o2;
            if (wall.getLocation().getX() == 0) {
            	//upper wall
            	if(wall.getLocation().getY() > 0) {
            		dx_updated = dx;
   				 	dy_updated = -dy;
            	}
            	//bottom wall
            	else {
            		dx_updated = 0;
   				 	dy_updated = 0;
            	}
            }
           	//right or left wall
            else {
            	dx_updated = -dx;
   				dy_updated = dy;
            }
			 speed_updated = new Vector((int) dx_updated,(int) dy_updated);
			 ball.setSpeed(speed_updated);

		}
		
		if(o2 instanceof Paddle) {
			 Paddle paddle = (Paddle) o2;
			 int dx_paddle = paddle.getSpeed();
			 
			 //MAY NEED FEW MODIFICATIONS WHEN PADDLE ROTATES
			 
			 //if ball comes to paddle w right angle
			 if (angle == 90.0) {
				 dx_updated = dy / 2 * (paddle.getSpeed() > 0 ? 1 : -1);
				 dy_updated = dy / 2;
				 speed_updated = new Vector((int) dx_updated,(int) dy_updated);
				 ball.setSpeed(speed_updated);
			 }
			 
			 //if ball and paddle goes in opposite directions reflect 180deg
			 else if ((dx > 0 && dx_paddle <0) ||  ((dx < 0 && dx_paddle > 0)) ) {
				 dx_updated = -dx;
				 dy_updated = - dy;
				 speed_updated = new Vector((int) dx_updated,(int) dy_updated);
				 ball.setSpeed(speed_updated);
			 }
			 else {
				 dx_updated = dx;
				 dy_updated = -dy;
				 speed_updated = new Vector((int) dx_updated,(int) dy_updated);
				 ball.setSpeed(speed_updated);
				 
			 }
			 
			 //TO-DO: corner case

			 
		}
		
	}

}
