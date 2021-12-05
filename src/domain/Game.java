package domain;

import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.loadSave.SaveLoad;
import domain.physicalobjects.Vector;

public class Game extends Thread {
    private static Game instance = null;

    private GameStatus status;
    private GameBoard gameBoard;
    private SaveLoad saveLoad;

    private Game() {
       status = GameStatus.RESUMED;
    }

    public void createGameBoard(int width, int height){
        gameBoard = new GameBoard(new Vector(width, height));
        addRemoveObjectListener(gameBoard);
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();

        return instance;
    }

    public void movePaddle(Direction direction){ if(status == GameStatus.RESUMED) gameBoard.movePaddle(direction); }
    public void rotatePaddle(Direction direction){ if(status == GameStatus.RESUMED) gameBoard.rotatePaddle(direction); }
    public void addObstacle(ObstacleType type, Vector location) {gameBoard.addObstacle(type, location); }

    //TODO: implement magical ability functions

    public void loadGame(int slot){
        //TODO: implement loadGame
        saveLoad = new SaveLoad(getGameBoard());
        //saveLoad.loadGame(username); //get username
    }

    public void saveGame(int slot){
        //TODO: implement saveGame
        saveLoad = new SaveLoad(getGameBoard());
        saveLoad.saveGame();
    }

    public void enterBuildMode(){
        //TODO: implement enterBuildMode
    }

    public void enterPlayMode(){
        //TODO: implement enterPlayMode
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public GameStatus getStatus() { return status; }

    public void switchPaused() {
        if (status == GameStatus.PAUSED) {
            status = GameStatus.RESUMED;
        } else {
            status = GameStatus.PAUSED;
        }
    }

//    public GameSave saveGame(){
//        return new GameSave(gameBoard);
//    }

    public void run(){
        System.out.println("MyClass running");

        while(true){
            try {
                Thread.sleep(10);

                if(gameBoard != null)
                    gameBoard.doTickActions();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addRemoveObjectListener(RemoveObjectListener listener) {
        CollisionEngine.getInstance().addRemoveObjectListener(listener);
    }
}


