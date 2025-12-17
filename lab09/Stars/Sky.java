package lab09.Stars; 

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<Star> stars = new ArrayList<>();

    public Sky() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void placeStar(Star star) {
        stars.add(star);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}