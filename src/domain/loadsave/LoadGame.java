package domain.loadsave;

import domain.Game;
import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.ObstacleType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class LoadGame {

    private String username;
    private JSONObject obs;
    private GameBoard gameBoard;
    private ArrayList<ArrayList<Double>> obstacles;
    private ArrayList<Integer> abilities;
    
    public LoadGame(String username) {

        this.username = username;
        gameBoard = Game.getInstance().getGameBoard();
    }

    public ArrayList<String> getSavedGameList() {

        ArrayList<String> files = new ArrayList<>();
        File dir = new File("./savedGames");
        File[] dir_contents = dir.listFiles();
        for(File file : dir_contents){
            if(file.getName().contains(username)) {
                files.add(file.getName());
            }
        }
        return files;
    }
    public void loadGame(String fileName){
        //open & read file
        readFile(fileName);
        readObstacles();
        readAbilities();
        readScore();
        readLives();
        //setup gameboard
        setUpGameBoard();

    }



    private void readFile(String fileName) {
        JSONParser jsonParser = new JSONParser();

        //read file
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            obs = new JSONObject();
            obs = (JSONObject) obj;
            System.out.println(obs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void readObstacles(){
        JSONArray obstacleArray = new JSONArray();
        obstacleArray = (JSONArray) obs.get("obstacles");

        obstacles = new ArrayList<>();

        double id;
        double health;
        double x;
        double y;
        for (int i = 0 ; i<obstacleArray.size(); i++){
            JSONArray temp = new JSONArray();
            temp = (JSONArray) obstacleArray.get(i);
            id = Double.valueOf(temp.get(0).toString());
            health = Double.valueOf(temp.get(1).toString());
            x = Double.valueOf(temp.get(2).toString());
            y = Double.valueOf(temp.get(3).toString());
            ArrayList<Double> temps = new ArrayList<Double>();
            temps.add(id);
            temps.add(health);
            temps.add(x);
            temps.add(y);
            obstacles.add(temps);

        }

    }
    public void readAbilities(){
        ArrayList<Integer> abilities = new ArrayList<>();
        int count;

        JSONArray abilitiesArray = new JSONArray();
        abilitiesArray = (JSONArray) obs.get("abilities");

        for (int i = 0; i < 4; i ++){
            count = Integer.valueOf(abilitiesArray.get(i).toString());
            abilities.add(count);
        }

    }

    public String getUsername(){
        return username;
    }

    public double readScore(){
        double score = Double.valueOf(obs.get("score").toString());
        return score;
    }
    public int readLives (){
        int lives = Integer.valueOf(obs.get("lives").toString());
        return lives;
    }

    private void setUpGameBoard() {
        //Add obstacles
        addObstacles();
        //Add abilities
        addAbilities();
        //Set score & lives
        addScore();
        addLives();
    }

    private void addLives() {
    }

    private void addScore() {
    }

    private void addAbilities() {
    }

    private void addObstacles(){
        int i = 0;
        for (ArrayList<Double> a : obstacles){

            int id = a.get(0).intValue();
            int health = a.get(1).intValue();
            double x = a.get(2);
            double y = a.get(3);

            gameBoard.addObstacle((ObstacleType) Arrays.stream(ObstacleType.values()).toArray()[id], new Vector(x, y));
            Obstacle o = (Obstacle) gameBoard.getPhysicalObjects().get(i);


            i++;

        }

    }

}
