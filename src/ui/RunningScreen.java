package ui;

import domain.Direction;
import domain.Game;
import domain.RemoveObjectListener;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Wall;
import domain.physicalobjects.obstacles.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class RunningScreen extends JFrame implements RemoveObjectListener {
    private static HashMap<PhysicalObject, JLabel> objectToLabelMap = new HashMap<>();

    public RunningScreen(){
        super("Need for Spear");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();

        setSize(width, height);

        setLayout(null);//using no layout managers
        Game game = Game.getInstance();

        if (game.getGameBoard() == null){
            game.createGameBoard(width, height);
        }

        game.addRemoveObjectListener(this);

        //Adding all PhysicalObjects to GameBoard as JLabel
        addPhysicalObjectLabel(game.getGameBoard().getPaddle());
        addPhysicalObjectLabel(game.getGameBoard().getBall());

        for(Wall wall: game.getGameBoard().getWalls())
            addPhysicalObjectLabel(wall);

        for(Obstacle obstacle: game.getGameBoard().getObstacles())
            addPhysicalObjectLabel(obstacle);


        JButton pauseButton = new JButton("Pause");

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PauseScreen();
                game.switchPaused();

            }
        });

        addKeyListener(new KeyListener() {
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
//
        add(pauseButton);

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pauseButton.setText(game.getStatus().toString());

                //Update all physical objects
                for(PhysicalObject object: objectToLabelMap.keySet()){
                    updatePhysicalObjectLabel(object);
                }
                requestFocusInWindow();
            }
        });

        timer.start();

        setVisible(true);

        revalidate();
        repaint();
    }


    private void addPhysicalObjectLabel(PhysicalObject object){
        JLabel objectLabel = new JLabel(object.getImage());
        objectLabel.setBackground(Color.CYAN);
        objectLabel.setOpaque(true);
        add(objectLabel);
        objectToLabelMap.put(object, objectLabel);
    }

    private void removePhysicalObject(PhysicalObject physicalObject){
        remove(objectToLabelMap.get(physicalObject));
        revalidate();
        repaint();
    }

    private static void updatePhysicalObjectLabel(PhysicalObject object){

        int x = object.getLocation().getX();
        int y = object.getLocation().getY();
        int height = object.getHeight();
        int width = object.getWidth();

        objectToLabelMap.get(object)
                .setBounds(x, y, width, height);
    }


    @Override
    public void onPropertyEvent(PhysicalObject physicalObject) {
        removePhysicalObject(physicalObject);
    }
}
