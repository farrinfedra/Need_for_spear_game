package domain.loadsave;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoadGame {

    private String username;

    public LoadGame(String username) {this.username = username;}
    private JSONObject obs;


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
    public void getLoadedGame(String fileName){
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

        ArrayList<ArrayList<Double>> obstacles = new ArrayList<>();

        double id = 0;
        double health = 0;
        double x = 0;
        double y = 0;
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

        return obstacles;
    }
    public ArrayList<Integer> getAbilities(){
        ArrayList<Integer> abilities = new ArrayList<>();
        int count = 0;

        JSONArray abilitiesArray = new JSONArray();
        abilitiesArray = (JSONArray) obs.get("abilities");

        for (int i = 0; i < 4; i ++){
            count = Integer.valueOf(abilitiesArray.get(i).toString());
            abilities.add(count);
        }

        return abilities;
    }

    public String getUsername(){
        return username;
    }

    public double getScore(){
        double score = Double.valueOf(obs.get("score").toString());
        return score;
    }
    public int getlives(){
        int lives = Integer.valueOf(obs.get("lives").toString());
        return lives;
    }

}
