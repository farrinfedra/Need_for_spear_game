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
	private boolean isDeletingMode = false;
	private Point drawPoint;

	public BuildScreen(int width, int height, String username) {
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
		game.setPlayerName(username);

		JPanel obstaclePanel = obstaclesPanel();
		add(obstaclePanel, BorderLayout.PAGE_START);
		JPanel startPanel = startPanel();
		add(startPanel, BorderLayout.SOUTH);
		JPanel deletingModePanel = deletingModePanel();
		add(deletingModePanel, BorderLayout.EAST);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawPoint = MouseInfo.getPointerInfo().getLocation();
				//drawPoint.x -= 25;
				//drawPoint.y -= 45;
				if(isDeletingMode) {
					removeObstacle(drawPoint);
				}else {
				addObstacle(drawPoint, currentObstacle);
				}
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


	private void removeObstacle(Point removePoint) {
		double x = removePoint.getX();
		double y = removePoint.getY();
		for (PhysicalObject obstacle : objectToLabelMap.keySet()) {
			double obsX = obstacle.getLocation().getX()+20;

			double upperX = obsX + obstacle.getWidth();
			double lowerX = obsX;
			double obsY = obstacle.getLocation().getY()+20;
			double lowerY = obsY;
			double upperY = obsY + obstacle.getHeight();
			//if there exists a object in within the clicked point
			//System.out.printf("clicked x: %f y: %f lowerX : %f upperX: %f lowerY: %f upperY: %f \n", x,y, lowerX,upperX,lowerY,upperY);
			if ((x >= lowerX && x<=upperX) && (y >= lowerY && y<=upperY)) {
				//Destroy obstacle
				obstacle.getService(0).perform(obstacle);
				System.out.printf("TRUE\n");
				removePhysicalObjectLabel(obstacle);
				break;
			}
		}

	}
	private void removePhysicalObjectLabel(PhysicalObject object) {
		JLabel objectLabel = objectToLabelMap.get(object);
		remove(objectLabel);
		objectToLabelMap.remove(object);
	}
	private void addObstacle(Point drawPoint, ObstacleType type){
		int x = (int) (50*Math.round(drawPoint.x/50)- (int)(40/2));
		int y = (int) (50*Math.round(drawPoint.y/50)-(int)(40/2));
		boolean isFound = false;
		for (PhysicalObject obstacle : objectToLabelMap.keySet()) {
			double obsX = obstacle.getLocation().getX()+20;

			double upperX = obsX + obstacle.getWidth();
			double lowerX = obsX;
			double obsY = obstacle.getLocation().getY()+20;
			double lowerY = obsY;
			double upperY = obsY + obstacle.getHeight();
			//if there exists a object in within the clicked point
			if ((x >= lowerX && x<=upperX) && (y >= lowerY && y<=upperY)) {
				isFound = true;
				break;
			}
		}
		if(!isFound) {
			Obstacle obstacle = game.getGameBoard().addObstacle(type, new Vector(x, y));
			addPhysicalObjectLabel(obstacle);
		}
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

	private JPanel deletingModePanel() {
		JPanel deletePanel = new JPanel(new GridLayout(1,1));
		JButton deleteButton = new JButton("Delete Obstacle");
		deleteButton.setActionCommand("Delete Obstacle");
		deleteButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(!isDeletingMode) {
				isDeletingMode = true;
				deleteButton.setText("Delete Mode is on");
			}
			else {
				isDeletingMode = false;
				deleteButton.setText("Delete Obstacle");
			}
		}
	});
		deletePanel.add(deleteButton);
		return deletePanel;
	}

	private JPanel startPanel() {
		JPanel startPanel = new JPanel(new GridLayout(1,1));
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
		startPanel.add(startGameButton);
		return startPanel;
	}
	private JPanel obstaclesPanel(){
	JPanel obstaclesPanel = new JPanel(new GridLayout(1,4));


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

JTextField usernameField = new JTextField("username",10);

		obstaclesPanel.add(simpleObstacleButton);
	obstaclesPanel.add(firmObstacleButton);
	obstaclesPanel.add(explosiveObstacleButton);
	obstaclesPanel.add(giftObstacleButton);
	obstaclesPanel.add(usernameField);
	//obstaclesPanel.add(user);
	return obstaclesPanel;
	}



	/*private JPanel TotalShowPanel() {
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
	/* 	//for increasing number of obstacles placed
	//can be called when new obstacle is placed
	private JLabel increseNumberOfLabel(JLabel numberLabel) {
		int previousNumber = Integer.parseInt(numberLabel.getText());
		numberLabel.setText(Integer.valueOf(previousNumber + 1).toString());
		return numberLabel;
	}*/

	private JPanel userNamePanel() {
		JPanel userNamePanel = new JPanel(new GridLayout(1,2));
		JLabel user = new JLabel("User name");
		JTextField userName = new JTextField(10);
		userNamePanel.add(user);
		userNamePanel.add(userName);
		return userNamePanel;

	}


}

