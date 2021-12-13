package ui;

import domain.Direction;
import domain.Game;
import domain.listeners.ServiceListener;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Wall;
import domain.physicalobjects.obstacles.Obstacle;
import domain.services.DestroyService;
import domain.services.SummonService;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RunningScreen extends JFrame{
    private static ArrayList<PhysicalObjectLabel> labelList = new ArrayList<>();
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

        for(PhysicalObject physicalObject: game.getGameBoard().getPhysicalObjects()){
            PhysicalObjectLabel label = new PhysicalObjectLabel(physicalObject);
            labelList.add(label);
            add(label);
        }

        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new PauseScreen(getWidth()/2, getHeight()/2));
                game.switchPaused();
            }
        });

        SummonService.addServiceListener(
                new ServiceListener() {
                    @Override
                    public void onServicePerformed(Object o) {

                    }
                }
        );

        DestroyService.addServiceListener(
                new ServiceListener() {
                    @Override
                    public void onServicePerformed(Object o) {
                                //Deletion of Destroyed PhysicalObjects
                                labelList.stream()
                                        .filter(label -> label.getPhysicalObject().equals(o))
                                        .forEach(label->remove(label));

//                                objectToLabelMap = objectToLabelMap.entrySet()
//                                        .stream()
//                                        .filter(map -> !map.getValue().equals(o))
//                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                                revalidate();
                                repaint();
                    }
                }
        );

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

                //Update all physical objects
                for(PhysicalObjectLabel l: labelList){
                    updatePhysicalObjectLabel(l);
                }

                int size = game.getGameBoard().getPhysicalObjects().size();
                for(int i = 0; i< size; i++){
                    PhysicalObject physicalObject = game.getGameBoard().getPhysicalObjects().get(i);
                    if(!existsInLabelsList(physicalObject)){
                        PhysicalObjectLabel label = new PhysicalObjectLabel(physicalObject);
                        labelList.add(label);
                        add(label);
                    }
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

    private Boolean existsInLabelsList(PhysicalObject physicalObject){
        for(PhysicalObjectLabel label: labelList){
            if(label.getPhysicalObject() != physicalObject){
                return true;
            }
        }
        return false;
    }

    private void updatePhysicalObjectLabel(PhysicalObjectLabel label){
        PhysicalObject object = label.getPhysicalObject();

        int x =  (int) object.getLocation().getX();
        int y = (int) object.getLocation().getY();
        int height = (int) object.getHeight();
        int width = (int) object.getWidth();

       // label.setIcon(object.getImage());
        label.setBounds(x, y, width, height);
    }
}
