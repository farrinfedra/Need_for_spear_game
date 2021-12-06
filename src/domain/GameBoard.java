package domain;

import domain.physicalobjects.*;
import domain.physicalobjects.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.engines.PhysicsEngine;
import domain.physicalobjects.movement.StationaryMovementBehavior;
import domain.physicalobjects.obstacles.*;

import javax.swing.*;
import java.util.ArrayList;


public class GameBoard{
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Wall> walls;
    private Ball ball;
    private Paddle paddle;
    private Vector size;

    public GameBoard(Vector size){
        this.size = size;
        obstacles = new ArrayList<Obstacle>();
        paddle = new Paddle(new Vector(500,size.getY()-100), null, 200, 10);

        walls = new ArrayList<Wall>();

        walls.add(new Wall(new Vector(0,-50), size.getX(), 50, new Vector(0, -1)));
        walls.add(new Wall(new Vector(-50,0), 50, size.getY(), new Vector(-1, 0)));
        walls.add(new Wall(new Vector(size.getX(), 0), 50, size.getY(), new Vector(1, 0)));
        walls.add(new Wall(new Vector(0, size.getY()), size.getX(), 50,  new Vector(0, 1)));

        //TO-DO revise initial starting point
        ball = new Ball(new Vector(size.getX()/2,size.getY()/2), null, 50, 50);
    }

    public Obstacle addObstacle(ObstacleType type, Vector location){
        Obstacle obstacle = ObstacleFactory.getInstance().create(type, location);
        obstacles.add(obstacle);
        return obstacle;
    }

    public Ball getBall(){return this.ball;}
    public Paddle getPaddle(){return this.paddle;}
    public ArrayList<Obstacle> getObstacles(){return this.obstacles;}
    public void movePaddle(Direction direction){ paddle.setSpeed((direction == Direction.LEFT) ? -9: 9); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void removeObstacle(Obstacle obstacle){
        obstacles.remove(obstacle);
    }

    public void doTickActions(){
        //TODO: implement doTickActions
        ArrayList<PhysicalObject> physicalObjects = new ArrayList<>();

        physicalObjects.add(ball);
        physicalObjects.addAll(obstacles);
        physicalObjects.add(paddle);
        physicalObjects.addAll(walls);

        CollisionEngine.getInstance().handleCollisions(physicalObjects);
        PhysicsEngine.getInstance().moveObjects(physicalObjects);

        clearDestroyed(physicalObjects);
    }

    public Vector getSize() {
        return size;
    }
    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void clearDestroyed(ArrayList<PhysicalObject> physicalObjects) {
        for(PhysicalObject physicalObject: physicalObjects)
            if(physicalObject.isDestroyed()){
                if(physicalObject instanceof Obstacle)
                    obstacles.remove(physicalObject);
                else if(physicalObject instanceof Paddle)
                    paddle = null;
                else if(physicalObject instanceof Ball)
                    ball = null;
            }
    }
}
