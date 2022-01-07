package ui;
import domain.Game;
import domain.loadsave.LoadGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoadScreen extends JFrame {
    Color BACKGROUND_COLOR = new Color(240, 230, 140);
    Color TEXT_COLOR = new Color(128,128,0);
    private int width;
    private int height;
    GridBagConstraints gbc;
    ArrayList<String> list = new ArrayList<>();
    private Game game;
    private LoadGame loadGame;

    public LoadScreen(String username) {
        super("Load Screen");
        game = Game.getInstance();
        list = game.getSavedGames(username);

        if (list.size() == 1) {
            dispose();
            // new load screen
            //load the game immediately
        } else {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) dim.getWidth();
            height = (int) dim.getHeight();


            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            gbc = new GridBagConstraints();
            JPanel mainPanel = new JPanel();
            mainPanel(mainPanel);

            JPanel introPanel = new JPanel();
            introLabel(mainPanel, introPanel, list);


            JPanel listPanel = new JPanel();
            listLabelsPanel(mainPanel, listPanel, list);
            setVisible(true);
        }


    }

    private void mainPanel(JPanel mainPanel) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
    }

    public void introLabel(JPanel mainPanel, JPanel loadGamePanel, ArrayList<String> list) {
        loadGamePanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(100, 50, 100, 50);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        String message = "Looks like you have %d saved games. Choose one below."
                .formatted(list.size());
        JLabel numSavedLabel = new JLabel(message);
        numSavedLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        numSavedLabel.setForeground(Color.decode("#8b0000"));
        loadGamePanel.setBackground(BACKGROUND_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loadGamePanel.add(numSavedLabel);
        mainPanel.add(loadGamePanel);

    }

    public void listLabelsPanel(JPanel mainPanel, JPanel listPanel, ArrayList<String> list) {
        //list loaded files
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            JButton label = new JButton(s);
            label.setFont(new Font("Helvetica", Font.BOLD, 14));
            label.setForeground(TEXT_COLOR);
            listPanel.setBackground(BACKGROUND_COLOR);
            gbc.gridx=i;
            gbc.gridy=0;
            label.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String gameName = label.getText(); //get saved game name
                    game.createGameBoard(width, height);
                    game.loadGame(gameName);
                    new RunningScreen();

                }
            });

            listPanel.add(label);
        }

        mainPanel.add(listPanel);
    }


}
