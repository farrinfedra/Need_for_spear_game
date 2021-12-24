package ui;

import domain.Direction;
import domain.Game;
import domain.listeners.ServiceListener;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.PhysicalObject;

import domain.physicalobjects.Wall;
import domain.physicalobjects.behaviors.collision.Collision;
import domain.physicalobjects.engines.CollisionEngine;
import domain.services.Service;
import domain.services.ServiceType;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunningScreen extends JFrame{
    private static List<PhysicalObjectLabel> labels = new ArrayList<>();

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
            labels.add(label);
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
        pauseButton.setBounds(0,0,100, 40);
        add(pauseButton);

        CollisionEngine.addEventListener(o -> {
            Collision collision = (Collision) o;

            labels.stream()
                    .filter(label ->
                            label.getPhysicalObject().equals(collision.getO1())
                                    || label.getPhysicalObject().equals(collision.getO2()))
                            .forEach(label-> label.flash());

            Timer timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    labels.stream()
                            .filter(label ->
                                    label.getPhysicalObject().equals(collision.getO1())
                                            || label.getPhysicalObject().equals(collision.getO2()))
                            .forEach(label-> label.unflash());
                }
            });
            timer.setInitialDelay(100);
            timer.setRepeats(false);
            timer.start();
        }
        );

        Service.addServiceListener(
                (serviceType, input, result) -> {
                    switch (serviceType){
                        case DESTROY:
                            labels = labels.stream()
                                            .filter(label -> {
                                                      boolean predicate =  !(label.getPhysicalObject().equals(input));
                                                      if(!predicate)
                                                          remove(label);
                                                      return predicate;
                                            })
                                            .collect(Collectors.toList());
                            break;
                        case SUMMON:
                            PhysicalObject physicalObject = (PhysicalObject) input;
                            PhysicalObjectLabel label = new PhysicalObjectLabel(physicalObject);
                            labels.add(label);
                            add(label);
                            break;
                    }

                    revalidate();
                    repaint();
                }
        );

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

                //Take the copy to avoid exceptions due to iterator usage.
                List<PhysicalObjectLabel> labelsCopy = new ArrayList<>(labels);
                //Update all physical objects
                for(PhysicalObjectLabel label: labelsCopy){
                    label.update();
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
}
