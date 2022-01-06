package ui;
import domain.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class LoadScreen extends JFrame {
    Color BACKGROUND_COLOR = new Color(240,230,140);
    private int width;
    private int height;
    GridBagConstraints gbc;

    public LoadScreen (String username){
        super("Help Screen");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) dim.getWidth();
        height = (int) dim.getHeight();

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gbc = new GridBagConstraints();
        JPanel mainPanel = new JPanel();
        mainPanel(mainPanel);

        //get file names from game.
        Game.getInstance().getSavedGames();

        JPanel loadGamePanel = new JPanel();
        gameList(mainPanel, loadGamePanel);
        setVisible(true);


    }

    private void mainPanel(JPanel mainPanel) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
    }

    public void gameList (JPanel mainPanel, JPanel loadGamePanel){
        loadGamePanel.setBorder(new EmptyBorder(new Insets(100, 150, 100, 150)));
        JLabel usernameLabel = new JLabel("Choose a game you would like to load");
        usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        usernameLabel.setForeground(Color.decode("#8b0000"));
        loadGamePanel.setBackground(BACKGROUND_COLOR);
        loadGamePanel.add(usernameLabel);
        mainPanel.add(loadGamePanel);


    }
}
