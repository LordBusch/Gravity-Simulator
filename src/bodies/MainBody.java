package bodies;

import java.awt.Color;

public class MainBody {
    private int mass;
    private int radius;
    private int x;
    private int y;
    private Color color;

    public MainBody(int mass, int radius, int x, int y, Color color) {
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getMass() {
        return this.mass;
    }
}
