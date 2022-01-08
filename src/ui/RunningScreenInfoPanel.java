package ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import domain.*;
import domain.abilities.*;


public class RunningScreenInfoPanel extends JPanel{
	GridBagConstraints gbc;
	Game game;
	double width;
	double height;
	JLabel chanceGivingLabel, magicalHexLabel, paddleExpansionLabel, unstoppableBallLabel;
	JButton chanceGivingButton, magicalHexButton, paddleExpansionButton, unstoppableBallButton;
	JLabel scoreLabel, livesLabel, activeAbilityLabel;
	Color DEFAULT = new Color(238,232,170);
	Color HIGHLIGHT = new Color(128,128,0);
	//HashMap<Ability, JLabel> abilityLabels = new HashMap<>();
	public RunningScreenInfoPanel() {
		
		game = Game.getInstance();
		width = game.getGameBoard().getSize().getX() ;
		height = game.getSize().getY()/6;
		
		setSize((int) width, (int)height);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		gbc = new GridBagConstraints();
		JPanel infoPanel = infoPanel();
		JPanel abilitiesPanel =  abilitiesPanel();
		JPanel pauseSavePanel = pauseSavePanel();
		setBackground(new Color(240,230,140));
		add(infoPanel);
		add(abilitiesPanel);
		add(pauseSavePanel);

	}
	private JPanel infoPanel() {
		JPanel infoPanel = new JPanel(new GridBagLayout());
		infoPanel.setSize((int) width/3, (int)height);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel scoreText = new JLabel("Score:");
		//TODO: Add score information from game
		scoreLabel = new JLabel("0");
		JLabel livesText = new JLabel("Lives:");
		//TODO: Add live information from game
		livesLabel = new JLabel("3");
		JLabel activeText = new JLabel("Active Abilities:");
		activeAbilityLabel = new JLabel("");
		
		gbc.gridx=0;
		gbc.gridy=0;
		infoPanel.add(scoreText,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		infoPanel.add(scoreLabel,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		infoPanel.add(livesText,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		infoPanel.add(livesLabel,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		infoPanel.add(activeAbilityLabel,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		infoPanel.add(activeText,gbc);
		
		

		Border borderLine = BorderFactory.createLineBorder(Color.black);
		infoPanel.setBorder(borderLine);
		infoPanel.setOpaque(false);
		
		return infoPanel;
	}
	
	private JPanel abilitiesPanel() {
		JPanel abilitiesPanel = new JPanel(new GridBagLayout());
		abilitiesPanel.setSize((int) width/3, (int)height);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		//TODO: Add images
		//TODO Get available ability number
		chanceGivingLabel = new JLabel("0");
		chanceGivingButton = new JButton("Chance Giving");
		chanceGivingButton.setBackground(DEFAULT);
		chanceGivingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Activate Magical Ability
				game.useAbility(AbilityType.ChanceGivingAbility);
				
			}
		});
		//TODO Get available ability number
		magicalHexLabel = new JLabel("0");
		magicalHexButton = new JButton("Magical Hex");
		magicalHexButton.setBackground(DEFAULT);
		chanceGivingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Activate Magical Ability
				game.useAbility(AbilityType.MagicalHexAbility);
				
			}
		});
		//TODO Get avaliable ability number
		paddleExpansionLabel = new JLabel("0");
		paddleExpansionButton = new JButton("Paddle Expansion");
		paddleExpansionButton.setBackground(DEFAULT);
		paddleExpansionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Activate Magical Ability
				game.useAbility(AbilityType.PaddleExpansionAbility);
				
			}
		});
		//TODO Get avaliable ability number
		unstoppableBallLabel = new JLabel("0");
		unstoppableBallButton = new JButton("Unstoppable Ball");
		unstoppableBallButton.setBackground(DEFAULT);
		unstoppableBallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Activate Magical Ability
				game.useAbility(AbilityType.UnstoppableBallAbility);
				
			}
		});
		
		gbc.gridx=0;
		gbc.gridy=0;
		abilitiesPanel.add(chanceGivingButton, gbc);
		gbc.gridx=0;
		gbc.gridy = 1;
		abilitiesPanel.add(chanceGivingLabel,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		abilitiesPanel.add(magicalHexButton,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		abilitiesPanel.add(magicalHexLabel,gbc);
		gbc.gridx=2;
		gbc.gridy=0;
		abilitiesPanel.add(paddleExpansionButton,gbc);
		gbc.gridx=2;
		gbc.gridy=1;
		abilitiesPanel.add(paddleExpansionLabel, gbc);
		gbc.gridx=3;
		gbc.gridy=0;
		abilitiesPanel.add(unstoppableBallButton,gbc);
		gbc.gridx=3;
		gbc.gridy=1;
		abilitiesPanel.add(unstoppableBallLabel,gbc);
		
		Border borderLine = BorderFactory.createLineBorder(Color.black);
		abilitiesPanel.setBorder(borderLine);
		abilitiesPanel.setOpaque(false);
		
		return abilitiesPanel;
	}
	
	private JPanel pauseSavePanel() {
		JPanel pauseSavePanel = new JPanel(new GridBagLayout());
		pauseSavePanel.setSize((int) width/3, (int)height);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new PauseScreen(getWidth()/2, getHeight()/2));
                game.switchPaused();
            }
        });
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO: slot?
            	game.saveGame(1);
                
            }
        });
        gbc.gridx=0;
		gbc.gridy=0;
		pauseSavePanel.add(pauseButton,gbc);
		gbc.gridx=1;
		gbc.gridy = 0;
		pauseSavePanel.add(saveButton, gbc);
        
		Border borderLine = BorderFactory.createLineBorder(Color.black);
		pauseSavePanel.setBorder(borderLine);
		pauseSavePanel.setOpaque(false);
		
		return pauseSavePanel;
	}
	
	public void setLives() {
		//TODO Get lives info from gameboard?
		livesLabel.setText(Integer.valueOf(game.getLives()).toString());
	}
	
	public void setScore() {
		//TODO Get score information from game?
		scoreLabel.setText(Integer.valueOf(game.getScore()).toString());
	}
	
	public void setAbilityLabels() {
		//TODO Get avaliable ability numbers and update
		int chanceCounter = 0; int hexCounter =0; int expansionCounter =0;int unstopCounter=0;
		List<AbilityType> availableAbilties = game.getAvailableAbilities();
		for (AbilityType a :  availableAbilties) {
			if (a == AbilityType.ChanceGivingAbility) {
				chanceCounter += 1;
			}
			if (a == AbilityType.MagicalHexAbility) {
				hexCounter +=1;
			}
			if (a == AbilityType.UnstoppableBallAbility) {
				unstopCounter +=1;
				
			}if (a == AbilityType.PaddleExpansionAbility) {
				expansionCounter +=1;
			}
			
			chanceGivingLabel.setText(Integer.valueOf(chanceCounter).toString());
			magicalHexLabel.setText(Integer.valueOf(hexCounter).toString());
			unstoppableBallLabel.setText(Integer.valueOf(unstopCounter).toString());
			paddleExpansionLabel.setText(Integer.valueOf(expansionCounter).toString());

			
		}

	}
	public void setActiveAbility(Ability a) {
		if (a instanceof ChanceGivingAbility) {
			activeAbilityLabel.setText("Chance Giving Ability");
		}
		if (a instanceof MagicalHexAbility) {
			activeAbilityLabel.setText("Magical Hex");
		}
		if (a instanceof UnstoppableBallAbility) {
			activeAbilityLabel.setText("Unstoppable Ball");
			
		}if (a instanceof PaddleExpansionAbility) {
			activeAbilityLabel.setText("Paddle Expansion");
		}
		 
        
		
		
	}
	public void removeAbility(Ability a) {
		activeAbilityLabel.setText("");
        
		
	}



}
