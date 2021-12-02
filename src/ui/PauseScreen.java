package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Game;

public class PauseScreen {

	public JPanel createPauseScreen(Game game, JFrame f) {
		JPanel pausedPanel = new JPanel();
        pausedPanel.setLayout(new BorderLayout());
        pausedPanel.setBounds(50,100,200,100);    
        pausedPanel.setBackground(Color.orange);
        pausedPanel.add(new JLabel("Game paused", SwingConstants.CENTER));
        
        JButton resumeButton = new JButton("RESUME");
        resumeButton.setBounds(150, 150, 100, 50);
        
        resumeButton.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e){
     	       //game.resumeGame();
     	       pausedPanel.setVisible(false);
     	       game.switchPaused();
     	   }
        });
        pausedPanel.add(resumeButton, BorderLayout.PAGE_START);
        
        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(150, 150, 100, 50);
        
        saveButton.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e){
     	       game.saveGame();
     	   }
        });
        pausedPanel.add(saveButton, BorderLayout.PAGE_END);
    
        f.add(pausedPanel);  
        pausedPanel.setVisible(true);
        pausedPanel.revalidate();
        pausedPanel.repaint();
        
        return pausedPanel;
	}
}
