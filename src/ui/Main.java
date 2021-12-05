package ui;

import domain.Game;

import java.awt.*;

public class Main{

    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();
        BuildScreen buildScreen = new BuildScreen(width, height);

        Game game = Game.getInstance();
        game.start();

    }

}