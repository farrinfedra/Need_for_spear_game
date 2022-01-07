package ui;

import domain.Game;

import javax.swing.*;

public class LoadedGameScreen extends JFrame {
    private int width;
    private int height;
    private String gameName;
    private Game game;

    public LoadedGameScreen(int width, int height, String gameName){

        super("BuildGameScreen");
        this.width = width;
        this.height = height;
        this.gameName = gameName;

        setBounds(0,0,width,height);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a gameboard
        game = Game.getInstance();
        game.createGameBoard(width, height);

        // add obstacles
        // add abilities
        // set score
        // set lives

        addObstacles();
        addAbilities();

    }

    private void addAbilities() {

    }

    private void addObstacles() {

    }
}
