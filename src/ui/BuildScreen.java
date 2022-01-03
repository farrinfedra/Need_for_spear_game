package ui;
import domain.Game;
import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.ObstacleType;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;


public class BuildScreen extends JFrame{
	private Game game;
	private ObstacleType currentObstacle = ObstacleType.SimpleObstacle;
	private int width;
	private int height;
	private static HashMap<PhysicalObject, JLabel> objectToLabelMap = new HashMap<>();

	private Point drawPoint;

	public BuildScreen(int width, int height) {
		super("BuildGameScreen");
		this.width = width;
		this.height = height;
		setBounds(0,0,width,height);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		game = Game.getInstance();
		game.createGameBoard(width, height);

//		JPanel mainPanel = new JPanel();
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//		add(mainPanel, BorderLayout.PAGE_END);
		JPanel obstaclePanel = obstaclesPanel();
		add(obstaclePanel, BorderLayout.PAGE_START);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawPoint = MouseInfo.getPointerInfo().getLocation();
				drawPoint.x -= 25;
				drawPoint.y -= 45;
				addObstacle(drawPoint, currentObstacle);
				repaint();
			}
		});

		Timer timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				//Update all physical objects
				for(PhysicalObject object: objectToLabelMap.keySet()){
					updatePhysicalObjectLabel(object);
				}
				requestFocusInWindow();
			}
		});

		timer.start();

		setVisible(true);
		revalidate();
		repaint();
	}



	private void addObstacle(Point drawPoint, ObstacleType type){
		int x = (int) (50*Math.round(drawPoint.x/50) + 22.5);
		int y = (int) (50*Math.round(drawPoint.y/50) + 22.5);
		Obstacle obstacle = game.getGameBoard().addObstacle(type, new Vector(x, y));
		addPhysicalObjectLabel(obstacle);
	}

	private void addPhysicalObjectLabel(PhysicalObject object){
		JLabel objectLabel = new JLabel("");
		objectLabel.setBackground(Color.CYAN);
		objectLabel.setOpaque(true);
		add(objectLabel);
		objectToLabelMap.put(object, objectLabel);
	}

	private static void updatePhysicalObjectLabel(PhysicalObject object){

		int x = (int) object.getLocation().getX();
		int y = (int) object.getLocation().getY();
		int height = (int) object.getHeight();
		int width = (int) object.getWidth();

		objectToLabelMap.get(object)
				.setBounds(x, y, width, height);
	}



	//TODO: Obstacles Panel
	//TODO: Drag&Drop or Click and Drop?
	private JPanel obstaclesPanel(){
	JPanel obstaclesPanel = new JPanel(new GridLayout(4,1));
	JButton startGameButton = new JButton("Start Game");
		startGameButton.setActionCommand("Start Game");
		startGameButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			setVisible(false);
			new RunningScreen();
		}
	});

	//TODO : add figures of obstacles instead of texts
	JButton simpleObstacleButton = new JButton("Simple Obstacle");
	simpleObstacleButton.setActionCommand("Simple Obstacle)");
	simpleObstacleButton.addActionListener(new ActionListener()
    {
        //TODO: look for action on GameAreaPanel, if exists, get location, save, update totalShowPanel
		
		public void actionPerformed(ActionEvent ae)
        {
			currentObstacle = ObstacleType.SimpleObstacle;
        }
    });
	JButton firmObstacleButton= new JButton("Firm Obstacle");
	firmObstacleButton.setActionCommand("FirmObstacleButton");
	firmObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
			currentObstacle = ObstacleType.FirmObstacle;
                        
        }
    });
	JButton explosiveObstacleButton = new JButton("Explosive Obstacle");
	explosiveObstacleButton.setActionCommand("explosiveObstacleButton");
	explosiveObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
			currentObstacle = ObstacleType.ExplosiveObstacle;
        }
    });
	JButton giftObstacleButton = new JButton("Gift Obstacle");
	giftObstacleButton.setActionCommand("giftObstacleButton");
	giftObstacleButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
			currentObstacle = ObstacleType.GiftObstacle;
        }
    });
	obstaclesPanel.add(startGameButton);
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
