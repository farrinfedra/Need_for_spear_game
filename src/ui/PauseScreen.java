package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Game;

public class PauseScreen extends JFrame {

    public PauseScreen(){
        super("Paused");
        setLayout(new BorderLayout());
        setBounds(50,100,200,100);
        setBackground(Color.orange);
        add(new JLabel("Game paused", SwingConstants.CENTER));

        JButton resumeButton = new JButton("RESUME");
        resumeButton.setBounds(150, 150, 100, 50);

        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Game.getInstance().resumeGame();
                setVisible(false);
                Game.getInstance().switchPaused();
            }
        });
        add(resumeButton, BorderLayout.PAGE_START);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(150, 150, 100, 50);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Game.getInstance().saveGame();
            }
        });
        add(saveButton, BorderLayout.PAGE_END);


        setVisible(true);
        revalidate();
        repaint();

    }

}
