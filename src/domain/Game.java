package domain;

public class Game {
    private static Game single_instance = null;

    private boolean isPaused;
    private GameBoard gameBoard;

    private Game()
    {
       isPaused = false;
       gameBoard = new GameBoard();
    }

    public static Game getInstance() {
        if (single_instance == null)
            single_instance = new Game();

        return single_instance;
    }


    public boolean isPaused() {
        return isPaused;
    }

    public void switchPaused() {
        isPaused = !isPaused;
    }

    public GameSave saveGame(){
        return new GameSave(gameBoard);
    }
}