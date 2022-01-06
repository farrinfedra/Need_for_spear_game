package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen extends JFrame {

	Color BACKGROUND_COLOR = new Color(240,230,140);
	Color TEXT_COLOR = new Color(128,128,0);
	GridBagConstraints gbc;
	public TitleScreen(int width, int height) {
		super("TitleScreen");
		setBounds(0, 0, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gbc = new GridBagConstraints();
		JPanel mainPanel = new JPanel();
		mainPanel(mainPanel);

		JPanel headerPanel = new JPanel();
		headerPanel(mainPanel, headerPanel);

		JLabel NFS = new JLabel("NEED FOR SPEAR");
		NFS.setFont(new Font("Helvetica", Font.BOLD, 14));
		NFS.setBounds(getWidth()/3, getHeight()/5, 150, 20);
		add(NFS);

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
		NFS.setSize(5000, 50000);
	    NFS.setFont(new Font("Helvetica", Font.BOLD, 20));
	    NFS.setForeground(TEXT_COLOR);
		headerPanel.add(NFS);
		headerPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.add(headerPanel);
	}



	private void buttonsPanel(JPanel mainPanel, JPanel buttonsPanel, int width, int height) {
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;


		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RunningScreen();
			}
		});
		JButton buildModeButton = new JButton("Build Mode");
		buildModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BuildScreen(width, height);
			}
		});

		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HelpScreen();
			}
		});

		JButton loadGameButton = new JButton("Load Game");
		gbc.gridx=0;
		gbc.gridy=0;
		buttonsPanel.add(playButton);
		gbc.gridx=1;
		gbc.gridy=0;
		buttonsPanel.add(buildModeButton);
		gbc.gridx=2;
		gbc.gridy=0;
		buttonsPanel.add(loadGameButton);
		gbc.gridx=3;
		gbc.gridy=0;
		buttonsPanel.add(helpButton);
		buttonsPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.add(buttonsPanel);


	}

}
