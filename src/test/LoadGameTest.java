package test;

import domain.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoadGameTest {

    @Before
    public void setUp() throws Exception {
        Game game = Game.getInstance();
    }

    @Test
    public void getSavedGameList() {
        ArrayList<String> files = new ArrayList<>();
        File dir = new File("./savedGames");
        int fileCount = 0;
        File[] dir_contents = dir.listFiles();
        for(File file : dir_contents){
            if(file.getName().contains("Atakan")) {
                fileCount ++;
                files.add(file.getName());
            }
        }
        for (String file : files) {
            System.out.println("File name is %s".formatted(file));
        }
    }
}