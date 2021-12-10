package domain.physicalobjects;

import domain.Direction;
import domain.physicalobjects.behaviors.collision.PaddleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.PaddleMovementBehavior;

import javax.swing.*;

public class Paddle extends PhysicalObject{

    public Paddle(Vector location, ImageIcon image, double width, double height){
        super(location, image, width, height, new PaddleMovementBehavior(), new PaddleCollisionBehavior());
    }

    public void rotate(Direction direction){

    }

    public void setSpeed(Vector speed){
        getMovementBehavior().setSpeed(speed);
    }

    public Vector getSpeed(){ return  ((PaddleMovementBehavior) getMovementBehavior()).getSpeed();}
}
