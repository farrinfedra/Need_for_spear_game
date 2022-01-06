package ui;
import javax.swing.*;


public class LoadScreen extends JFrame {
    private int width;
    private int height;

    public LoadScreen (int width, int height, String username){
        super("LoadScreen");
        this.width = width;
        this.height = height;

        //TODO: pass username
        setBounds(0,0,width,height);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }
}
