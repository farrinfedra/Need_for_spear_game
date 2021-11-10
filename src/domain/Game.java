package domain;

import physicalObjects.ObstacleType;
import physicalObjects.Vector;

public class Game {
    private static Game instance = null;

    private GameStatus status;
    private GameBoard gameBoard;


    private Game() {
       status = GameStatus.PAUSED;
       gameBoard = new GameBoard();
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();

        return instance;
    }

    public void movePaddle(Direction direction){ gameBoard.movePaddle(direction); }

    public void rotatePaddle(Direction direction){ gameBoard.rotatePaddle(direction); }

    public void addObstacle(ObstacleType type, Vector location) {gameBoard.addObstacle(type, location); }

    //TODO: implement magical ability functions

    public void loadGame(int slot){
        //TODO: implement loadGame
    }

    public void saveGame(int slot){
        //TODO: implement saveGame
    }

    public void enterBuildMode(){
        //TODO: implement enterBuildMode
    }

    public void enterPlayMode(){
        //TODO: implement enterPlayMode
    }

    public void doTickActions(){
        //TODO: implement doTickActions
    }

    public GameStatus isPaused() { return status; }

    public void switchPaused() {
        if (status == GameStatus.PAUSED) {
            status = GameStatus.UNPAUSED;
        } else {
            status = GameStatus.PAUSED;
        }
    }

    public GameSave saveGame(){
        return new GameSave(gameBoard);
    }

}


