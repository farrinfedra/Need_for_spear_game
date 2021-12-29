package domain;

import domain.abilities.UsefulAbilityType;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String username;
    private int lives;
    private int score;
    private List<UsefulAbilityType> abilities;

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

    public List<UsefulAbilityType> getAbilities() {
        return abilities;
    }

    public String getUsername() {
        return username;
    }
}
