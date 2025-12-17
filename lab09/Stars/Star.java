package lab09.Stars;
import java.awt.Graphics;

public class Star {
    private int x; 
    private int y; 
    private StarType starType; 

    public Star(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.starType = type;
    }

    public void draw(Graphics g) {
        starType.draw(g, x, y); 
    }
}