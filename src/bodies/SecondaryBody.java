package bodies;

import java.awt.Color;

public class SecondaryBody {
    private int velocity;
    private int mass;
    private int radius;
    private int x;
    private int y;
    private Color color;

    public SecondaryBody(int velocity, int mass, int radius, int x, int y, Color color) {
        this.velocity = velocity;
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getVelocity() {
        return this.velocity;
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

    public void setVelocity(int x) {
        this.velocity = x;
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
