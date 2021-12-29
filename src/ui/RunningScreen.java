package ui;

import domain.Direction;
import domain.Game;
import domain.abilities.UsefulAbilityType;
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

    public RunningScreen(){
        super("Need for Spear");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0,0,width,height);

        JPanel panel = new RunningScreenPanel(width, height);
        setContentPane(panel);

        /*
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

         */

        setResizable(true);
        setVisible(true);
        revalidate();
        repaint();
    }
}
