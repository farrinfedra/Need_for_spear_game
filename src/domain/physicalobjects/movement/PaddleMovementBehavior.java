package domain.physicalobjects.movement;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

public class PaddleMovementBehavior implements MovementBehavior{

    private int speed;

    public PaddleMovementBehavior(){
        this(0);
    }

    public PaddleMovementBehavior(int speed){
        this.speed = speed;
    }

    @Override
    public void move(Object o){
        Paddle paddle = (Paddle) o;

        int dx = speed;

        Vector shiftVector = new Vector(dx, 0);
        Vector newLocation = paddle.getLocation().add(shiftVector);

        paddle.setLocation(newLocation);
        paddle.getBoundingBox().shift(shiftVector);

        speed = 95*speed/100;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
