package domain.physicalobjects.collision;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Wall;

import javax.swing.ImageIcon;

import domain.physicalobjects.Ball;
import domain.physicalobjects.obstacles.FirmObstacle;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.SimpleObstacle;

public class BallCollisionBehavior implements CollisionBehavior {

	@Override
	public Boolean collide(Object o1, Object o2) {

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
				if(wallNormal.getY() > 0) {
					newSpeed = new Vector(0, 0);
				}
				else {
				newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());
				}

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
			 }//TO-DO: corner case

		}
			 else if (o2 instanceof Obstacle /*SimpleObstacle || o2 instanceof FirmObstacle*/){
                 Obstacle obstacle = (Obstacle) o2;
                 int obstacleWidth = obstacle.getWidth();
                 int obstacleHeight = obstacle.getHeight();
                 int obstacleX = obstacle.getLocation().getX();
                 int obstacleY = obstacle.getLocation().getY();

                 int ballX = ball.getLocation().getX();
                 int ballY = ball.getLocation().getY();

                 int ballRadius = ball.getWidth();

                 Vector newSpeed;
                 System.out.printf("ball Y:" + ballY + " ball X: " + ballX + "obstacle x:" + obstacleX + "obstacle y:" + obstacleY);
                 //Bottom-Up
                 if ((obstacleX < ballX -(ballRadius /2 ) || obstacleX + obstacleWidth > ballX)
                         &&
                     (ballY + ballRadius<= obstacleY  || ballY >= obstacleY)){
                     newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());

                     ball.getBoundingBox().shift(newSpeed);
                     ball.setSpeed(newSpeed);
                 }
                 //sides
                 else if ((obstacleY < ballY-(ballRadius /2 ) || obstacleY + obstacleHeight > ballY)
                         &&
                         (ballX <= obstacleX ||  ballX >= obstacleX)){
                     newSpeed = new Vector(-ballSpeed.getX(), ballSpeed.getY());

                     ball.getBoundingBox().shift(newSpeed);
                     ball.setSpeed(newSpeed);
                 }
                 
                 if(o2 instanceof FirmObstacle) {
                	 FirmObstacle fo = (FirmObstacle) o2;
                	 if(((FirmObstacle) o2).getHealth() ==2) {
                	 fo.setImage(new ImageIcon(this.getClass().getResource("/img/firm2.png")));
                	 }
                	 else if(((FirmObstacle) o2).getHealth() ==1) {
                    	 fo.setImage(new ImageIcon(this.getClass().getResource("/img/firm1.png")));
                    	 }
                	 
                 }
                 
        
                 
          }
		return false;
	}

}
