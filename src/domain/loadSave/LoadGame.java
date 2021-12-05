package domain.loadSave;

import domain.physicalobjects.obstacles.Obstacle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class LoadGame {

    private String username;
    private ArrayList<Integer[]> obstacles;

    public LoadGame(String username) {this.username = username;}
    private JSONObject obs;
    public void loadGame() {
        JSONParser jsonParser = new JSONParser();


        //read file
        try (FileReader reader = new FileReader(String.format("%s.json", username)))
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

    //public ArrayList<Objects>

//public ArrayList<Integer[]> getObstacles(){
//        JSONArray obstacleArray = (JSONArray) obs.get("Obstacles");
//        obstacles = new ArrayList<Integer[]>();
//        obstacleArray.forEach(ar -> {
//            int health = ar.
//        });
//        System.out.println(Arrays.toString(obstacles.toArray()));
//
//
//
//        return obstacles;
//}
//
}
