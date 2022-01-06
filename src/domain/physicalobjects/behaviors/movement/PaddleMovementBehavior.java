package domain.physicalobjects.behaviors.movement;

import domain.physicalobjects.Paddle;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;

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
        PhysicalObject object = (PhysicalObject) o;

        Vector newLocation = object.getLocation().add(getSpeed());

        object.setLocation(newLocation);
        object.getBoundingBox().shift(getSpeed());

        setSpeed(new Vector(95*getSpeed().getX()/100, 0));
    }

    public void setSpeed(double speed){
        setSpeed(new Vector(speed, 0));
    }

}
