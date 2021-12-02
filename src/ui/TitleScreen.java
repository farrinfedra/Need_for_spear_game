package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen {

	public JPanel createTitleScreen(int width, int height) {
		 JPanel titleScreen = new JPanel();
	        titleScreen.setLayout(null);
	        titleScreen.setBounds(0,0,width,height);
	        titleScreen.setBackground(Color.RED);
	        JLabel NFS = new JLabel("NEED FOR SPEAR");
	        NFS.setFont(new Font("Helvetica", Font.BOLD, 14));
	        NFS.setBounds(titleScreen.getWidth()/3, titleScreen.getHeight()/5, 150, 20);
	        titleScreen.add(NFS);
	        
	        titleScreen.setVisible(true);
	        titleScreen.revalidate();
	        titleScreen.repaint();
	        
	        JButton playButton = new JButton("Play");
	        JButton buildModeButton = new JButton("Build Mode");
	        JButton loadGameButton = new JButton("Load Game");
	        
	        playButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					titleScreen.setVisible(false);
				}
			});
	       
	        playButton.setSize(100, 30);
	        playButton.setBounds(titleScreen.getBounds().width/2-playButton.getWidth()/2, titleScreen.getBounds().height/2, playButton.getWidth(), playButton.getHeight());
	        titleScreen.add(playButton);
	        
	        buildModeButton.setSize(100,30);
	        buildModeButton.setBounds(titleScreen.getBounds().width/2-playButton.getWidth()/2, titleScreen.getBounds().height/2+playButton.getHeight(), playButton.getWidth(), playButton.getHeight());
	        titleScreen.add(buildModeButton);
	        
	        loadGameButton.setSize(100,30);
	        loadGameButton.setBounds(titleScreen.getBounds().width/2-playButton.getWidth()/2, titleScreen.getBounds().height/2+playButton.getHeight()*2, playButton.getWidth(), playButton.getHeight());
	        titleScreen.add(loadGameButton);
	        
	        return titleScreen;
	}
	
}
