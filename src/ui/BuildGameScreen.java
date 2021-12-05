package ui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class BuildGameScreen extends JFrame{
	public BuildGameScreen(int width, int height) {
		super("BuildGameScreen");
		setBounds(0,0,width,height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		add(mainPanel);
		JPanel obstaclePanel = obstaclesPanel();
		mainPanel.add(obstaclePanel);
	}
	//TODO: Obstacles Panel
		//TODO: Drag&Drop or Click and Drop?
	private JPanel obstaclesPanel(){
	JPanel obstaclesPanel = new JPanel(new GridLayout(4,1));
	//TODO : add figures of obstacles instead of texts
	JButton simpleObstacleButton = new JButton("Simple Obstacle");
	simpleObstacleButton.setActionCommand("Simple Obstacle)");
	simpleObstacleButton.addActionListener(new ActionListener()
    {
        //TODO: look for action on GameAreaPanel, if exists, get location, save, update totalShowPanel
		
		public void actionPerformed(ActionEvent ae)
        {
                                       
        }
    });
	JButton firmObstacleButton= new JButton("Firm Obstacle");
	firmObstacleButton.setActionCommand("FirmObstacleButton");
	firmObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
           
                        
        }
    });
	JButton explosiveObstacleButton = new JButton("Explosive Obstacle");
	explosiveObstacleButton.setActionCommand("explosiveObstacleButton");
	explosiveObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            
                           
        }
    });
	JButton giftObstacleButton = new JButton("Gift Obstacle");
	giftObstacleButton.setActionCommand("giftObstacleButton");
	giftObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
           
                         
        }
    });
	obstaclesPanel.add(simpleObstacleButton);
	obstaclesPanel.add(firmObstacleButton);
	obstaclesPanel.add(explosiveObstacleButton);
	obstaclesPanel.add(giftObstacleButton);
	return obstaclesPanel;
	}
	//TODO: Total Show Panel
	private JPanel TotalShowPanel() {
		JPanel totalShowPanel = new JPanel(new GridLayout(5,2));
		JLabel header1 = new JLabel("Type");
		JLabel header2 = new JLabel("# of Obstacles");
		JLabel simpleObstacleLabel = new JLabel("# of Simple Obstacles");
		JLabel simpleObstacleLabelNumber = new JLabel("0");
		JLabel firmObstacleLabel = new JLabel("# of Firm Obstacles");
		JLabel firmObstacleLabelNumber = new JLabel("0");
		JLabel explosiveObstacleLabel = new JLabel("# of Explosive Obstacles");
		JLabel explosiveObstacleLabelNumber = new JLabel("0");
		JLabel giftObstacleLabel = new JLabel("# of Gift Obstacles");
		JLabel giftObstacleLabelNumber = new JLabel("0");
		totalShowPanel.add(header1);
		totalShowPanel.add(header2);
		totalShowPanel.add(simpleObstacleLabel);
		totalShowPanel.add(simpleObstacleLabelNumber);
		totalShowPanel.add(firmObstacleLabel);
		totalShowPanel.add(firmObstacleLabelNumber);
		totalShowPanel.add(explosiveObstacleLabel);
		totalShowPanel.add(explosiveObstacleLabelNumber);
		totalShowPanel.add(giftObstacleLabel);
		totalShowPanel.add(giftObstacleLabelNumber);
		return totalShowPanel;
	}
	//for increasing number of obstacles placed 
	//can be called when new obstacle is placed
	private JLabel increseNumberOfLabel(JLabel numberLabel) {
		int previousNumber = Integer.parseInt(numberLabel.getText());
		numberLabel.setText(Integer.valueOf(previousNumber + 1).toString());
		return numberLabel;
	}
	//TODO: Game Area Panel
	private JPanel GameAreaPanel() {
		return new JPanel();
	}
	//TODO: Play button
	private void PlayButton() {
        JButton playButton = new JButton("Play");
        playButton.setSize(100, 30);
		playButton.setBounds(getBounds().width/2-playButton.getWidth()/2, getBounds().height/2, playButton.getWidth(), playButton.getHeight());
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //TODO: check if requirements satisfied
            	//if so save game (?) and call load game (?)
            	//else do not do anything
               
            }
        });
		
	}
	//TODO: User Name 
	private JPanel userNamePanel() {
		JPanel userNamePanel = new JPanel(new GridLayout(1,2));
		JLabel user = new JLabel("User name");
		JTextField userName = new JTextField(10);
		userNamePanel.add(user);
		userNamePanel.add(userName);
		return userNamePanel;
		
	}
	
	
}
