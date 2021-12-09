package domain.physicalobjects.movement;

import domain.physicalobjects.RemainingsExplosiveObject;
import domain.physicalobjects.Vector;

public class RemainingsExplosiveObjectMovementBehavior extends MovementBehavior {

    private double speed;

    public RemainingsExplosiveObjectMovementBehavior(){
        this(0);
    }

    public RemainingsExplosiveObjectMovementBehavior(double speed){
        super(new Vector(0, speed));
    }

    public RemainingsExplosiveObjectMovementBehavior(Vector speed){
        super(speed);
    }

    @Override
    public void move(Object o){
    	RemainingsExplosiveObject remainings = (RemainingsExplosiveObject) o;

        double dy = speed;

        Vector shiftVector = new Vector(0, dy);
        Vector newLocation = remainings.getLocation().add(shiftVector);

        remainings.setLocation(newLocation);
        remainings.getBoundingBox().shift(shiftVector);

    }
}
