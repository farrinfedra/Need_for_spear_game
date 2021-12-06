package domain.physicalobjects.collision;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.Wall;

import javax.swing.ImageIcon;

import domain.physicalobjects.Ball;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
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

			ball.setSpeed(newSpeed);
		}
		else if(o2 instanceof Paddle) {
			 Paddle paddle = (Paddle) o2;

			 //MAY NEED FEW MODIFICATIONS WHEN PADDLE ROTATES


				 Vector newSpeed;

				 newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());

				 ball.setSpeed(newSpeed);
			 //TO-DO: corner case

		}
			 else if (o2 instanceof Obstacle /*SimpleObstacle || o2 instanceof FirmObstacle*/){
                 Obstacle obstacle = (Obstacle) o2;
				double obstacleWidth = obstacle.getWidth();
				double obstacleHeight = obstacle.getHeight();
				double obstacleX = obstacle.getLocation().getX();
				double obstacleY = obstacle.getLocation().getY();

				double ballX = ball.getLocation().getX();
				double ballY = ball.getLocation().getY();

				double ballRadius = ball.getWidth();

                 Vector newSpeed;
                 System.out.printf("ball Y:" + ballY + " ball X: " + ballX + "obstacle x:" + obstacleX + "obstacle y:" + obstacleY);
                 //Bottom-Up
                 if ((obstacleX < ballX -(ballRadius /2 ) || obstacleX + obstacleWidth > ballX)
                         &&
                     (ballY + ballRadius<= obstacleY  || ballY >= obstacleY)){
                     newSpeed = new Vector(ballSpeed.getX(), -ballSpeed.getY());

                     ball.setSpeed(newSpeed);
                 }
                 //sides
                 else if ((obstacleY < ballY-(ballRadius /2 ) || obstacleY + obstacleHeight > ballY)
                         &&
                         (ballX <= obstacleX ||  ballX >= obstacleX)){
                     newSpeed = new Vector(-ballSpeed.getX(), ballSpeed.getY());


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
