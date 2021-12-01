package domain;

import domain.physicalobjects.Paddle;

import java.util.ArrayList;

public class CollisionCalculator {
    public void calculate(GameBoard gameBoard) {
        Paddle paddle = gameBoard.getPaddle();
        ArrayList<Obstacle> obstacles = gameBoard.getObstacles();


    }
}
