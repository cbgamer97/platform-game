package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(){

    }

    // Method to draw graphics on to panel
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);
    }
}
