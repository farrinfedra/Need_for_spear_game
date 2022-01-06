package domain.physicalobjects.behaviors.movement;

import domain.Constants;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.Vector;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

import java.util.Arrays;

public class PaddleMovementBehavior extends MovementBehavior{

    private double rotationSpeed;
    private double rotation;

    public PaddleMovementBehavior(){
        this(0);
    }
    public PaddleMovementBehavior(double speed){
        this(new Vector(speed, 0));
    }
    public PaddleMovementBehavior(Vector speed){
        super(speed);
        this.rotationSpeed = 0;
        this.rotation = 0;
    }

    @Override
    public void move(Object o){
        Paddle paddle = (Paddle) o;

        Vector newLocation = paddle.getLocation().add(getSpeed());

        paddle.setLocation(newLocation);
        paddle.getBoundingBox().shift(getSpeed());
        setSpeed(new Vector(95*getSpeed().getX()/100, 0));
        //System.out.println("Rotation: "+rotation + " Speed: "+rotationSpeed + "Location: "  + paddle.getLocation().getX() + " " + paddle.getLocation().getY());
        /*Rotation mechanism */

        if(rotationSpeed != 0){
            if(rotation < -0.5 || rotation > 0.5 )
                rotationSpeed = rotationSpeed/2;
            else{
                rotation += rotationSpeed;
                paddle.getBoundingBox().rotate(rotationSpeed);
                rotationSpeed = rotationSpeed/2;
            }
        }else if(rotation > 0){
            paddle.getBoundingBox().rotate(-Constants.PADDLE_ROTATION_SPEED);
            rotation -= Constants.PADDLE_ROTATION_SPEED;
        }else if(rotation < 0){
            paddle.getBoundingBox().rotate(Constants.PADDLE_ROTATION_SPEED);
            rotation += Constants.PADDLE_ROTATION_SPEED;
        }
        if(Math.abs(rotationSpeed)<0.00001)
            rotationSpeed = 0;
        if(Math.abs(rotation) < Constants.PADDLE_ROTATION_SPEED){
            paddle.getBoundingBox().rotate(-rotation);
            rotation = 0;
        }
    }

    public void setRotationSpeed(double speed){
        this.rotationSpeed = speed;
    }

    public double getRotation() {
        return rotation;
    }
}
