package ui;

import domain.Direction;
import domain.Game;
import domain.Ymir;
import domain.abilities.Ability;
import domain.abilities.AbilityType;
import domain.abilities.UsefulAbilityType;
import domain.listeners.AbilityEvent;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.engines.AbilityEngine;
import domain.physicalobjects.obstacles.Obstacle;
import domain.services.Service;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RunningScreenPanel extends JPanel {

    private static List<PhysicalObjectLabel> labels = new ArrayList<>();
    public RunningScreenPanel(int width, int height){
        setBounds(0, 0, width, height);

        Service.addServiceListener(
                (serviceType, input, result) -> {
                    switch (serviceType){
                        case DESTROY:
                            labels = labels.stream()
                                    .filter(label -> {
                                        boolean predicate =  !(label.getPhysicalObject().equals(input));
                                        return predicate;
                                    })
                                    .collect(Collectors.toList());
                            break;
                        case SUMMON:
                            PhysicalObject physicalObject = (PhysicalObject) input;
                            PhysicalObjectLabel label = new PhysicalObjectLabel(physicalObject);
                            labels.add(label);

                            break;
                    }

                    revalidate();
                    repaint();
                }
        );
        RunningScreenInfoPanel infoPanel = new RunningScreenInfoPanel();
        add(infoPanel);
    
        /*JPanel activeAbilities = new JPanel();
        add(activeAbilities);
        */
        AbilityEngine.getInstance().addEventListener(o -> {
            AbilityEvent event = (AbilityEvent) o;

            if(event.isActive()){
                //JLabel label = new JLabel(event.getAbility().toString());
                infoPanel.setActiveAbility(event.getAbility());
               
            }
            else{
                infoPanel.removeAbility(event.getAbility());
            }
        });


        Game game = Game.getInstance();
        Ymir ymir = new Ymir();

        if (game.getGameBoard() == null){
            game.createGameBoard(getWidth(), getHeight());
        }

        for(PhysicalObject object: game.getGameBoard().getPhysicalObjects()){
            if(object instanceof Paddle)
                labels.add(new PaddleLabel((Paddle) object));
            else
                labels.add(new PhysicalObjectLabel(object));
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.getInstance().shootBall();
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
                    case KeyEvent.VK_UP:
                        game.shootBall();
                        break;
                    case KeyEvent.VK_A:
                        game.rotatePaddle(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.rotatePaddle(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_W:
                        game.shootBall();
                        break;
                    case KeyEvent.VK_H:
                        game.useAbility(AbilityType.MagicalHexAbility);
                        break;
                    case KeyEvent.VK_T:
                        game.useAbility(AbilityType.PaddleExpansionAbility);
                        break;
                    case KeyEvent.VK_SPACE:
                        game.shootMagicalHex();
                        break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        /*JLabel abilities = new JLabel("lol");
        add(abilities);
        abilities.setBounds(100,0, 1000, 40);

        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new PauseScreen(getWidth()/2, getHeight()/2));
                game.switchPaused();
            }
        });

        pauseButton.setBounds(0,0,100, 40);
        add(pauseButton);*/
        
       
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //pauseButton.setText(game.getStatus().toString());
                
                //abilities.setText(game.getAvailableAbilities().toString());
                infoPanel.setAbilityLabels();
                infoPanel.setScore();
                infoPanel.setLives();
                requestFocusInWindow();
                revalidate();
                repaint();
            }
        });

        timer.start();
        game.start();
        ymir.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(this.getClass().getResource(Constants.BACKGROUND_IMG_PATH)).getImage(), 0,0, getWidth(), getHeight(), (img, infoflags, x, y, width, height) -> false);

        for(PhysicalObjectLabel label: new ArrayList<>(labels))
            label.paint(g);
    }
}
