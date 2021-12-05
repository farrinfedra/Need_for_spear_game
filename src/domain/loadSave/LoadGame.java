package domain.loadSave;

import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadGame {

    private String username;
    private HashMap<Vector, String> obstacles;

    public LoadGame(String username) {this.username = username;}

    public void loadGame() {
        JSONParser jsonParser = new JSONParser();


        //read file
        try (FileReader reader = new FileReader(String.format("%s.json", username)))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject obs = (JSONObject) obj;
            getObstacles((JSONObject) obs.get("Obstacles"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //public ArrayList<Objects>
public HashMap<Vector, String> getObstacles(JSONObject obs){
        obstacles = new HashMap<Vector, String>();
        //create Vectors of x and y


        return obstacles;
}

}
