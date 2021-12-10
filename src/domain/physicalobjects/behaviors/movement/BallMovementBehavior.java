package domain.physicalobjects.behaviors.movement;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Vector;

public class BallMovementBehavior extends MovementBehavior{

    public BallMovementBehavior(){
        super(new Vector(2,2));
    }

	@Override
    public void move(Object o) {
        Ball ball = (Ball) o;
        Vector newLocation = ball.getLocation().add(getSpeed());

        ball.setLocation(newLocation);
        ball.getBoundingBox().shift(getSpeed());
    }
}
