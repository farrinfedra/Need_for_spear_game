package com.company;

import java.util.Date;

public class GameSave {
    private GameBoard gameBoard;
    private Date date;

    public GameSave(GameBoard gameBoard){
        this(gameBoard, new Date());
    }

    public GameSave(GameBoard gameBoard, Date date){
        this.gameBoard = gameBoard;
        this.date = date;
    }
}
