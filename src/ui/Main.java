package ui;
import domain.Game;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();

        JFrame f = new JFrame();//creating instance of JFrame

        JButton pauseButton =new JButton("Pause");//creating instance of JButton
        JButton saveButton =new JButton("Save");//creating instance of JButton

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               game.switchPaused();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.saveGame();
            }
        });

        JLabel gameStatusLabel =  new JLabel();

        pauseButton.setBounds(130,100,100, 40);//x axis, y axis, width, height
        saveButton.setBounds(130,50,100, 40);//x axis, y axis, width, height
        gameStatusLabel.setBounds(100, 100, 100, 100);

        f.add(pauseButton);//adding button in JFrame
        f.add(saveButton);
        f.add(gameStatusLabel);

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String gameStatus = game.isPaused() ? "Paused" : "Running";

                gameStatusLabel.setText(gameStatus);
            }
        });

        timer.start();
    }
}