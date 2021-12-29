package domain;

import domain.abilities.AbilityType;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String username;
    private int lives;
    private int score;
    private List<AbilityType> abilities;

    public Player(String username){
        this.username = username;
        this.abilities = new ArrayList<>();
        this.score = 0;
        this.lives = Constants.PLAYER_INITIAL_LIVES;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public List<AbilityType> getAbilities() {
        return abilities;
    }

    public String getUsername() {
        return username;
    }
}
