package domain.physicalobjects;

import domain.Direction;
import domain.physicalobjects.collision.PaddleCollisionBehavior;
import domain.physicalobjects.movement.PaddleMovementBehavior;

import javax.swing.*;

public class Paddle extends PhysicalObject{

    public Paddle(Vector location, ImageIcon image, double width, double height){
        super(location, image, width, height, new PaddleMovementBehavior(), new PaddleCollisionBehavior());
    }

    public void rotate(Direction direction){
        //TODO
    }

    public void setSpeed(double speed){
        ((PaddleMovementBehavior) getMovementBehavior()).setSpeed(speed);
    }

    public double getSpeed(){ return  ((PaddleMovementBehavior) getMovementBehavior()).getSpeed();}
}
