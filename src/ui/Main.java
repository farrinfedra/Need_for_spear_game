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

        JPanel titleScreen = new JPanel();
        titleScreen.setSize(f.WIDTH, f.HEIGHT);
        titleScreen.setLayout(null);
        titleScreen.setBounds(0,0,f.getWidth(),f.getHeight());
        titleScreen.setBackground(Color.RED);
        f.add(titleScreen);
        titleScreen.setVisible(true);
        titleScreen.revalidate();
        titleScreen.repaint();
        JButton playButton = new JButton("Play");
        
        playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				titleScreen.setVisible(false);
			}
		});
       
        playButton.setLocation(titleScreen.getWidth()/2, titleScreen.getHeight()/2);
        titleScreen.add(playButton);
        
        
        
        Game game = Game.getInstance();
        game.createGameBoard(f.getWidth(), f.getHeight());

        addPhysicalObjectLabel(game.getGameBoard().getPaddle());

        JButton pauseButton = new JButton("Pause");
        JButton saveButton = new JButton("Save");

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               JPanel pausedPanel = new JPanel();
               pausedPanel.setLayout(new BoxLayout(pausedPanel, BoxLayout.Y_AXIS));
               pausedPanel.setBounds(50,100,200,100);    
               pausedPanel.setBackground(Color.orange);
               pausedPanel.add(new JLabel("Game paused"));
               
               JButton button1 = new JButton("RESUME");
               
               button1.addActionListener(new ActionListener() {
            	   public void actionPerformed(ActionEvent e){
            	       game.resumeGame();
            	       pausedPanel.setVisible(false);
            	       game.switchPaused();
            	   }
               });
               pausedPanel.add(button1, BorderLayout.WEST);
               
               JButton button2 = new JButton("SAVE");
               
               button2.addActionListener(new ActionListener() {
            	   public void actionPerformed(ActionEvent e){
            	       game.saveGame();
            	   }
               });
               pausedPanel.add(button2, BorderLayout.EAST);
               
               f.add(pausedPanel);  
               pausedPanel.setVisible(true);
               pausedPanel.revalidate();
               pausedPanel.repaint();
               
               game.switchPaused();
               
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.saveGame();
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
        saveButton.setBounds(100,0,100, 40);//x axis, y axis, width, height


        f.add(pauseButton);
        f.add(saveButton);


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