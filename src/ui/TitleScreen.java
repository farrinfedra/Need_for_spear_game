package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TitleScreen extends JFrame {

	public TitleScreen(int width, int height){
		super("Title Screen");
		setLayout(null);
		setBounds(0,0,width,height);
		setBackground(Color.RED);
		JLabel NFS = new JLabel("NEED FOR SPEAR");
		NFS.setFont(new Font("Helvetica", Font.BOLD, 14));
		NFS.setBounds(getWidth()/3, getHeight()/5, 150, 20);
		add(NFS);

		setVisible(true);
		revalidate();
		repaint();

		JButton playButton = new JButton("Play");
		JButton buildModeButton = new JButton("Build Mode");
		JButton loadGameButton = new JButton("Load Game");

		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RunningScreen();
			}
		});

		playButton.setSize(100, 30);
		playButton.setBounds(getBounds().width/2-playButton.getWidth()/2, getBounds().height/2, playButton.getWidth(), playButton.getHeight());
		add(playButton);

		buildModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BuildScreen(width, height);
			}
		});

		buildModeButton.setSize(100,30);
		buildModeButton.setBounds(getBounds().width/2-playButton.getWidth()/2, getBounds().height/2+playButton.getHeight(), playButton.getWidth(), playButton.getHeight());
		add(buildModeButton);

		loadGameButton.setSize(100,30);
		loadGameButton.setBounds(getBounds().width/2-playButton.getWidth()/2, getBounds().height/2+playButton.getHeight()*2, playButton.getWidth(), playButton.getHeight());
		add(loadGameButton);
	}
	
}
