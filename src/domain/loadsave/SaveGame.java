package domain.loadsave;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import domain.GameBoard;
//import domain.physicalobjects.Obstacle;
//external java-simple module for json
import domain.Player;
import domain.abilities.UsefulAbilityType;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.obstacles.Obstacle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SaveGame {
    private GameBoard gameBoard; //TODO: is it wrong to do this?
    private Date date;
    private Player player;


    public SaveGame(GameBoard gameBoard){
        this(gameBoard, new Date());
    }
    public SaveGame(GameBoard gameBoard, Date date){
        this.gameBoard = gameBoard;
        this.date = date;
        this.player = gameBoard.getPlayer();

    }
    public void saveGame() {
        JSONObject savedGame = new JSONObject();
        JSONArray obstaclesList = new JSONArray();
        JSONArray abilitiesList = new JSONArray();
        JSONObject playerInfo = new JSONObject();
        JSONArray obj;
        JSONArray obj2;

        List<PhysicalObject> obstacles = gameBoard.getPhysicalObjects();
        List<UsefulAbilityType> abilities = gameBoard.getAvailableAbilities();

        //adding player info.
        playerInfo.put("username", player.getUsername());
        playerInfo.put("lives", player.getLives());
        playerInfo.put("score", player.getScore());
        playerInfo.put("date", date.toString());
        savedGame.put("playerInfo", playerInfo);


        int i = 0;
        int health = 0;
        for(PhysicalObject o : obstacles) {
            if (o.getClass().getSuperclass().getSimpleName().equals("Obstacle") ){
//                o = (Obstacle) o;
                if(o.toString().equals("FirmObstacle")) {
                    i = 0;
                }
                else if(o.toString().equals("SimpleObstacle")) {
                    i = 1;
                }
                else if(o.toString().equals("ExplosiveObstacle")) {
                    i = 2;
                }
                else if(o.toString().equals("GiftObstacle")) {
                    i = 3;
                }
                obj = new JSONArray();
                health = ((Obstacle) o).getHealth();
                obj.add(i);
                obj.add(health);
                obj.add(o.getLocation().getX());
                obj.add(o.getLocation().getY());
                obstaclesList.add(obj);
            }

        }

        savedGame.put("obstacles", obstaclesList);
        int j = 0;
        for (UsefulAbilityType a : abilities){
            if(a.toString().equals("ChanceGivingAbility")) {
                j = 0;
            }
            else if(a.toString().equals("MagicalHexAbility")) {
                j = 1;
            }
            else if(a.toString().equals("PaddleExpansionAbility")) {
                j = 2;
            }

            else if(a.toString().equals("UnstoppableBallAbility")) {
                j = 3;
            }
            obj2 = new JSONArray();
            obj2.add(j);
            abilitiesList.add(obj2);
        }
        savedGame.put("abilities", abilitiesList);


        try(FileWriter file = new FileWriter(String.format("%s.json", player.getUsername()))){
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
    "username": "username",
    "score": "score",
    "lives": "lives",
    "obstacles": [
        [i, health, x, y],
        [i, health, x, y],
        [i, health, x, y],
        [i, health, x, y]
    ]
  },
  "abilities": [

       [type],
       [type],
       [type],
       [type],

  ]
}
 */


