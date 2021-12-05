package domain;

import domain.physicalobjects.*;
import domain.physicalobjects.collision.NoCollisionBehavior;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.engines.PhysicsEngine;
import domain.physicalobjects.movement.StationaryMovementBehavior;
import domain.physicalobjects.obstacles.*;

import javax.swing.*;
import java.util.ArrayList;


public class GameBoard implements RemoveObjectListener{

    private ArrayList<Obstacle> obstacles;
    private ArrayList<Wall> walls;
    private Ball ball;
    private Paddle paddle;
    private Vector size;

    public GameBoard(Vector size){
        this.size = size;
        obstacles = new ArrayList<Obstacle>();
        paddle = new Paddle(new Vector(500,size.getY()-100), new ImageIcon(this.getClass().getResource("/img/paddle.png")));

        walls = new ArrayList<Wall>();

        walls.add(new Wall(new Vector(0,-50), size.getX(), 50, new Vector(0, -1)));
        walls.add(new Wall(new Vector(-50,0), 50, size.getY(), new Vector(-1, 0)));
        walls.add(new Wall(new Vector(size.getX(), 0), 50, size.getY(), new Vector(1, 0)));
        walls.add(new Wall(new Vector(0, size.getY()), size.getX(), 50,  new Vector(0, 1)));

        //TO-DO revise initial starting point
        ball = new Ball(new Vector(100,100), null, 50, 50);
    }

    public Obstacle addObstacle(ObstacleType type, Vector location){
        Obstacle obstacle = ObstacleFactory.getInstance().create(type, location);
        obstacles.add(obstacle);
        return obstacle;
    }

    public Ball getBall(){return this.ball;}
    public Paddle getPaddle(){return this.paddle;}
    public ArrayList<Obstacle> getObstacles(){return this.obstacles;}
    public void movePaddle(Direction direction){ paddle.setSpeed((direction == Direction.LEFT) ? -10: 10); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }



    public void removeObstacle(Obstacle obstacle){
        obstacles.remove(obstacle);
    }


    public void doTickActions(){
        //TODO: implement doTickActions
        ArrayList<PhysicalObject> physicalObjects = new ArrayList<>();

        physicalObjects.add(paddle);
        physicalObjects.add(ball);
        physicalObjects.addAll(walls);


        CollisionEngine.getInstance().handleCollisions(physicalObjects);
        PhysicsEngine.getInstance().moveObjects(physicalObjects);
    }

    public Vector getSize() {
        return size;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    @Override
    public void onPropertyEvent(PhysicalObject physicalObject) {
        if (physicalObject instanceof Obstacle){
            removeObstacle((Obstacle) physicalObject);
        }
    }
}
