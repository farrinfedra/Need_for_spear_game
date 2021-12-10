package domain.physicalobjects.behaviors.movement;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.Behavior;
import domain.services.Service;
import java.util.ArrayList;
import java.util.List;

public abstract class MovementBehavior extends Behavior {
    private Vector speed;

    public MovementBehavior(Vector speed){
        this(speed, null);
    }

    public MovementBehavior(Vector speed, List<Service> services){
        super(services);
        this.speed = speed;
    }

    public void setSpeed(Vector speed){
        this.speed = speed;
    }

    public Vector getSpeed(){
        return this.speed;
    }
    public abstract void move(Object o);
}
