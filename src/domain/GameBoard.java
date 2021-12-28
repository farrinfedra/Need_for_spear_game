package domain;

import domain.physicalobjects.*;
import domain.physicalobjects.engines.AbilityEngine;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.engines.PhysicsEngine;
import domain.physicalobjects.obstacles.*;
import domain.services.GameBoardServiceFactory;

import java.util.ArrayList;
import java.util.List;


public class GameBoard{
    private ArrayList<PhysicalObject> physicalObjects;

    private Ball ball;
    private Paddle paddle;
    private Vector size;

    public GameBoard(Vector size){
        this.size = size;
        physicalObjects = new ArrayList<>();

        paddle = new Paddle(new Vector(300,size.getY()-100), null, 200, 20);
        ball = new Ball(new Vector(size.getX()/2,size.getY()/2), null, 25, 25);

        //TO-DO revise initial starting point
        physicalObjects.add(ball);
        physicalObjects.add(paddle);
        physicalObjects.add(new Wall(new Vector(0,-21), size.getX(), 20));
        physicalObjects.add(new Wall(new Vector(-21,20), 20, size.getY()));
        physicalObjects.add(new Wall(new Vector(size.getX()+1, 0), 20, size.getY()));
        physicalObjects.add(new Wall(new Vector(0, size.getY()+1), size.getX(), 20));
    }

    public void addPhysicalObject(PhysicalObject physicalObject){
        physicalObjects.add(physicalObject);
    }

    public List<PhysicalObject> getPhysicalObjects(){
        return this.physicalObjects;
    }

    public Obstacle addObstacle(ObstacleType type, Vector location){
        Obstacle obstacle = ObstacleFactory.getInstance().create(type, location, GameBoardServiceFactory.getInstance().setGameBoard(this));
        physicalObjects.add(obstacle);
        return obstacle;
    }

    public void movePaddle(Direction direction){ paddle.setSpeed((direction == Direction.LEFT) ? new Vector(-9, 0): new Vector(9, 0)); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void doTickActions(){
        //TODO: implement doTickActions
        CollisionEngine.getInstance().handleCollisions(physicalObjects);
        PhysicsEngine.getInstance().moveObjects(physicalObjects);
        AbilityEngine.getInstance().calculate(physicalObjects);
    }

    public Vector getSize() {
        return size;
    }
}
