package domain;

import domain.physicalobjects.*;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.engines.PhysicsEngine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {

    private ArrayList<Obstacle> obstacles;
    private ArrayList<Wall> walls;
    private Ball ball;
    private Paddle paddle;
    private Vector size;

    public GameBoard(Vector size){
        this.size = size;
        obstacles = new ArrayList<Obstacle>();
        walls = new ArrayList<Wall>();

        walls.add(new Wall(new Vector(0,-50), size.getX(), 50));
        walls.add(new Wall(new Vector(-50,0), 50, size.getY()));
        walls.add(new Wall(new Vector(size.getX(), 0), 50, size.getY()));
        walls.add(new Wall(new Vector(0, size.getY()), size.getX(), 50));

        paddle = new Paddle(new Vector(500,size.getY()-100), new ImageIcon(this.getClass().getResource("/img/paddle.png")));

        //ball = new Ball(new Vector(0,100), null);
    }

    public Paddle getPaddle(){return this.paddle;}
    public ArrayList<Obstacle> getObstacles(){return this.obstacles;}
    public void movePaddle(Direction direction){ paddle.setSpeed((direction == Direction.LEFT) ? -10: 10); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void addObstacle(ObstacleType type, Vector location) {
        //TODO: implement functionality
    }

    public void doTickActions(){
        //TODO: implement doTickActions
        ArrayList<PhysicalObject> physicalObjects = new ArrayList<>();

        physicalObjects.add(paddle);
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
}
