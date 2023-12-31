package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;

    private int xDir = 1;
    private int yDir = 1;

    private int frames = 0;

    private long lastCheck = 0;

    public GamePanel(){

        // initializing mouse inputs
        mouseInputs = new MouseInputs(this);

        // adds key listener to panel
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    // Method to change xDelta and yDelta for movement
    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }

    // Method to draw graphics on to panel
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();

        g.fillRect(xDelta, yDelta, 200, 50);

        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        repaint();
    }

    private void updateRectangle() {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0){
            xDir *= -1;
        }

        yDelta += yDir;
        if(yDelta > 400 || yDelta < 0){
            yDir *= -1;
        }
    }
}
