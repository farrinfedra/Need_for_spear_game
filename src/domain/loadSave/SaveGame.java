package domain.loadSave;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import domain.GameBoard;
//import domain.physicalobjects.Obstacle;
//external java-simple module for json
import domain.physicalobjects.obstacles.Obstacle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SaveGame {
    private GameBoard gameBoard; //TODO: is it wrong to do this?
    private Date date;
    HashMap<String, Integer[]> loadedGame;



    public SaveGame(GameBoard gameBoard){
        this(gameBoard, new Date());
    }
    public SaveGame(GameBoard gameBoard, Date date){
        this.gameBoard = gameBoard;
        this.date = date;

    }
    public void saveGame() {
        JSONObject savedGame = new JSONObject();
        JSONObject obstaclesList = new JSONObject();
        JSONObject playerInfo = new JSONObject();
        JSONArray obj;
//        JSONArray expOb = new JSONArray();
//        JSONArray simpleOb = new JSONArray();
//        JSONArray giftOb = new JSONArray();

        //JSONObject magicalAbilities = new JSONObject();
        String username = "fedra"; //TODO: make dynamic
        int score = 100; // TODO: make dynamic
        int chances = 2; // TODO: make dynamic

        //adding player info.
        playerInfo.put("Username", String.valueOf(username));
        playerInfo.put("Date", date.toString());
        savedGame.put("PlayerInfo", playerInfo);

        //adding obstacles object\
        //obstacles.put("Simple Obstacle", gameBoard.getObstacles());
//        for (Obstacle o : gameBoard.getObstacles() ){ //get name of obstacle
//            obstacles.add(o);
//        }
        ArrayList<Obstacle> obstacles = gameBoard.getObstacles(); //fix obstacle


//get count of each obstacle
int count = 0;
        for(Obstacle o : obstacles) {
            count++;
            obj = new JSONArray();
            obj.add(o.toString());
            obj.add(o.getHealth());
            obj.add(o.getX());
            obj.add(o.getY());
            obstaclesList.put(String.format("obstacle%d", count), obj);
        }

        savedGame.put("Obstacles", obstaclesList);

        try(FileWriter file = new FileWriter(String.format("%s.json", username))){
            file.write(savedGame.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }



    public void loadGame(String username){
        JSONParser jsonParser = new JSONParser();
        loadedGame = new HashMap<String, Integer[]>();

        //read file
        try (FileReader reader = new FileReader(String.format("%s.json", username)))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            System.out.println(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}





/*
Format of json file

{
  "playerInfo": {
    "Username": "username",
    "score": "score",
    "lives": "lives",
    "objects": {
        "obstacle1": [name, health, x, y],
        "obstacle2": [name, health, x, y],
        "obstacle3": [name, health, x, y],
        "obstacle4": [name, health, x, y]
    }
  },
  "magicalAbilities": {
    {
      "ChanceGiving": [count, location],
      "NoblePhantasmExpansion": [count, location],
      "Magical Hex": [count, location],
      "Unstoppable Enchanted Sphere": [count, location]
    }
  }
}
 */


