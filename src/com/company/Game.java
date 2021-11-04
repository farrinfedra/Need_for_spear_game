package com.company;

class Game {
    private static Game single_instance = null;

    private boolean isPaused;

    private Game()
    {
       isPaused = false;
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
}