package domain.services;

import domain.GameBoard;

public abstract class GameBoardService  implements Service{
    private GameBoard gameBoard;

    public GameBoardService(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    protected GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public abstract void perform(Object o);
}
