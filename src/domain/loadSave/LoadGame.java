package domain.loadSave;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class LoadGame {

    private String username;
    private ArrayList<ArrayList<Integer>> obstacles;

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

public ArrayList<ArrayList<Integer>> getObstacles(){
        JSONArray obstacleArray = new JSONArray();
        obstacleArray = (JSONArray) obs.get("Obstacles");

        obstacles = new ArrayList<ArrayList<Integer>>();

    int id = 0;
    int health = 0;
    int x = 0;
    int y = 0;
    for (int i = 0 ; i<obstacleArray.size(); i++){
        JSONArray temp = new JSONArray();
        temp = (JSONArray) obstacleArray.get(i);
        id = Integer.valueOf(temp.get(0).toString());
        health = Integer.valueOf(temp.get(1).toString());
        x = Integer.valueOf(temp.get(2).toString());
        y = Integer.valueOf(temp.get(3).toString());
       ArrayList<Integer> temps = new ArrayList<Integer>();
       temps.add(id);
        temps.add(health);
        temps.add(x);
        temps.add(y);
        obstacles.add(temps);

    }

        return obstacles;
}

}
