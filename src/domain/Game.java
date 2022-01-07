package domain;

import domain.abilities.AbilityType;
import domain.abilities.UsefulAbilityType;
import domain.loadsave.LoadGame;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.loadsave.SaveGame;
import domain.physicalobjects.Vector;

import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {
    private static Game instance = null;


    private GameStatus status;
    private GameBoard gameBoard;
    private SaveGame saveGame;
    private LoadGame loadGame;

    private Game() {
       status = GameStatus.RESUMED;
    }

    public void createGameBoard(int width, int height){
        gameBoard = new GameBoard(new Vector(width, height));
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();

        return instance;
    }

    public void movePaddle(Direction direction){ if(status == GameStatus.RESUMED) gameBoard.movePaddle(direction); }
    public void rotatePaddle(Direction direction){ if(status == GameStatus.RESUMED) gameBoard.rotatePaddle(direction); }
    public void addObstacle(ObstacleType type, Vector location) {gameBoard.addObstacle(type, location); }

    public void useAbility(AbilityType type){
        gameBoard.useAbility(type);
    }
    public List<UsefulAbilityType> getAvailableAbilities(){return gameBoard.getAvailableAbilities();}
    public void shootMagicalHex(){gameBoard.shootMagicalHex();}

    //TODO: implement magical ability functions

    public void loadGame(int slot){
        //TODO: get username from user;

        loadGame = new LoadGame("player1");
        loadGame.loadGame();
        ArrayList<ArrayList<Double>> obstacles= loadGame.getObstacles();
        ArrayList<Integer> abilities = loadGame.getAbilities();
        String username = loadGame.getUsername();
        double score = loadGame.getScore();
        int lives = loadGame.getlives();
    }

    public void saveGame(int slot){
        //TODO: implement saveGame
        saveGame = new SaveGame(getGameBoard());
        saveGame.saveGame();
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

    public void infiniteVoid() {
        gameBoard.infiniteVoid();
    }

    public void doubleAccel() {
        gameBoard.doubleAccel();
    }

    public void hollowPurple() {
        gameBoard.hollowPurple();
    }

    public void run(){

        System.out.println("MyClass running");
        while(true){
            try {
                Thread.sleep(10);

                if(gameBoard != null && status == GameStatus.RESUMED)
                    gameBoard.doTickActions();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPlayerName(String username) {
        gameBoard.getPlayer().setUsername(username);
    }

    public void getSavedGames() {

    }
    public void setStickToPaddle(Boolean value) {
        gameBoard.setStickToPaddle(value);
    }

    public boolean isBallStickToPaddle() {
        return gameBoard.isBallStickToPaddle();
    }

    public void shootBall() {
        gameBoard.shootBall();

    }

    public Vector getSize() {
        return gameBoard.getSize();
    }

    public void loseChance() {
        gameBoard.loseChance();
    }
}


