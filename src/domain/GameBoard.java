package domain;

import domain.physicalObjects.*;

import javax.swing.*;
import java.util.ArrayList;

public class GameBoard {

    private ArrayList<Obstacle> obstacles;
    private Ball ball;
    private Paddle paddle;
    private Vector size;

    public GameBoard(Vector size){
        this.size = size;
        obstacles = new ArrayList<Obstacle>();
        paddle = new Paddle(new Vector(0,size.getY()-100), new ImageIcon(this.getClass().getResource("/img/paddle.png")), 0, size.getX());

        //ball = new Ball(new Vector(0,100), null);
    }

    public Paddle getPaddle(){return this.paddle;}
    public void movePaddle(Direction direction){ paddle.move(direction); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void addObstacle(ObstacleType type, Vector location) {
        //TODO: implement functionality
    }

    public Vector getSize() {
        return size;
    }
}
