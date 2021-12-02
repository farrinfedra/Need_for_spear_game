package domain.physicalobjects.movement;

import domain.physicalobjects.Ball;

public class BallMovementBehavior implements MovementBehavior{
    @Override
    public void move(Object o) {

        Ball ball = (Ball) o;
    }
}
