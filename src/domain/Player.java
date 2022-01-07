package domain;

import domain.abilities.AbilityType;
import domain.abilities.UsefulAbilityType;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String username;
    private int lives;
    private double score;
    private List<UsefulAbilityType> abilities;

    public Player(){
        this.abilities = new ArrayList<>();
        this.score = 0;
        this.lives = Constants.PLAYER_INITIAL_LIVES;
    }

    public int getLives() {
        return lives;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public List<UsefulAbilityType> getAbilities() {
        return new ArrayList<>(abilities);
    }

    public void addAbility(UsefulAbilityType abilityType){
        abilities.add(abilityType);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }

    public boolean removeAbility(AbilityType type) {
        return abilities.remove(type);
    }
}
