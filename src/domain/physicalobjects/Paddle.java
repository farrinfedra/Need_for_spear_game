package domain.physicalobjects;

import domain.Direction;
import domain.physicalobjects.behaviors.collision.PaddleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.PaddleMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class Paddle extends PhysicalObject{

    private boolean magicalHexEnabled;

    public Paddle(Vector location, ImageIcon image, double width, double height, List<Service> services){
        super(location, image, width, height, new PaddleMovementBehavior(), new PaddleCollisionBehavior(), services);
        magicalHexEnabled = false;
    }

    public void rotate(Direction direction){

    }

    public void setSpeed(Vector speed){
        getMovementBehavior().setSpeed(speed);
    }
    public Vector getSpeed(){ return  ((PaddleMovementBehavior) getMovementBehavior()).getSpeed();}

    public void shootMagicalHex() {
        if(magicalHexEnabled){
            getService(0).perform(new MagicalHexAmmo(getLocation(), getServices()));
        }
    }

    public void setMagicalHexEnabled(boolean magicalHexEnabled) {
        this.magicalHexEnabled = magicalHexEnabled;
    }
}
