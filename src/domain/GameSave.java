package domain;

import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
//external java-simple module for json
import domain.physicalobjects.Obstacle;
import domain.physicalobjects.Wall; //should i add packages?
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GameSave {
    private GameBoard gameBoard;
    private Date date;


    public GameSave(GameBoard gameBoard){
        this(gameBoard, new Date());
    }

    public GameSave(GameBoard gameBoard, Date date){
        this.gameBoard = gameBoard;
        this.date = date;
        saveGame();

    }
    public void saveGame() {
        JSONObject savedGame = new JSONObject();
        JSONArray obstacles = new JSONArray();
        JSONArray walls = new JSONArray();
        JSONObject playerInfo = new JSONObject();
        JSONObject magicalAbilities = new JSONObject();
        int playerID = 45; //change this to real ID

        playerInfo.put("playerID", String.valueOf(playerID));
        playerInfo.put("Date", date.toString());
        savedGame.put("PlayerInfo", playerInfo);
        for (Obstacle o : gameBoard.getObstacles() ){
            obstacles.add(o);
        }
        savedGame.put("Obstacles", obstacles);

        for (Wall w : gameBoard.getWalls() ){ //should i add walls?
            walls.add(w);
        }

        savedGame.put("Walls", walls);

        // TODO: 12/3/21
        //Add player Id or name + level + #lives to player ID
        //Add getName function for Obstacles
        //modify the obstacle array in json to array of objects



        try(FileWriter file = new FileWriter("savedGame.json")){
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
    "playerID": "id",
    "Username": "username",
    "level": "level",
    "lives": "lives",
    "obstacles": [
      {
        "obstacle1": "count",
        "obstacle2": "count"
      }
    ]
  },
  "magicalAbilities": [
    {
      "magicalAbility": "count",
      "magicalAbility2": "count"
    }
  ]
}
 */


