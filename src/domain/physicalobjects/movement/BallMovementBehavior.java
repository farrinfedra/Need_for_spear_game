package domain.physicalobjects.movement;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Vector;
import java.math.*;
public class BallMovementBehavior implements MovementBehavior{
    Vector speed;
    public BallMovementBehavior(){
        this(new Vector(1,1));
    }
    public BallMovementBehavior(Vector speed){
        this.speed = speed;
    }
	@Override
    public void move(Object o) {

        Ball ball = (Ball) o;
        double dx = speed.getX();
        double dy = speed.getY();
        
        Vector shiftVector = new Vector((int) dx, (int) dy);
        Vector newLocation = ball.getLocation().add(shiftVector);

        ball.setLocation(newLocation);
        ball.getBoundingBox().shift(shiftVector);
    }
    
    public void setSpeed(Vector speed){
        this.speed = speed;
    }

    public Vector getSpeed() {
        return speed;
    }
}
