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
    public int getRadius() {
        return this.radius;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public Color getColor() {
        return this.color;
    }

    public void setMass(int x) {
        this.mass = x;
    }
    public void setRadius(int x) {
        this.radius = x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int x) {
        this.y = x;
    }
    public void setColor(Color x) {
        this.color = x;
    }
}
