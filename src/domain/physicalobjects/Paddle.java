package domain.physicalobjects;

import domain.Direction;
import domain.physicalobjects.collision.PaddleCollisionBehavior;
import domain.physicalobjects.movement.PaddleMovementBehavior;

import javax.swing.*;

public class Paddle extends PhysicalObject{

    public Paddle(Vector location, ImageIcon image){
        super(location, image, image.getIconWidth(), image.getIconHeight(), new PaddleMovementBehavior(), new PaddleCollisionBehavior());
    }

    public void rotate(Direction direction){
        //TODO
    }

    public void setSpeed(int speed){
        ((PaddleMovementBehavior) getMovementBehavior()).setSpeed(speed);
    }

    public int getSpeed(){ return  ((PaddleMovementBehavior) getMovementBehavior()).getSpeed();}
}
