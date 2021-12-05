package domain.loadSave;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import domain.GameBoard;
import domain.physicalobjects.Obstacle;
//external java-simple module for json
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SaveLoad {
    private GameBoard gameBoard; //TODO: is it wrong to do this?
    private Date date;
    HashMap<String, Integer> loadedGame;



    public SaveLoad(GameBoard gameBoard){
        this(gameBoard, new Date());
    }
    public SaveLoad(GameBoard gameBoard, Date date){
        this.gameBoard = gameBoard;
        this.date = date;
        saveGame();

    }
    public void saveGame() {
        JSONObject savedGame = new JSONObject();
        JSONArray obstacles = new JSONArray();
        JSONObject playerInfo = new JSONObject();
        JSONObject magicalAbilities = new JSONObject();
        int playerID = 45; //TODO: make dynamic
        int score = 100; // TODO: make dynamic
        int chances = 2; // TODO: make dynamic

        //adding player info.
        playerInfo.put("playerID", String.valueOf(playerID));
        playerInfo.put("Date", date.toString());
        playerInfo.put("Score", score);
        playerInfo.put("chances", chances);
        savedGame.put("PlayerInfo", playerInfo);

        //adding obstacles object
        for (Obstacle o : gameBoard.getObstacles() ){ //get name of obstacle
            obstacles.add(o);
        }
        savedGame.put("Obstacles", obstacles);


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
    public void loadGame(String username){
        JSONParser jsonParser = new JSONParser();
        loadedGame = new HashMap<String, Integer>();

        try (FileReader reader = new FileReader(String.format("%s.json", username)))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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


