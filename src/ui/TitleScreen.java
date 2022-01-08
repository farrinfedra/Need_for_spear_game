package ui;

import domain.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TitleScreen extends JFrame {

	Color BACKGROUND_COLOR = new Color(240,230,140);
	Color TEXT_COLOR = new Color(128,128,0);
	GridBagConstraints gbc;
	private String username;
	JButton loadGameButton;
	JButton playButton;
	JButton buildModeButton;
	JButton helpButton;
	public TitleScreen(int width, int height) {
		super("TitleScreen");
		setBounds(0, 0, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gbc = new GridBagConstraints();
		JPanel mainPanel = new JPanel();
		mainPanel(mainPanel);

		JPanel headerPanel = new JPanel();
		headerPanel(mainPanel, headerPanel);

		JPanel usernamePanel = new JPanel();
		usernamePanel(mainPanel, usernamePanel, width, height);


		JPanel buttonsPanel = new JPanel(new GridBagLayout());
		buttonsPanel(mainPanel, buttonsPanel,  width, height);


		setVisible(true);

	}

	private void mainPanel(JPanel mainPanel) {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		add(mainPanel);
	}

	private void headerPanel(JPanel mainPanel, JPanel headerPanel) {
		headerPanel.setLayout(new GridBagLayout());
		ImageIcon iconLogo =new ImageIcon("src/ui/assets/logo.png");
		JLabel NFS = new JLabel(iconLogo);
		NFS.setSize(5000, 5000);
	    NFS.setFont(new Font("Helvetica", Font.BOLD, 20));
	    NFS.setForeground(TEXT_COLOR);
		headerPanel.add(NFS);
		headerPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.add(headerPanel);
	}
	private void usernamePanel(JPanel mainPanel, JPanel usernamePanel, int width, int height) {
		JLabel usernameLabel = new JLabel("Please enter your name");
		usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		usernameLabel.setBounds(width,height - 500, width,600);
		usernameLabel.setForeground(Color.decode("#8b0000"));
		usernamePanel.setBackground(BACKGROUND_COLOR);
		JTextField usernameTextField = new JTextField(20);
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username = usernameTextField.getText();
				Game.getInstance().setPlayerName(username);
				enterButton.setVisible(false);
				usernameTextField.setVisible(false);
				setButtonsVisible();
				usernameLabel.setText("Welcome %s".formatted(username));

			}
		});

		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameTextField);
		usernamePanel.add(enterButton);
		mainPanel.add(usernamePanel);
	}

	private void setButtonsVisible() {
		playButton.setVisible(true);
		buildModeButton.setVisible(true);
		loadGameButton.setVisible(true);
		helpButton.setVisible(true);
	}


	private void buttonsPanel(JPanel mainPanel, JPanel buttonsPanel, int width, int height) {
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;


		 playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RunningScreen();
			}
		});
		 buildModeButton = new JButton("Build Mode");
		buildModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BuildScreen(width, height);
			}
		});

		 helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HelpScreen();
			}
		});

		 loadGameButton = new JButton("Load Game");
		loadGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoadScreen(username);
			}
		});

		gbc.gridx=0;
		gbc.gridy=0;
		buttonsPanel.add(playButton);
		playButton.setVisible(false);
		gbc.gridx=1;
		gbc.gridy=0;
		buttonsPanel.add(buildModeButton);
		buildModeButton.setVisible(false);
		gbc.gridx=2;
		gbc.gridy=0;
		buttonsPanel.add(loadGameButton);
		loadGameButton.setVisible(false);
		gbc.gridx=3;
		gbc.gridy=0;
		buttonsPanel.add(helpButton);
		helpButton.setVisible(false);

		buttonsPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.add(buttonsPanel);


	}

}
