package domain.physicalobjects.movement;

import domain.physicalobjects.RemainingsExplosiveObject;
import domain.physicalobjects.Vector;

public class RemainingsExplosiveObjectMovementBehavior implements MovementBehavior {

    private double speed;

    public RemainingsExplosiveObjectMovementBehavior(){
        this(0);
    }

    public RemainingsExplosiveObjectMovementBehavior(double speed){
        this.speed = speed;
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
