package domain.physicalobjects.movement;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Vector;
import java.math.*;

public class BallMovementBehavior implements MovementBehavior{
    private Vector speed;

    public BallMovementBehavior(){
        this(new Vector(1,1));
    }
    public BallMovementBehavior(Vector speed){
        this.speed = speed;
    }
	@Override
    public void move(Object o) {
        Ball ball = (Ball) o;
        Vector newLocation = ball.getLocation().add(speed);
        ball.setLocation(newLocation);
        ball.getBoundingBox().shift(speed);
    }
    
    public void setSpeed(Vector speed){
        this.speed = speed;
    }
    public Vector getSpeed() {
        return speed;
    }
}
