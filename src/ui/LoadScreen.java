package ui;

import domain.Game;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.obstacles.ObstacleType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoadScreen extends JFrame {
    private Game game;
    private ObstacleType currentObstacle = ObstacleType.SimpleObstacle;
    private int width;
    private int height;
    private static HashMap<PhysicalObject, JLabel> objectToLabelMap = new HashMap<>();

    public LoadScreen (int width, int height){
        super("LoadScreen");
        this.width = width;
        this.height = height;
        setBounds(0,0,width,height);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        game = Game.getInstance();
//        game.createGameBoard(width, height);

        JLabel userLabel = new JLabel("Enter Label");
        JTextField usernameField = new JTextField();
        JButton enterButton = new JButton("Enter");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LoadScreen(width, height);
            }
        });

        add(userLabel);
        add(usernameField);
        add(enterButton);


    }
}
