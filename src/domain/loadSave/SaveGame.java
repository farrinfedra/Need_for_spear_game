package domain.loadSave;

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
        JSONArray obstaclesList = new JSONArray();
        JSONObject playerInfo = new JSONObject();
        JSONArray obj;

        String username = "player1"; //TODO: make dynamic
        int score = 100; // TODO: make dynamic
        int chances = 2; // TODO: make dynamic

        //adding player info.
        playerInfo.put("Username", username);
        playerInfo.put("Date", date.toString());
        savedGame.put("PlayerInfo", playerInfo);


        ArrayList<Obstacle> obstacles = gameBoard.getObstacles();


int i = 0;
        for(Obstacle o : obstacles) {

            if(o.toString().equals("FirmObstacle")) {i = 0;}
            if(o.toString().equals("SimpleObstacle")) {i = 1;}
            if(o.toString().equals("ExplosiveObstacle")) {i = 2;}
            if(o.toString().equals("GiftObstacle")) {i = 3;}
            obj = new JSONArray();
            obj.add(i);
            obj.add(o.getHealth());
            obj.add(o.getX());
            obj.add(o.getY());
            obstaclesList.add(obj);
        }

        savedGame.put("Obstacles", obstaclesList);

        try(FileWriter file = new FileWriter(String.format("%s.json", username))){
            file.write(savedGame.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }

}





/*
Format of json file

{
  "playerInfo": {
    "Username": "username",
    "Obstacles": [
        [i, health, x, y],
        [i, health, x, y],
        [i, health, x, y],
        [i, health, x, y]
    ]
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


