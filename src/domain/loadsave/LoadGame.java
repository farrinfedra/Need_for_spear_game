package domain.loadsave;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoadGame {

    private String username;
    private ArrayList<ArrayList<Double>> obstacles;

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



    public ArrayList<ArrayList<Double>> getObstacles(){
        JSONArray obstacleArray = new JSONArray();
        obstacleArray = (JSONArray) obs.get("obstacles");

        obstacles = new ArrayList<ArrayList<Double>>();

        double id = 0;
        double health = 0;
        double x = 0;
        double y = 0;
        for (int i = 0 ; i<obstacleArray.size(); i++){
            JSONArray temp = new JSONArray();
            temp = (JSONArray) obstacleArray.get(i);
            id = Integer.valueOf(temp.get(0).toString());
            health = Integer.valueOf(temp.get(1).toString());
            x = Double.valueOf(temp.get(2).toString());
            y = Double.valueOf(temp.get(3).toString());
            ArrayList<Double> temps = new ArrayList<Double>();
            temps.add(id);
            temps.add(health);
            temps.add(x);
            temps.add(y);
            obstacles.add(temps);

        }

        return obstacles;
    }
//    public ArrayList<ArrayList<Integer>> getAbilities(){
//
//    }

    public String getUsername(){
        return username;
    }

    public double getScore(){
        return 0;
    }
    public int getlives(){
        return 0;
    }

}
