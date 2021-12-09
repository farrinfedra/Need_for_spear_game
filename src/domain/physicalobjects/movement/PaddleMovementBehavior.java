package domain.physicalobjects.movement;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

public class PaddleMovementBehavior extends MovementBehavior{

    public PaddleMovementBehavior(){
        this(0);
    }

    public PaddleMovementBehavior(double speed){
        this(new Vector(speed, 0));
    }

    public PaddleMovementBehavior(Vector speed){
        super(speed);
    }

    @Override
    public void move(Object o){
        Paddle paddle = (Paddle) o;

        Vector newLocation = paddle.getLocation().add(getSpeed());

        paddle.setLocation(newLocation);
        paddle.getBoundingBox().shift(getSpeed());

        setSpeed(new Vector(95*getSpeed().getX()/100, 0));
    }

    public void setSpeed(double speed){
        setSpeed(new Vector(speed, 0));
    }

}
