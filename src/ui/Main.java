package ui;
import domain.Direction;
import domain.Game;
import domain.GameStatus;
import domain.physicalObjects.Paddle;
import domain.physicalObjects.PhysicalObject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static HashMap<JLabel, PhysicalObject> labelToObjectMap = new HashMap<>();
    private static JFrame f = new JFrame();
    private static TitleScreen titleScreen = new TitleScreen();
    private static PauseScreen pauseScreen = new PauseScreen();

    public static void addPhysicalObjectLabel(PhysicalObject object){
        JLabel objectLabel = new JLabel(object.getImage());
        f.add(objectLabel);

        labelToObjectMap.put(objectLabel, object);
    }

    public static void updatePhysicalObjectLabel(JLabel label){
        PhysicalObject object = labelToObjectMap.get(label);

        int x = object.getLocation().getX();
        int y = object.getLocation().getY();
        int height = object.getHeight();
        int width = object.getWidth();

        label.setBounds(x, y, width, height);
    }

    public static void main(String[] args) {
        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        
        f.add(titleScreen.createTitleScreen(f.getWidth(), f.getHeight()));
        
        f.revalidate();
        f.repaint();

        Game game = Game.getInstance();
        game.createGameBoard(f.getWidth(), f.getHeight());

        addPhysicalObjectLabel(game.getGameBoard().getPaddle());

        JButton pauseButton = new JButton("Pause");
        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               pauseScreen.createPauseScreen(game, f);
               game.switchPaused();
               
            }
        });


        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT :
                        game.movePaddle(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.movePaddle(Direction.RIGHT);
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        pauseButton.setBounds(0,0,100, 40);//x axis, y axis, width, height

        f.add(pauseButton);

        
        f.setVisible(true);//making the frame visible

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pauseButton.setText(game.getStatus().toString());

                //Update all physical objects
                for(JLabel label: labelToObjectMap.keySet()){
                    updatePhysicalObjectLabel(label);
                }

                f.requestFocusInWindow();
            }
        });

        timer.start();
    }
}