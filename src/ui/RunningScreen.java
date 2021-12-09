package ui;

import domain.Direction;
import domain.Game;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Wall;
import domain.physicalobjects.obstacles.Obstacle;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RunningScreen extends JFrame{
    private static Map<JLabel, PhysicalObject> objectToLabelMap = new HashMap<>();

    public RunningScreen(){
        super("Need for Spear");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();

        setVisible(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Game game = Game.getInstance();

        if (game.getGameBoard() == null){
            game.createGameBoard(width, height);
        }

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
                add(new PauseScreen(getWidth()/2, getHeight()/2));
                game.switchPaused();
            }
        });
        pauseButton.setBounds(0,0,100, 40);
        add(pauseButton);

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





        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pauseButton.setText(game.getStatus().toString());

                //Deletion of Destroyed PhysicalObjects
                objectToLabelMap.entrySet()
                                                    .stream()
                                                    .filter(map -> map.getValue().isDestroyed())
                                                    .forEach(map->remove(map.getKey()));

                objectToLabelMap = objectToLabelMap.entrySet()
                                                    .stream()
                                                    .filter(map -> !map.getValue().isDestroyed())
                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                //Update all physical objects
                for(JLabel l: objectToLabelMap.keySet()){
                    updatePhysicalObjectLabel(l);
                }

                requestFocusInWindow();
                revalidate();
                repaint();
            }
        });

        timer.start();
        game.start();

        setResizable(true);
        setVisible(true);
        revalidate();
        repaint();
    }

    private void addPhysicalObjectLabel(PhysicalObject object){
        JLabel objectLabel = new JLabel(object.getImage());
        objectLabel.setBackground(Color.GREEN);
        objectLabel.setOpaque(true);
        add(objectLabel);

        objectToLabelMap.put(objectLabel, object);
    }

    private void removePhysicalObjectLabel(JLabel label){
        objectToLabelMap.remove(label);
        remove(label);
        revalidate();
        repaint();
    }

    private void updatePhysicalObjectLabel(JLabel label){
        PhysicalObject object = objectToLabelMap.get(label);

        int x =  (int) object.getLocation().getX();
        int y = (int) object.getLocation().getY();
        int height = (int) object.getHeight();
        int width = (int) object.getWidth();

       // label.setIcon(object.getImage());
        label.setBounds(x, y, width, height);
    }
}
