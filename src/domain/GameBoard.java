package domain;

import physicalObjects.*;

import java.util.ArrayList;

public class GameBoard {

    private ArrayList<Obstacle> obstacles;
    private Ball ball;
    private Paddle paddle;

    public GameBoard(){
        obstacles = new ArrayList<Obstacle>();
        paddle = new Paddle();
        ball = new Ball();
    }

    public void movePaddle(Direction direction){ paddle.move(direction); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void addObstacle(ObstacleType type, Vector location) {
        //TODO: implement functionality
    }
}
